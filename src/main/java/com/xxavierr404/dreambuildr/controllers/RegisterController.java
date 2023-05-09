package com.xxavierr404.dreambuildr.controllers;

import com.xxavierr404.dreambuildr.dto.CustomerDetailsDTO;
import com.xxavierr404.dreambuildr.model.Customer;
import com.xxavierr404.dreambuildr.services.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegisterController {
    private final CustomerDetailsService service;

    @Autowired
    public RegisterController(CustomerDetailsService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CustomerDetailsDTO customer) {
        System.out.println(customer.getPassword());
        System.out.println(customer.getUsername());
        service.doRegister(customer);
        return ResponseEntity.ok("Success");
    }
}
