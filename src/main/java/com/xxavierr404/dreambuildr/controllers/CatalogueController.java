package com.xxavierr404.dreambuildr.controllers;

import com.xxavierr404.dreambuildr.models.*;
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

    @GetMapping("/rams")
    public List<RAM> getRAMs(@RequestParam("start") Long start,
                             @RequestParam("end") Long end) {
        return catalogueService.getRAMsByIdBetween(start, end);
    }

    @PostMapping("/rams")
    public ResponseEntity<String> addRAM(RAM ram) {
        catalogueService.addNewRAM(ram);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/drives")
    public List<Drive> getDrives(@RequestParam("start") Long start,
                                 @RequestParam("end") Long end) {
        return catalogueService.getDrivesByIdBetween(start, end);
    }

    @PostMapping("/drives")
    public ResponseEntity<String> addDrive(Drive drive) {
        catalogueService.addNewDrive(drive);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/powerunits")
    public List<PowerUnit> getPowerUnits(@RequestParam("start") Long start,
                                   @RequestParam("end") Long end) {
        return catalogueService.getPUsByIdBetween(start, end);
    }

    @PostMapping("/powerunits")
    public ResponseEntity<String> addPowerUnit(PowerUnit powerUnit) {
        catalogueService.addNewPowerUnit(powerUnit);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/videocards")
    public List<Videocard> getVideocards(@RequestParam("start") Long start,
                             @RequestParam("end") Long end) {
        return catalogueService.getVideocardsByIdBetween(start, end);
    }

    @PostMapping("/videocards")
    public ResponseEntity<String> addVideocard(Videocard videocard) {
        catalogueService.addNewVideocard(videocard);
        return ResponseEntity.ok("Success");
    }
}
