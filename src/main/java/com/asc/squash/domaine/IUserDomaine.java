package com.asc.squash.domaine;

import java.util.List;

public interface IUserDomaine {

    String create(User user);

    List<User> findAllUsers();

    boolean deleteUser(String mail);

    User findByIdUser(String idUser);

    String createWithJoueur(User mapToUser);

    void updateDateConnexion(String username);

    User updateUser(User user);
}
