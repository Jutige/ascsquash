package com.asc.squash.infrastructure.User;

import com.asc.squash.domaine.User;
import com.asc.squash.infrastructure.AbstractMapper;
import com.asc.squash.infrastructure.Joueur.IJoueurRepository;
import com.asc.squash.infrastructure.Joueur.JoueurEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class UserEntityMapper extends AbstractMapper<User,UserEntity> {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IJoueurRepository joueurRepository;

    @Override
    public User mapToDomain(UserEntity entity) {
        return new User(entity.getJoueurEntity().getNomJoueur(),
                entity.getJoueurEntity().getPrenomJoueur(),
                entity.getJoueurEntity().getMailJoueur(),
                entity.getJoueurEntity().getNumeroTelJoueur(),
                entity.getIdMail(),
                entity.getPassword(),
                entity.isAutorized(),
                entity.getLastDateConnexion(),
                entity.getRoles());
    }

    @Override
    public UserEntity mapToEntity(User dto) {

        JoueurEntity joueurEntity = joueurRepository.findByMailJoueur(dto.getMailJoueur());
        return new UserEntity(dto.getIdUser(),
                dto.getPassword(),
                dto.isAutorized(),
                dto.getRole(),
                joueurEntity);
    }
}
