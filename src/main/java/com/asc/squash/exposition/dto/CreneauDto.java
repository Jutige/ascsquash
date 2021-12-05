package com.asc.squash.exposition.dto;

import com.asc.squash.domaine.Site;
import com.asc.squash.domaine.StatutEnum;
import com.asc.squash.domaine.User;

import java.util.Date;
import java.util.List;

public class CreneauDto {

    private Date dateDebut;
    private Date dateFin;
    private int nbJoueursMax;
    private List<User> listUserCreaneau;
    private Site siteCreaneau;
    private StatutEnum statutCreneau;

    public CreneauDto() {
    }

    public CreneauDto(Date dateDebut, Date dateFin, int nbJoueursMax, List<User> listUserCreaneau, Site siteCreaneau, StatutEnum statutCreneau) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbJoueursMax = nbJoueursMax;
        this.listUserCreaneau = listUserCreaneau;
        this.siteCreaneau = siteCreaneau;
        this.statutCreneau = statutCreneau;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbJoueursMax() {
        return nbJoueursMax;
    }

    public void setNbJoueursMax(int nbJoueursMax) {
        this.nbJoueursMax = nbJoueursMax;
    }

    public List<User> getListUserCreaneau() {
        return listUserCreaneau;
    }

    public void setListUserCreaneau(List<User> listUserCreaneau) {
        this.listUserCreaneau = listUserCreaneau;
    }

    public Site getSiteCreaneau() {
        return siteCreaneau;
    }

    public void setSiteCreaneau(Site siteCreaneau) {
        this.siteCreaneau = siteCreaneau;
    }

    public StatutEnum getStatutCreneau() {
        return statutCreneau;
    }

    public void setStatutCreneau(StatutEnum statutCreneau) {
        this.statutCreneau = statutCreneau;
    }
}
