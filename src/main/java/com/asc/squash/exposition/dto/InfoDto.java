package com.asc.squash.exposition.dto;

import com.asc.squash.domaine.User;

import java.util.Date;

public class InfoDto {

    private String title;
    private String body;
    private Date creationDate;
    private Date updateDate;
    private String idUser;
    private boolean notification;

    public InfoDto() {
    }

    public InfoDto(String title, String body, Date creationDate, Date updateDate, String idUser, boolean notification) {
        this.title = title;
        this.body = body;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.idUser = idUser;
        this.notification = notification;
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }
}
