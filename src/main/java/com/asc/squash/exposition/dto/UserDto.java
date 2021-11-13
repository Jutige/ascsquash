package com.asc.squash.exposition.dto;

import com.asc.squash.domaine.RoleTypeEnum;

import java.util.Date;
import java.util.Set;

public class UserDto extends JoueurDto {

    private Set<RoleTypeEnum> roles;
    private Date LastDateConnexion;

    public UserDto() {
    }

    public UserDto(String nomJoueur, String prenomJoueur, String mailJoueur, String numeroTelJoueur, Set<RoleTypeEnum> roles, Date lastDateConnexion) {
        super(nomJoueur, prenomJoueur, mailJoueur, numeroTelJoueur);
        this.roles = roles;
        LastDateConnexion = lastDateConnexion;
    }

    public Set<RoleTypeEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleTypeEnum> roles) {
        this.roles = roles;
    }

    public Date getLastDateConnexion() {
        return LastDateConnexion;
    }

    public void setLastDateConnexion(Date lastDateConnexion) {
        LastDateConnexion = lastDateConnexion;
    }
}
