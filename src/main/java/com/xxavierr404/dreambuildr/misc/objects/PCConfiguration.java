package com.xxavierr404.dreambuildr.misc.objects;

import com.xxavierr404.dreambuildr.misc.exceptions.ComponentNotInstalledException;
import com.xxavierr404.dreambuildr.model.*;

import java.util.Map;

public class PCConfiguration {
    private Motherboard motherboard;
    private CPU cpu;
    private Drive drive;
    private PowerUnit powerUnit;
    private RAM ram;
    private Videocard videocard;

    public PCConfiguration() { }

    public PCConfiguration(Motherboard motherboard, CPU cpu, Drive drive, PowerUnit powerUnit, RAM ram, Videocard videocard) {
        this.motherboard = motherboard;
        this.cpu = cpu;
        this.drive = drive;
        this.powerUnit = powerUnit;
        this.ram = ram;
        this.videocard = videocard;
    }

    public boolean isCompatible() {
        var components = Map.of(
                Map.entry("CPU", cpu),
                Map.entry("RAM", ram),
                Map.entry("Drive", drive),
                Map.entry("Power unit", powerUnit),
                Map.entry("Videocard", videocard),
                Map.entry("Motherboard", motherboard)
        );

        for (var entry: components.entrySet()) {
            if (entry.getValue() == null) {
                throw new ComponentNotInstalledException(String.format("%s is not selected", entry.getKey()));
            }
        }

        var checkables = new Checkable[] {cpu, ram, drive, powerUnit, videocard};
        for (var checkable: checkables) {
            checkable.checkCompatibility(this);
        }

        return true;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public PowerUnit getPowerUnit() {
        return powerUnit;
    }

    public void setPowerUnit(PowerUnit powerUnit) {
        this.powerUnit = powerUnit;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Videocard getVideocard() {
        return videocard;
    }

    public void setVideocard(Videocard videocard) {
        this.videocard = videocard;
    }
}
