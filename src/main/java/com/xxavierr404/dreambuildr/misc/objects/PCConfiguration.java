package com.xxavierr404.dreambuildr.misc.objects;

import com.xxavierr404.dreambuildr.models.*;

public class PCConfiguration {
    private Motherboard motherboard;
    private CPU cpu;
    private Drive drive;
    private PowerUnit powerUnit;
    private RAM ram;
    private Videocard videocard;
    private String incompatibilityCause;

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

    }

    private boolean hasCPU() {
        if (cpu == null) {
            incompatibilityCause = "CPU is not selected";
        }
        return cpu != null;
    }

    private boolean hasRam() {
        if (ram == null) {
            incompatibilityCause = "RAM is not selected";
        }
        return ram != null;
    }

    private boolean hasMotherboard() {
        if (motherboard == null) {
            incompatibilityCause = "Motherboard is not selected";
        }
        return motherboard != null;
    }

    private boolean hasDrive() {
        if (drive == null) {
            incompatibilityCause = "Drive is not selected";
        }
        return drive != null;
    }

    private boolean isCPUCompatible() {
        var result = cpu.getSocketType().equals(motherboard.getSocketType());
        if (!result) {
            incompatibilityCause = "CPU is not compatible with this motherboard";
        }
        return result;
    }

    private boolean isRAMCompatible() {
        var result = ram.getType().equals(motherboard.getRamType());
        if (!result) {
            incompatibilityCause = "RAM is not compatible with this motherboard";
        }
        return result;
    }

    private boolean isDriveCompatible() {
        var result = drive.getGigabytes() < 150;
        if (!result) {
            incompatibilityCause = "WARNING: HDD/SSD might be too small";
        }
        return result;
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
