package com.vesa.wazeapi.dto;

import java.io.Serializable;

public class AlertDto extends BaseDto{

    public float rating;
    public long addedDate;
    public double lat;
    public double lng;
    public String name;
    public String type;
    public String vicinity;
    public String formattedAddress;
    public String icon;


    public long getAddedDate() {
        return this.addedDate;
    }

    public String getFormattedAddress() {
        return this.formattedAddress;
    }

    public String getIcon() {
        return this.icon;
    }

    public double getLat() {
        return this.lat;
    }

    public float getRating() {
        return this.rating;
    }

    public double getLng() {
        return this.lng;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getVicinity() {
        return this.vicinity;
    }

    public void setAddedDate(long j) {
        this.addedDate = j;
    }

    public void setFormattedAddress(String str) {
        this.formattedAddress = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLng(double d) {
        this.lng = d;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRating(float f) {
        this.rating = f;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVicinity(String str) {
        this.vicinity = str;
    }

}
