package com.xxavierr404.dreambuildr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xxavierr404.dreambuildr.dto.CustomerDetailsDTO;
import com.xxavierr404.dreambuildr.dto.PCConfigurationDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private PCConfigurationDTO configurationDTO;

    public Customer() {

    }

    public Customer(CustomerDetailsDTO dto) {
        this.username = dto.getUsername();
        this.password = dto.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PCConfigurationDTO getConfigurationDTO() {
        return configurationDTO;
    }

    public void setConfigurationDTO(PCConfigurationDTO configurationDTO) {
        this.configurationDTO = configurationDTO;
    }
}
