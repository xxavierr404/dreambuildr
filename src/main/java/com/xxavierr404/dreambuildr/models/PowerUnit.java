package com.xxavierr404.dreambuildr.models;

/**
 * Сущность - блок питания
 */
public class PowerUnit extends Item {
    /**
     * Конструктор - создание нового объекта
     */
    public PowerUnit() {}

    /**
     * Поле - мощность
     */
    private Integer voltage;

    /**
     * Метод-геттер мощности
     * @return Мощность блока питания
     */
    public Integer getVoltage() {
        return voltage;
    }

    /**
     * Метод-сеттер мощности
     * @param voltage - Мощность блока питания
     */
    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }
}
