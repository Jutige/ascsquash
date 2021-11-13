package com.asc.squash.infrastructure.Info;



import com.asc.squash.infrastructure.User.UserEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class InfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInfo;

    private String title;
    private String body;
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private UserEntity userCreate;

    public InfoEntity() {
    }

    public InfoEntity(Long idInfo, String title, String body, Date creationDate, UserEntity userCreate) {
        this.idInfo = idInfo;
        this.title = title;
        this.body = body;
        this.creationDate = creationDate;
        this.userCreate = userCreate;
    }

    public InfoEntity(String title, String body, Date creationDate, UserEntity userCreate) {
        this.title = title;
        this.body = body;
        this.creationDate = creationDate;
        this.userCreate = userCreate;
    }

    public Long getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(Long idInfo) {
        this.idInfo = idInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public UserEntity getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(UserEntity userCreate) {
        this.userCreate = userCreate;
    }
}
