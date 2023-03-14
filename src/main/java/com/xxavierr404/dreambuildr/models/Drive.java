package com.xxavierr404.dreambuildr.models;

import com.xxavierr404.dreambuildr.misc.enums.DriveType;

public class Drive extends Item {
    public Drive() {}
    private DriveType type;
    private Integer gigabytes;

    public DriveType getType() {
        return type;
    }

    public void setType(DriveType type) {
        this.type = type;
    }

    public Integer getGigabytes() {
        return gigabytes;
    }

    public void setGigabytes(Integer gigabytes) {
        this.gigabytes = gigabytes;
    }
}
