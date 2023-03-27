package com.xxavierr404.dreambuildr.controllers;

import com.xxavierr404.dreambuildr.dto.PCConfigurationDTO;
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
    public @ResponseBody String verifyConfiguration(@RequestBody PCConfigurationDTO configurationDTO) {
        try {
            service.verifyConfiguration(configurationDTO);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
        return "Configuration is compatible";
    }
}
