package com.xxavierr404.dreambuildr.controllers;

import com.xxavierr404.dreambuildr.dto.PCConfigurationDTO;
import com.xxavierr404.dreambuildr.misc.objects.PCConfiguration;
import com.xxavierr404.dreambuildr.model.CustomerDetails;
import com.xxavierr404.dreambuildr.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    private final CartService service;

    @Autowired
    public CartController(CartService service) {
        this.service = service;
    }

    @GetMapping("/cart")
    private PCConfiguration getConfiguration() {
        try {
            return service.getConfiguration();
        } catch (NullPointerException e) {
            return null;
        }
    }

    @PostMapping("/cart")
    private ResponseEntity<PCConfigurationDTO> setConfiguration(@RequestBody PCConfigurationDTO dto) {
        service.setConfiguration(dto);
        return ResponseEntity.ok(dto);
    }
}
