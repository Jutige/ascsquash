package com.asc.squash.exposition.dto;

import com.asc.squash.domaine.RoleTypeEnum;

import java.util.Set;

public class UserDtoCreate {

    private String idUSer;
    private Set<RoleTypeEnum> roles;

    public String getIdUSer() {
        return idUSer;
    }

    public void setIdUSer(String idUSer) {
        this.idUSer = idUSer;
    }

    public Set<RoleTypeEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleTypeEnum> roles) {
        this.roles = roles;
    }
}
