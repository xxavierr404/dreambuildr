package com.xxavierr404.dreambuildr.services;

import com.xxavierr404.dreambuildr.dto.PCConfigurationDTO;
import com.xxavierr404.dreambuildr.misc.objects.PCConfiguration;
import com.xxavierr404.dreambuildr.model.CustomerDetails;
import com.xxavierr404.dreambuildr.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CustomerRepository repository;
    private final ConfigurerService service;

    @Autowired
    public CartService(CustomerRepository repository, ConfigurerService service) {
        this.repository = repository;
        this.service = service;
    }

    public PCConfiguration getConfiguration() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var customer = ((CustomerDetails)auth.getPrincipal()).getCustomer();
        var dto = customer.getConfigurationDTO();
        return service.buildConfigurationFromDTO(dto);
    }

    public void setConfiguration(PCConfigurationDTO dto) {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var customer = ((CustomerDetails) auth.getPrincipal()).getCustomer();
        customer.setConfigurationDTO(dto);
        repository.save(customer);
    }
}
