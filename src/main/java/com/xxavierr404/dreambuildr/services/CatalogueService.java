package com.xxavierr404.dreambuildr.services;

import com.xxavierr404.dreambuildr.models.CPU;
import com.xxavierr404.dreambuildr.models.Motherboard;
import com.xxavierr404.dreambuildr.repositories.CPURepository;
import com.xxavierr404.dreambuildr.repositories.MotherboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueService {
    private final MotherboardRepository motherboardRepository;
    private final CPURepository cpuRepository;

    @Autowired
    public CatalogueService(MotherboardRepository motherboardRepository,
                            CPURepository cpuRepository) {
        this.motherboardRepository = motherboardRepository;
        this.cpuRepository = cpuRepository;
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
}
