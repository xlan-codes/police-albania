package com.vesa.wazeapi.storage.entities;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("AlertType")
public class AlertTypeEntity extends BaseEntity {

    private String type;

    @Indexed(unique = true)
    private String alertCode;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlertCode() {
        return alertCode;
    }

    public void setAlertCode(String alertCode) {
        this.alertCode = alertCode;
    }
}
