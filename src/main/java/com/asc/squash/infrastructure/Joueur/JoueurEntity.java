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
    private String idAsc;
    private String nomJoueur;
    private String prenomJoueur;
    private String mailJoueur;
    private String numeroTelJoueur;

    public JoueurEntity() {
    }

    public JoueurEntity(String nomJoueur, String prenomJoueur, String mailJoueur, String numeroTelJoueur, String idAsc) {
        this.nomJoueur = nomJoueur;
        this.prenomJoueur = prenomJoueur;
        this.mailJoueur = mailJoueur;
        this.numeroTelJoueur = numeroTelJoueur;
        this.idAsc = idAsc;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public String getPrenomJoueur() {
        return prenomJoueur;
    }

    public String getMailJoueur() {
        return mailJoueur;
    }

    public String getNumeroTelJoueur() {
        return numeroTelJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public void setPrenomJoueur(String prenomJoueur) {
        this.prenomJoueur = prenomJoueur;
    }

    public void setNumeroTelJoueur(String numeroTelJoueur) {
        this.numeroTelJoueur = numeroTelJoueur;
    }

    public String getIdAsc() {
        return idAsc;
    }

    public void setIdAsc(String idAsc) {
        this.idAsc = idAsc;
    }

    public void setMailJoueur(String mailJoueur) {
        this.mailJoueur = mailJoueur;
    }
}
