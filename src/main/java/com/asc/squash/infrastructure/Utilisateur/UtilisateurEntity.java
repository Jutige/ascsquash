package com.asc.squash.infrastructure.Utilisateur;

import com.asc.squash.domaine.RoleTypeEnum;
import com.asc.squash.infrastructure.Joueur.JoueurEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UtilisateurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String idUtilisateur;
    private String password;
    private boolean isAutorized;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date LastDateConnexion;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<RoleTypeEnum> roles = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private JoueurEntity joueurEntity;

    public UtilisateurEntity() {
    }

    public UtilisateurEntity(Long idUser, String idUtilisateur, String password, boolean isAutorized, Date lastDateConnexion, Set<RoleTypeEnum> roles, JoueurEntity joueurEntity) {
        this.idUser = idUser;
        this.idUtilisateur = idUtilisateur;
        this.password = password;
        this.isAutorized = isAutorized;
        LastDateConnexion = lastDateConnexion;
        this.roles = roles;
        this.joueurEntity = joueurEntity;
    }
}
