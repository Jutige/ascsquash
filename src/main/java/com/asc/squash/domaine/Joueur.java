package com.asc.squash.domaine;

public class Joueur {

    private String idAsc;
    private String nomJoueur;
    private String prenomJoueur;
    private String mailJoueur;
    private String numeroTelJoueur;

    public Joueur() {
    }

    public Joueur(String nomJoueur, String prenomJoueur, String mailJoueur, String numeroTelJoueur, String idAsc) {
        this.nomJoueur = nomJoueur;
        this.prenomJoueur = prenomJoueur;
        this.mailJoueur = mailJoueur;
        this.numeroTelJoueur = numeroTelJoueur;
        this.idAsc = idAsc;
    }

    public String getIdAsc() {
        return idAsc;
    }

    public void setIdAsc(String idAsc) {
        this.idAsc = idAsc;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public String getPrenomJoueur() {
        return prenomJoueur;
    }

    public void setPrenomJoueur(String prenomJoueur) {
        this.prenomJoueur = prenomJoueur;
    }

    public String getMailJoueur() {
        return mailJoueur;
    }

    public void setMailJoueur(String mailJoueur) {
        this.mailJoueur = mailJoueur;
    }

    public String getNumeroTelJoueur() {
        return numeroTelJoueur;
    }

    public void setNumeroTelJoueur(String numeroTelJoueur) {
        this.numeroTelJoueur = numeroTelJoueur;
    }
}
