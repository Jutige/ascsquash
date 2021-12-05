package com.asc.squash.infrastructure.Creneau;

import com.asc.squash.domaine.Site;
import com.asc.squash.domaine.StatutEnum;
import com.asc.squash.domaine.User;
import com.asc.squash.infrastructure.Site.SiteEntity;
import com.asc.squash.infrastructure.User.UserEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class CreneauEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdCreneau;
    private Date dateDebut;
    private Date dateFin;
    private int nbJoueursMax;
    @ManyToMany
    private List<UserEntity> listUserCreaneau;
    @ManyToOne
    private SiteEntity siteCreaneau;
    private StatutEnum statutCreneau;

    public CreneauEntity() {
    }

    public CreneauEntity(Long idCreneau, Date dateDebut, Date dateFin, int nbJoueursMax, List<UserEntity> listUserCreaneau, SiteEntity siteCreaneau, StatutEnum statutCreneau) {
        IdCreneau = idCreneau;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbJoueursMax = nbJoueursMax;
        this.listUserCreaneau = listUserCreaneau;
        this.siteCreaneau = siteCreaneau;
        this.statutCreneau = statutCreneau;
    }

    public CreneauEntity(Date dateDebut, Date dateFin, int nbJoueursMax, List<UserEntity> listUserCreaneau, SiteEntity siteCreaneau, StatutEnum statutCreneau) {
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

    public List<UserEntity> getListUserCreaneau() {
        return listUserCreaneau;
    }

    public void setListUserCreaneau(List<UserEntity> listUserCreaneau) {
        this.listUserCreaneau = listUserCreaneau;
    }

    public SiteEntity getSiteCreaneau() {
        return siteCreaneau;
    }

    public void setSiteCreaneau(SiteEntity siteCreaneau) {
        this.siteCreaneau = siteCreaneau;
    }

    public StatutEnum getStatutCreneau() {
        return statutCreneau;
    }

    public void setStatutCreneau(StatutEnum statutCreneau) {
        this.statutCreneau = statutCreneau;
    }
}
