package com.asc.squash.domaine;

import java.util.Date;
import java.util.List;

public class Creneau {

    private Long IdCreneau;
    private Date dateDebut;
    private Date dateFin;
    private int nbJoueursMax;
    private List<User> listUserCreaneau;
    private Site siteCreaneau;
    private StatutEnum statutCreneau;

    public Creneau() {
    }

    public Creneau(Long idCreneau, Date dateDebut, Date dateFin, int nbJoueursMax, List<User> listUserCreaneau, Site siteCreaneau, StatutEnum statutCreneau) {
        IdCreneau = idCreneau;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbJoueursMax = nbJoueursMax;
        this.listUserCreaneau = listUserCreaneau;
        this.siteCreaneau = siteCreaneau;
        this.statutCreneau = statutCreneau;
    }

    public Long getIdCreneau() {
        return IdCreneau;
    }

    public void setIdCreneau(Long idCreneau) {
        IdCreneau = idCreneau;
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
