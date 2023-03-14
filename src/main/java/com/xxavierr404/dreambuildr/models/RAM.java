package com.xxavierr404.dreambuildr.models;

import com.xxavierr404.dreambuildr.misc.enums.RAMType;
import jakarta.persistence.Entity;

@Entity
public class RAM extends Item {
    public RAM() {}

    private RAMType type;
    private Integer frequency;
    private Integer gigabytes;

    public RAMType getType() {
        return type;
    }

    public void setType(RAMType type) {
        this.type = type;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getGigabytes() {
        return gigabytes;
    }

    public void setGigabytes(Integer gigabytes) {
        this.gigabytes = gigabytes;
    }
}
