package com.xxavierr404.dreambuildr.services;

import com.xxavierr404.dreambuildr.model.*;
import com.xxavierr404.dreambuildr.repositories.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CatalogueServiceTest {
    @Mock
    private MotherboardRepository motherboardRepository;
    @Mock
    private CPURepository cpuRepository;
    @Mock
    private RAMRepository ramRepository;
    @Mock
    private DriveRepository driveRepository;
    @Mock
    private PowerUnitRepository powerUnitRepository;
    @Mock
    private VideocardRepository videocardRepository;

    @Autowired
    private CatalogueService catalogueService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        catalogueService = new CatalogueService(
                motherboardRepository,
                cpuRepository,
                ramRepository,
                driveRepository,
                powerUnitRepository,
                videocardRepository
        );
    }

    @Test
    public void testGetMotherboardsByIdBetween() {
        Motherboard motherboard1 = new Motherboard();
        Motherboard motherboard2 = new Motherboard();
        when(motherboardRepository.findAllByIdBetween(1L, 2L)).thenReturn(Arrays.asList(motherboard1, motherboard2));
        List<Motherboard> result = catalogueService.getMotherboardsByIdBetween(1L, 2L);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testGetAllMotherboards() {
        Motherboard motherboard1 = new Motherboard();
        Motherboard motherboard2 = new Motherboard();
        when(motherboardRepository.findAll()).thenReturn(Arrays.asList(motherboard1, motherboard2));
        List<Motherboard> result = catalogueService.getAllMotherboards();
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testGetMotherboard() {
        Motherboard motherboard = new Motherboard();
        when(motherboardRepository.findById(1L)).thenReturn(java.util.Optional.of(motherboard));
        Motherboard result = catalogueService.getMotherboard(1L);
        Assertions.assertNotNull(result);
    }

    @Test
    public void testAddNewMotherboard() {
        Motherboard motherboard = new Motherboard();
        catalogueService.addNewMotherboard(motherboard);
        Mockito.verify(motherboardRepository, times(1)).save(motherboard);
    }

    @Test
    public void testGetCPUsByIdBetween() {
        CPU cpu1 = new CPU();
        CPU cpu2 = new CPU();
        when(cpuRepository.findAllByIdBetween(1L, 2L)).thenReturn(Arrays.asList(cpu1, cpu2));
        List<CPU> result = catalogueService.getCPUsByIdBetween(1L, 2L);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testGetAllCPUs() {
        CPU cpu1 = new CPU();
        CPU cpu2 = new CPU();
        when(cpuRepository.findAll()).thenReturn(Arrays.asList(cpu1, cpu2));
        List<CPU> result = catalogueService.getAllCPUs();
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testAddNewCPU() {
        CPU cpu = new CPU();
        catalogueService.addNewCPU(cpu);
        Mockito.verify(cpuRepository, times(1)).save(cpu);
    }

    @Test
    public void testGetCPU() {
        CPU cpu = new CPU();
        when(cpuRepository.findById(1L)).thenReturn(java.util.Optional.of(cpu));
        CPU result = catalogueService.getCPU(1L);
        Assertions.assertNotNull(result);
    }

    @Test
    public void testGetRAMsByIdBetween() {
        RAM ram1 = new RAM();
        RAM ram2 = new RAM();
        when(ramRepository.findAllByIdBetween(1L, 2L)).thenReturn(Arrays.asList(ram1, ram2));
        List<RAM> result = catalogueService.getRAMsByIdBetween(1L, 2L);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testGetAllRAMs() {
        RAM ram1 = new RAM();
        RAM ram2 = new RAM();
        when(ramRepository.findAll()).thenReturn(Arrays.asList(ram1, ram2));
        List<RAM> result = catalogueService.getAllRAMs();
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testAddNewRAM() {
        RAM ram = new RAM();
        catalogueService.addNewRAM(ram);
        Mockito.verify(ramRepository, times(1)).save(ram);
    }

    @Test
    public void testGetRAM() {
        RAM ram = new RAM();
        when(ramRepository.findById(1L)).thenReturn(java.util.Optional.of(ram));
        RAM result = catalogueService.getRam(1L);
        Assertions.assertNotNull(result);
    }

    @Test
    public void testGetDrivesByIdBetween() {
        Drive drive1 = new Drive();
        Drive drive2 = new Drive();
        when(driveRepository.findAllByIdBetween(1L, 2L)).thenReturn(Arrays.asList(drive1, drive2));
        List<Drive> result = catalogueService.getDrivesByIdBetween(1L, 2L);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testGetAllDrives() {
        Drive drive1 = new Drive();
        Drive drive2 = new Drive();
        when(driveRepository.findAll()).thenReturn(Arrays.asList(drive1, drive2));
        List<Drive> result = catalogueService.getAllDrives();
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testAddNewDrive() {
        Drive drive = new Drive();
        catalogueService.addNewDrive(drive);
        Mockito.verify(driveRepository, times(1)).save(drive);
    }

    @Test
    public void testGetDrive() {
        Drive drive = new Drive();
        when(driveRepository.findById(1L)).thenReturn(java.util.Optional.of(drive));
        Drive result = catalogueService.getDrive(1L);
        Assertions.assertNotNull(result);
    }

    @Test
    public void testGetPowerUnitsByIdBetween() {
        PowerUnit powerUnit1 = new PowerUnit();
        PowerUnit powerUnit2 = new PowerUnit();
        when(powerUnitRepository.findAllByIdBetween(1L, 2L)).thenReturn(Arrays.asList(powerUnit1, powerUnit2));
        List<PowerUnit> result = catalogueService.getPowerUnitsByIdBetween(1L, 2L);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testGetAllPowerUnits() {
        PowerUnit powerUnit1 = new PowerUnit();
        PowerUnit powerUnit2 = new PowerUnit();
        when(powerUnitRepository.findAll()).thenReturn(Arrays.asList(powerUnit1, powerUnit2));
        List<PowerUnit> result = catalogueService.getAllPowerUnits();
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testAddNewPowerUnit() {
        PowerUnit powerUnit = new PowerUnit();
        catalogueService.addNewPowerUnit(powerUnit);
        Mockito.verify(powerUnitRepository, times(1)).save(powerUnit);
    }

    @Test
    public void testGetPowerunit() {
        PowerUnit powerUnit = new PowerUnit();
        when(powerUnitRepository.findById(1L)).thenReturn(java.util.Optional.of(powerUnit));
        PowerUnit result = catalogueService.getPowerUnit(1L);
        Assertions.assertNotNull(result);
    }

    @Test
    public void testGetVideocardsByIdBetween() {
        Videocard videocard1 = new Videocard();
        Videocard videocard2 = new Videocard();
        when(videocardRepository.findAllByIdBetween(1L, 2L)).thenReturn(Arrays.asList(videocard1, videocard2));
        List<Videocard> result = catalogueService.getVideocardsByIdBetween(1L, 2L);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testGetAllVideocards() {
        Videocard videocard1 = new Videocard();
        Videocard videocard2 = new Videocard();
        when(videocardRepository.findAll()).thenReturn(Arrays.asList(videocard1, videocard2));
        List<Videocard> result = catalogueService.getAllVideocards();
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testGetVideocard() {
        Videocard videocard = new Videocard();
        when(videocardRepository.findById(1L)).thenReturn(java.util.Optional.of(videocard));
        Videocard result = catalogueService.getVideocard(1L);
        Assertions.assertNotNull(result);
    }

    @Test
    public void testAddNewVideocard() {
        Videocard videocard = new Videocard();
        catalogueService.addNewVideocard(videocard);
        Mockito.verify(videocardRepository, times(1)).save(videocard);
    }
}