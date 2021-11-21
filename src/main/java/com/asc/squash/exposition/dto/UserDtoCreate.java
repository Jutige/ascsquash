package com.asc.squash.exposition.dto;

import com.asc.squash.domaine.RoleTypeEnum;

import java.util.Set;

public class UserDtoCreate extends JoueurDto{

    private String idUser;
    private Set<RoleTypeEnum> roles;

    public UserDtoCreate() {
    }

    public UserDtoCreate(String idUSer, Set<RoleTypeEnum> roles) {
        this.idUser = idUSer;
        this.roles = roles;
    }

    public UserDtoCreate(String nomJoueur, String prenomJoueur, String mailJoueur, String numeroTelJoueur, String idAsc, String idUSer, Set<RoleTypeEnum> roles) {
        super(nomJoueur, prenomJoueur, mailJoueur, numeroTelJoueur, idAsc);
        this.idUser = idUSer;
        this.roles = roles;
    }

    public String getIdUSer() {
        return idUser;
    }

    public void setIdUSer(String idUSer) {
        this.idUser = idUSer;
    }

    public Set<RoleTypeEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleTypeEnum> roles) {
        this.roles = roles;
    }
}
