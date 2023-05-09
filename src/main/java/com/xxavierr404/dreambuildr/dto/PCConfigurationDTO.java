package com.xxavierr404.dreambuildr.dto;

import java.io.Serializable;

public class PCConfigurationDTO implements Serializable {
    private Long motherboardId;
    private Long cpuId;
    private Long driveId;
    private Long powerUnitId;
    private Long ramId;
    private Long videocardId;

    public PCConfigurationDTO(Long motherboardId, Long cpuId, Long driveId, Long powerUnitId, Long ramId, Long videocardId) {
        this.motherboardId = motherboardId;
        this.cpuId = cpuId;
        this.driveId = driveId;
        this.powerUnitId = powerUnitId;
        this.ramId = ramId;
        this.videocardId = videocardId;
    }

    public PCConfigurationDTO() {
    }

    public Long getMotherboardId() {
        return motherboardId;
    }

    public void setMotherboardId(Long motherboardId) {
        this.motherboardId = motherboardId;
    }

    public Long getCpuId() {
        return cpuId;
    }

    public void setCpuId(Long cpuId) {
        this.cpuId = cpuId;
    }

    public Long getDriveId() {
        return driveId;
    }

    public void setDriveId(Long driveId) {
        this.driveId = driveId;
    }

    public Long getPowerUnitId() {
        return powerUnitId;
    }

    public void setPowerUnitId(Long powerUnitId) {
        this.powerUnitId = powerUnitId;
    }

    public Long getRamId() {
        return ramId;
    }

    public void setRamId(Long ramId) {
        this.ramId = ramId;
    }

    public Long getVideocardId() {
        return videocardId;
    }

    public void setVideocardId(Long videocardId) {
        this.videocardId = videocardId;
    }
}
