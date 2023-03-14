package com.xxavierr404.dreambuildr.services;

import com.xxavierr404.dreambuildr.models.*;
import com.xxavierr404.dreambuildr.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CatalogueService {
    private final MotherboardRepository motherboardRepository;
    private final CPURepository cpuRepository;
    private final RAMRepository ramRepository;
    private final DriveRepository driveRepository;
    private final PowerUnitRepository powerUnitRepository;
    private final VideocardRepository videocardRepository;

    @Autowired
    public CatalogueService(MotherboardRepository motherboardRepository,
                            CPURepository cpuRepository,
                            RAMRepository ramRepository,
                            DriveRepository driveRepository,
                            PowerUnitRepository powerUnitRepository,
                            VideocardRepository videocardRepository) {
        this.motherboardRepository = motherboardRepository;
        this.cpuRepository = cpuRepository;
        this.ramRepository = ramRepository;
        this.driveRepository = driveRepository;
        this.powerUnitRepository = powerUnitRepository;
        this.videocardRepository = videocardRepository;
    }

    public List<Motherboard> getMotherboardsByIdBetween(Long start, Long end) {
        return motherboardRepository.findAllByIdBetween(start, end);
    }

    public void addNewMotherboard(Motherboard motherboard) {
        motherboardRepository.save(motherboard);
    }

    public List<CPU> getCPUsByIdBetween(Long start, Long end) {
        return cpuRepository.findAllByIdBetween(start, end);
    }

    public void addNewCPU(CPU cpu) {
        cpuRepository.save(cpu);
    }

    public List<RAM> getRAMsByIdBetween(Long start, Long end) {
        return ramRepository.findAllByIdBetween(start, end);
    }

    public void addNewRAM(RAM ram) {
        ramRepository.save(ram);
    }

    public List<Drive> getDrivesByIdBetween(Long start, Long end) {
        return driveRepository.findAllByIdBetween(start, end);
    }

    public void addNewDrive(Drive drive) {
        driveRepository.save(drive);
    }

    public List<PowerUnit> getPUsByIdBetween(Long start, Long end) {
        return powerUnitRepository.findAllByIdBetween(start, end);
    }

    public void addNewPowerUnit(PowerUnit powerUnit) {
        powerUnitRepository.save(powerUnit);
    }

    public List<Videocard> getVideocardsByIdBetween(Long start, Long end) {
        return videocardRepository.findAllByIdBetween(start, end);
    }

    public void addNewVideocard(Videocard videocard) {
        videocardRepository.save(videocard);
    }

    public List<Item> getAllItems(Long start, Long end) {
        var result = new LinkedList<Item>();
        result.addAll(getMotherboardsByIdBetween(start, end));
        result.addAll(getCPUsByIdBetween(start, end));
        result.addAll(getRAMsByIdBetween(start, end));
        result.addAll(getPUsByIdBetween(start, end));
        result.addAll(getDrivesByIdBetween(start, end));
        result.addAll(getVideocardsByIdBetween(start, end));
        return result;
    }
}
