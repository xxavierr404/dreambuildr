package com.xxavierr404.dreambuildr.model;

import com.xxavierr404.dreambuildr.misc.enums.RAMType;
import com.xxavierr404.dreambuildr.misc.objects.PCConfiguration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Сущность - видеокарта
 */
@Entity
@Table(name = "videocard")
public class Videocard extends Item implements Checkable {
    /**
     * Конструктор - создание нового объекта
     */
    public Videocard() {}

    /**
     * Поле - объем видеопамяти
     */

    private Integer vRam;

    /**
     * Поле - частота
     */
    private Integer frequency;

    /**
     * Метод-геттер объема видеопамяти
     * @return Объем видеопамяти
     */
    public Integer getvRam() {
        return vRam;
    }

    /**
     * Метод-сеттер объема видеопамяти
     * @param vRam - Объем видеопамяти
     */
    public void setvRam(Integer vRam) {
        this.vRam = vRam;
    }

    /**
     * Метод-геттер частоты
     * @return Частота видеокарты
     */
    public Integer getFrequency() {
        return frequency;
    }

    /**
     * Метод-сеттер частоты
     * @param frequency - Частота видеокарты
     */
    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public void checkCompatibility(PCConfiguration configuration) {
        // TODO: Check if PCI-E interface is compatible
    }
}
