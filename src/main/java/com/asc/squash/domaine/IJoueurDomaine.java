package com.asc.squash.domaine;

import java.util.List;

public interface IJoueurDomaine {

    boolean create(Joueur joueur);

    List<Joueur> findAllJoueur();

    Joueur UpdateJoueur(Joueur joueur);

    boolean deleteJoueur(String email);


    Joueur findJoueurById(String idUSer);
}
