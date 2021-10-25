package com.asc.squash.exposition.dto;

public class JoueurDto {


    private String nomJoueur;
    private String prenomJoueur;
    private String mailJoueur;
    private String numeroTelJoueur;

    public JoueurDto() {
    }

    public JoueurDto(String nomJoueur, String prenomJoueur, String mailJoueur, String numeroTelJoueur) {
        this.nomJoueur = nomJoueur;
        this.prenomJoueur = prenomJoueur;
        this.mailJoueur = mailJoueur;
        this.numeroTelJoueur = numeroTelJoueur;
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
