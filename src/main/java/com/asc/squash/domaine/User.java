package com.asc.squash.domaine;

import java.util.Date;
import java.util.Set;

public class User extends Joueur {

    private String idUser;
    private String password;
    private boolean isAutorized;
    private Date LastDateConnexion;
    private Set<RoleTypeEnum> role;

    public User() {
    }

    public User(String idAsc, String nomJoueur, String prenomJoueur, String mailJoueur, String numeroTelJoueur, String idUser, String password, boolean isAutorized, Date lastDateConnexion, Set<RoleTypeEnum> role) {
        super(nomJoueur, prenomJoueur, mailJoueur, numeroTelJoueur, idAsc);
        this.idUser = idUser;
        this.password = password;
        this.isAutorized = isAutorized;
        LastDateConnexion = lastDateConnexion;
        this.role = role;
    }

    public User(String idUser, String password, boolean isAutorized, Set<RoleTypeEnum> role) {
        this.idUser = idUser;
        this.password = password;
        this.isAutorized = isAutorized;
        this.role = role;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAutorized() {
        return isAutorized;
    }

    public void setAutorized(boolean autorized) {
        isAutorized = autorized;
    }

    public Date getLastDateConnexion() {
        return LastDateConnexion;
    }

    public void setLastDateConnexion(Date lastDateConnexion) {
        LastDateConnexion = lastDateConnexion;
    }

    public Set<RoleTypeEnum> getRole() {
        return role;
    }

    public void setRole(Set<RoleTypeEnum> role) {
        this.role = role;
    }
}
