package com.asc.squash.infrastructure.User;

import com.asc.squash.infrastructure.Joueur.JoueurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByIdAsc(String idUser);

    List<UserEntity> findByIdAscNotNull();

}