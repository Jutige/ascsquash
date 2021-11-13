package com.asc.squash.domaine;

import java.util.Date;

public class Info {

    private String title;
    private String body;
    private Date creationDate;
    private Date updateDate;
    private User userCreate;
    private Long IdInfo;

    public Info() {
    }

    public Info(String title, String body, Date creationDate, Date updateDate, User userCreate) {
        this.title = title;
        this.body = body;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.userCreate = userCreate;
    }

    public Info(String title, String body, Date creationDate, Date updateDate, User userCreate, Long idInfo) {
        this.title = title;
        this.body = body;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.userCreate = userCreate;
        IdInfo = idInfo;
    }

    public Long getIdInfo() {
        return IdInfo;
    }

    public void setIdInfo(Long idInfo) {
        IdInfo = idInfo;
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

    public User getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(User userCreate) {
        this.userCreate = userCreate;
    }
}
