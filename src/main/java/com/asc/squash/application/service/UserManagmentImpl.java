package com.asc.squash.application.service;

import com.asc.squash.application.UtilisateurDetailService;
import com.asc.squash.application.mapper.UserDtoCreateMapper;
import com.asc.squash.domaine.IJoueurDomaine;
import com.asc.squash.domaine.IMailDomaine;
import com.asc.squash.domaine.IUserDomaine;
import com.asc.squash.domaine.User;
import com.asc.squash.exposition.dto.UserDto;
import com.asc.squash.exposition.dto.UserDtoCreate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserManagmentImpl implements IUserManagment{

    @Autowired
    IUserDomaine userDomaine;

    @Autowired
    IJoueurDomaine joueurDomaine;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserDtoCreateMapper userDtoCreateMapper;

    @Autowired
    private IMailDomaine mailSenderProfile;

    private static Logger logger = LoggerFactory.getLogger(UserManagmentImpl.class);

    @Override
    public String createUser(UserDtoCreate userDto) {
        if (joueurDomaine.findJoueurById(userDto.getIdUSer()) == null ) {
            User user = userDtoCreateMapper.mapToUser(userDto);
            user.setIdUser(userDto.getIdUSer());
            user.setPassword(passwordEncoder.encode("0000"));
            return userDomaine.createWithJoueur(user);
        }

        User user = new User(userDto.getIdUSer(),
                passwordEncoder.encode("0000"),
                true,
                userDto.getRoles());
        try {
            String subject = "création compte ASC Squash";
            String message = "Bonjour," + "\n\n" + "Le mot de passe pour accéder à l'application est : " + "\n\n" +
                    "0000" + "\n\n" +
                    "Merci de le modifier à la première connexion";
            mailSenderProfile.sendMail(subject,message,userDto.getMailJoueur());
            logger.info("Mail envoyé");
            return userDomaine.create(user);

        }catch (Exception e) {
            logger.error("Problème envoi de mail");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<UserDto> listUserDto() {

        List<UserDto> userDtos = new ArrayList<UserDto>();

        for(User user : userDomaine.findAllUsers()) {
            userDtos.add(new UserDto(user.getIdAsc(),
                    user.getNomJoueur(),
                    user.getPrenomJoueur(),
                    user.getMailJoueur(),
                    user.getNumeroTelJoueur(),
                    user.getRole(),
                    user.getLastDateConnexion()));
        }
        return userDtos;
    }

    @Override
    public String deleteUser(String mail) {

        if (userDomaine.deleteUser(mail)){
            return "suppression effectuée";
        }else {
            return "suppression non effectuée";
        }
    }

    @Override
    public UserDto findUserById(String idUser) {
        logger.info("userId : " + idUser);
        User user = userDomaine.findByIdUser(idUser);
        return new UserDto(user.getIdAsc(),
                user.getNomJoueur(),
                user.getPrenomJoueur(),
                user.getMailJoueur(),
                user.getNumeroTelJoueur(),
                user.getRole(),
                user.getLastDateConnexion());
    }

    @Override
    public void updateDateConnexion(String username) {
        userDomaine.updateDateConnexion(username);
    }
}
