package com.xxavierr404.dreambuildr.model;

import com.xxavierr404.dreambuildr.misc.objects.PCConfiguration;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Сущность - блок питания
 */
@Entity
@Table(name = "powerunit")
public class PowerUnit extends Item implements Checkable {
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

    @Override
    public void checkCompatibility(PCConfiguration configuration) {
        // TODO: Check if power is enough to power up the videocard
    }
}
