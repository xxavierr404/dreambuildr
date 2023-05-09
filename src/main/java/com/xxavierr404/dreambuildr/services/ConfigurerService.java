package com.xxavierr404.dreambuildr.services;

import com.xxavierr404.dreambuildr.dto.PCConfigurationDTO;
import com.xxavierr404.dreambuildr.misc.objects.PCConfiguration;
import org.springframework.stereotype.Service;

@Service
public class ConfigurerService {
    private final CatalogueService catalogueService;

    public ConfigurerService(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    public PCConfiguration buildConfigurationFromDTO(PCConfigurationDTO dto) {
        var configuration = new PCConfiguration();

        configuration.setMotherboard(catalogueService.getMotherboard(dto.getMotherboardId()));
        configuration.setCpu(catalogueService.getCPU(dto.getCpuId()));
        configuration.setRam(catalogueService.getRam(dto.getRamId()));
        configuration.setDrive(catalogueService.getDrive(dto.getDriveId()));
        configuration.setPowerUnit(catalogueService.getPowerUnit(dto.getPowerUnitId()));
        configuration.setVideocard(catalogueService.getVideocard(dto.getVideocardId()));

        return configuration;
    }

    public void verifyConfiguration(PCConfigurationDTO dto) {
        var configuration = buildConfigurationFromDTO(dto);
        configuration.isCompatible();
    }
}
