package com.asc.squash.application.service;

import com.asc.squash.application.mapper.UserDtoCreateMapper;
import com.asc.squash.domaine.IJoueurDomaine;
import com.asc.squash.domaine.IUserDomaine;
import com.asc.squash.domaine.User;
import com.asc.squash.exposition.dto.UserDto;
import com.asc.squash.exposition.dto.UserDtoCreate;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @Autowired
//    UserDtoCreateMapper userDtoCreateMapper;

    @Override
    public String createUser(UserDtoCreate userDto) {
        if (joueurDomaine.findJoueurById(userDto.getIdUSer()) == null ) {
            return "joueur inexistant";
        }
        User user = new User(userDto.getIdUSer(),
                "0000",
                true,
                userDto.getRoles());
        return userDomaine.create(user);
    }

    @Override
    public List<UserDto> listUserDto() {

        List<UserDto> userDtos = new ArrayList<UserDto>();

        for(User user : userDomaine.findAllUsers()) {
            userDtos.add(new UserDto(user.getNomJoueur(),
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
}
