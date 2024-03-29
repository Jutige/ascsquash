package com.asc.squash.infrastructure.User;

import com.asc.squash.domaine.RoleTypeEnum;
import com.asc.squash.infrastructure.Joueur.JoueurEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String idAsc;
    private String password;
    private boolean isAutorized;
    @Temporal(TemporalType.TIMESTAMP)
    private Date LastDateConnexion;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<RoleTypeEnum> roles = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private JoueurEntity joueurEntity;

    public UserEntity() {
    }

    public UserEntity(String idAsc, String password, boolean isAutorized, Set<RoleTypeEnum> roles, JoueurEntity joueurEntity) {
        this.idAsc = idAsc;
        this.password = password;
        this.isAutorized = isAutorized;
        this.roles = roles;
        this.joueurEntity = joueurEntity;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getIdAsc() {
        return idAsc;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idAsc = idUtilisateur;
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

    public Set<RoleTypeEnum> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleTypeEnum> roles) {
        this.roles = roles;
    }

    public JoueurEntity getJoueurEntity() {
        return joueurEntity;
    }

    public void setJoueurEntity(JoueurEntity joueurEntity) {
        this.joueurEntity = joueurEntity;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "idUser=" + idUser +
                ", idAsc='" + idAsc + '\'' +
                ", password='" + password + '\'' +
                ", isAutorized=" + isAutorized +
                ", LastDateConnexion=" + LastDateConnexion +
                ", roles=" + roles +
                ", joueurEntity=" + joueurEntity.toString() +
                '}';
    }
}
