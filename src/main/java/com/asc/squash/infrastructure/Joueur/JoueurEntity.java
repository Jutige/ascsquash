package com.asc.squash.infrastructure.Joueur;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JoueurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJoueur;
    private String nomJoueur;
    private String prenomJoueur;
    private String mailJoueur;
    private String numeroTelJoueur;

    public JoueurEntity() {
    }

    public JoueurEntity(Long idJoueur, String nomJoueur, String prenomJoueur, String mailJoueur, String numeroTelJoueur) {
        this.idJoueur = idJoueur;
        this.nomJoueur = nomJoueur;
        this.prenomJoueur = prenomJoueur;
        this.mailJoueur = mailJoueur;
        this.numeroTelJoueur = numeroTelJoueur;
    }
}
