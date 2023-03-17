package com.xxavierr404.dreambuildr.models;

import com.xxavierr404.dreambuildr.misc.enums.RAMType;

/**
 * Сущность - видеокарта
 */
public class Videocard extends Item {
    /**
     * Конструктор - создание нового объекта
     */
    public Videocard() {}

    /**
     * Поле - объем видеопамяти
     */
    private Integer vRam;
    /**
     * Поле - тип видеопамяти
     */
    private RAMType vRamType;
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
     * Метод-геттер типа видеопамяти
     * @return Тип видеопамяти
     */
    public RAMType getvRamType() {
        return vRamType;
    }

    /**
     * Метод-сеттер типа видеопамяти
     * @param vRamType - Тип видеопамяти
     */
    public void setvRamType(RAMType vRamType) {
        this.vRamType = vRamType;
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
}
