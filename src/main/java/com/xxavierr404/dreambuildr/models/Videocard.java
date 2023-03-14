package com.xxavierr404.dreambuildr.models;

import com.xxavierr404.dreambuildr.misc.enums.RAMType;

public class Videocard extends Item {
    public Videocard() {}

    private Integer vRam;
    private RAMType vRamType;
    private Integer frequency;

    public Integer getvRam() {
        return vRam;
    }

    public void setvRam(Integer vRam) {
        this.vRam = vRam;
    }

    public RAMType getvRamType() {
        return vRamType;
    }

    public void setvRamType(RAMType vRamType) {
        this.vRamType = vRamType;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
