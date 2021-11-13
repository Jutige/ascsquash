package com.asc.squash.infrastructure.User;

import com.asc.squash.domaine.IUserDomaine;
import com.asc.squash.domaine.User;
import com.asc.squash.infrastructure.Joueur.IJoueurRepository;
import com.asc.squash.infrastructure.Joueur.JoueurEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserDomaine {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IJoueurRepository joueurRepository;

    @Override
    public String create(User user) {

        if (userRepository.findByIdMail(user.getIdUser()) !=null) {
            return "user existant";
        }
        JoueurEntity joueurEntity = joueurRepository.findByMailJoueur(user.getIdUser());
        UserEntity userEntity = new UserEntity(user.getIdUser(),
                user.getPassword(),
                user.isAutorized(),
                user.getRole(),
                joueurEntity);
        userRepository.save(userEntity);

        return "création effectuée";
    }

    @Override
    public List<User> findAllUsers() {

        List<User> users = new ArrayList<User>();
        for (UserEntity userEntity : userRepository.findByIdMailNotNull()){
            users.add(new User(userEntity.getJoueurEntity().getNomJoueur(),
                    userEntity.getJoueurEntity().getPrenomJoueur(),
                    userEntity.getJoueurEntity().getMailJoueur(),
                    userEntity.getJoueurEntity().getNumeroTelJoueur(),
                    userEntity.getIdMail(),
                    "",
                    userEntity.isAutorized(),
                    userEntity.getLastDateConnexion(),
                    userEntity.getRoles()));
        }
        return users;
    }

    @Override
    public boolean deleteUser(String mail) {

        UserEntity userEntity = userRepository.findByIdMail(mail);
        if (userEntity == null) {
            return false;
        }else {
            userRepository.delete(userEntity);
            return true;
        }
    }

    @Override
    public User findByIdUser(String idUser) {
        UserEntity userEntity = userRepository.findByIdMail(idUser);
        return new User(userEntity.getJoueurEntity().getNomJoueur(),
                userEntity.getJoueurEntity().getPrenomJoueur(),
                userEntity.getJoueurEntity().getMailJoueur(),
                userEntity.getJoueurEntity().getNumeroTelJoueur(),
                userEntity.getIdMail(),
                "",
                userEntity.isAutorized(),
                userEntity.getLastDateConnexion(),
                userEntity.getRoles());
    }
}
