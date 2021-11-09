package com.asc.squash.infrastructure.Joueur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJoueurRepository extends JpaRepository<JoueurEntity, Long> {

    JoueurEntity findByMailJoueur(String email);
    List<JoueurEntity> findByMailJoueurNotNull();
}
