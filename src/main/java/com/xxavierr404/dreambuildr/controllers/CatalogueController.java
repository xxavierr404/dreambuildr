package com.xxavierr404.dreambuildr.controllers;

import com.xxavierr404.dreambuildr.models.CPU;
import com.xxavierr404.dreambuildr.models.Motherboard;
import com.xxavierr404.dreambuildr.services.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController {
    private final CatalogueService catalogueService;

    @Autowired
    public CatalogueController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @GetMapping("/motherboards")
    public List<Motherboard> getMotherboards(@RequestParam("start") Long start,
                                             @RequestParam("end") Long end) {
        return catalogueService.getMotherboardsByIdBetween(start, end);
    }

    @PostMapping("/motherboards")
    public ResponseEntity<String> addMotherboard(Motherboard board) {
        catalogueService.addNewMotherboard(board);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/cpus")
    public List<CPU> getCPUs(@RequestParam("start") Long start,
                             @RequestParam("end") Long end) {
        return catalogueService.getCPUsByIdBetween(start, end);
    }

    @PostMapping("/cpus")
    public ResponseEntity<String> addCPU(CPU cpu) {
        catalogueService.addNewCPU(cpu);
        return ResponseEntity.ok("Success");
    }
}
