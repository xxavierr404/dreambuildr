package com.xxavierr404.dreambuildr.controllers;

import com.xxavierr404.dreambuildr.dto.PCConfigurationDTO;
import com.xxavierr404.dreambuildr.misc.enums.CompatibilityType;
import com.xxavierr404.dreambuildr.misc.exceptions.ConfigurationIsIncompatibleException;
import com.xxavierr404.dreambuildr.services.ConfigurerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utils/pc-configuration")
public class PCConfigurationController {
    private final ConfigurerService service;

    @Autowired
    public PCConfigurationController(ConfigurerService service) {
        this.service = service;
    }

    @PostMapping("/verify")
    public @ResponseBody CompatibilityType verifyConfiguration(@RequestBody PCConfigurationDTO configurationDTO) {
        try {
            service.verifyConfiguration(configurationDTO);
        } catch (ConfigurationIsIncompatibleException e) {
            return e.getError();
        }
        return CompatibilityType.OK;
    }
}
