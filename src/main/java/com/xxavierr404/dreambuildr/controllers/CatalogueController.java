package com.xxavierr404.dreambuildr.controllers;

import com.xxavierr404.dreambuildr.misc.enums.PlatformType;
import com.xxavierr404.dreambuildr.misc.enums.RAMType;
import com.xxavierr404.dreambuildr.misc.enums.SocketType;
import com.xxavierr404.dreambuildr.models.Motherboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController {
    @GetMapping("/motherboards")
    public List<Motherboard> getMotherboards(@RequestParam("from") int from,
                                             @RequestParam("to") int to) {
        // Возврат списка-заглушки, пока не будет добавлена БД
        return List.of(new Motherboard(RAMType.DDR3, 2, PlatformType.AMD, SocketType.AM2),
                new Motherboard(RAMType.DDR2, 1, PlatformType.INTEL, SocketType.LGA775),
                new Motherboard(RAMType.DDR5, 4, PlatformType.AMD, SocketType.AM5));
    }
}
