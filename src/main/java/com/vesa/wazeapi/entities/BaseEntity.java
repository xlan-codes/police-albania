package com.vesa.wazeapi.entities;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;


//@Document(collation = "base")
public class BaseEntity {

    @Id
    private String id;

    @CreatedDate
    private LocalDateTime created = new LocalDateTime();

    @LastModifiedDate
    private LocalDateTime modified = new LocalDateTime();

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

}
