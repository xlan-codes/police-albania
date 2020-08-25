package com.vesa.wazeapi.storage.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

public class BaseAlertEntity extends BaseEntity {


    private String type;

    @DBRef
    private AlertTypeEntity alertType;

    @DBRef
    private UserEntity user;

    private Date submitDateTime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AlertTypeEntity getAlertType() {
        return alertType;
    }

    public void setAlertType(AlertTypeEntity alertType) {
        this.alertType = alertType;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Date getSubmitDateTime() {
        return submitDateTime;
    }

    public void setSubmitDateTime(Date submitDateTime) {
        this.submitDateTime = submitDateTime;
    }
}
