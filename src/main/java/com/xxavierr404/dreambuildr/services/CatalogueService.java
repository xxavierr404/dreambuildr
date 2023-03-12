package com.xxavierr404.dreambuildr.services;

import com.xxavierr404.dreambuildr.models.Motherboard;
import com.xxavierr404.dreambuildr.repositories.MotherboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueService {
    private MotherboardRepository motherboardRepository;

    @Autowired
    public CatalogueService(MotherboardRepository motherboardRepository) {
        this.motherboardRepository = motherboardRepository;
    }

    public List<Motherboard> getMotherboardsByIdBetween(Long start, Long end) {
        return motherboardRepository.findAllByIdBetween(start, end);
    }

    public void addNewMotherboard(Motherboard motherboard) {
        motherboardRepository.save(motherboard);
    }
}
