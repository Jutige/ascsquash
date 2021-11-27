package com.asc.squash.infrastructure.User;

import com.asc.squash.domaine.IUserDomaine;
import com.asc.squash.domaine.User;
import com.asc.squash.infrastructure.Joueur.IJoueurRepository;
import com.asc.squash.infrastructure.Joueur.JoueurEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserDomaine {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IJoueurRepository joueurRepository;

    private static Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Override
    public String create(User user) {

        if (userRepository.findByIdAsc(user.getIdUser()) !=null) {
            return "user existant";
        }
        JoueurEntity joueurEntity = joueurRepository.findByIdAsc(user.getIdUser());
        UserEntity userEntity = new UserEntity(user.getIdUser(),
                user.getPassword(),
                user.isAutorized(),
                user.getRole(),
                joueurEntity);
        Date date = new Date();
        userEntity.setLastDateConnexion(date);
        logger.info(userEntity.toString());
        userRepository.save(userEntity);

        return "création effectuée";
    }


    @Override
    public String createWithJoueur(User user) {
        JoueurEntity joueurEntity = new JoueurEntity(
                user.getNomJoueur(),
                user.getPrenomJoueur(),
                user.getMailJoueur(),
                user.getNumeroTelJoueur(),
                user.getIdAsc()
        );
        UserEntity userEntity = new UserEntity(user.getIdUser(),
                user.getPassword(),
                user.isAutorized(),
                user.getRole(),
                joueurEntity);
        Date date = new Date();
        userEntity.setLastDateConnexion(date);
        logger.info(userEntity.toString());
        userRepository.save(userEntity);
        logger.info(userRepository.findByIdAsc(userEntity.getIdAsc()).toString());
        return "création effectuée";
    }

    @Override
    public void updateDateConnexion(String username) {
        Date date = new Date();
        UserEntity userEntity = userRepository.findByIdAsc(username);
        userEntity.setLastDateConnexion(date);
        userRepository.save(userEntity);
        logger.info("date de connexion MAJ "+date);
     }

    @Override
    public List<User> findAllUsers() {

        List<User> users = new ArrayList<User>();
        for (UserEntity userEntity : userRepository.findByIdAscNotNull()){
            users.add(new User(userEntity.getJoueurEntity().getIdAsc(),
                    userEntity.getJoueurEntity().getNomJoueur(),
                    userEntity.getJoueurEntity().getPrenomJoueur(),
                    userEntity.getJoueurEntity().getMailJoueur(),
                    userEntity.getJoueurEntity().getNumeroTelJoueur(),
                    userEntity.getIdAsc(),
                    userEntity.getPassword(),
                    userEntity.isAutorized(),
                    userEntity.getLastDateConnexion(),
                    userEntity.getRoles()));
        }
        return users;
    }

    @Override
    public boolean deleteUser(String idAsc) {

        UserEntity userEntity = userRepository.findByIdAsc(idAsc);
        if (userEntity == null) {
            return false;
        }else {
            userRepository.delete(userEntity);
            return true;
        }
    }

    @Override
    public User findByIdUser(String idUser) {
        logger.info("idUser en entrée : " + idUser);
        UserEntity userEntity = userRepository.findByIdAsc(idUser);
        if (userEntity != null) {
            return new User(userEntity.getJoueurEntity().getIdAsc(),
                    userEntity.getJoueurEntity().getNomJoueur(),
                    userEntity.getJoueurEntity().getPrenomJoueur(),
                    userEntity.getJoueurEntity().getMailJoueur(),
                    userEntity.getJoueurEntity().getNumeroTelJoueur(),
                    userEntity.getIdAsc(),
                    userEntity.getPassword(),
                    userEntity.isAutorized(),
                    userEntity.getLastDateConnexion(),
                    userEntity.getRoles());
        }else {
            return null;
        }
    }


}
