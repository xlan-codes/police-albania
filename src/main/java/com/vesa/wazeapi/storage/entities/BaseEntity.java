package com.vesa.wazeapi.storage.entities;

import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;


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
