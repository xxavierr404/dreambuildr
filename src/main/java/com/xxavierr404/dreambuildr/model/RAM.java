package com.xxavierr404.dreambuildr.model;

import com.xxavierr404.dreambuildr.misc.enums.RAMType;
import com.xxavierr404.dreambuildr.misc.exceptions.ConfigurationIsIncompatibleException;
import com.xxavierr404.dreambuildr.misc.objects.PCConfiguration;
import jakarta.persistence.Entity;

/**
 * Сущность - оперативная память
 */
@Entity
public class RAM extends Item implements Checkable {
    /**
     * Конструктор - создание нового объекта
     */
    public RAM() {}

    /**
     * Поле - тип оперативной памяти
     */
    private RAMType type;
    /**
     * Поле - частота
     */
    private Integer frequency;
    /**
     * Поле - объем в гигабайтах
     */
    private Integer gigabytes;

    /**
     * Метод-геттер типа оперативной памяти
     * @return Тип оперативной памяти
     */
    public RAMType getType() {
        return type;
    }

    /**
     * Метод-сеттер типа оперативной памяти
     * @param type - Тип оперативной памяти
     */
    public void setType(RAMType type) {
        this.type = type;
    }

    /**
     * Метод-геттер частоты оперативной памяти
     * @return Частота оперативной памяти
     */
    public Integer getFrequency() {
        return frequency;
    }

    /**
     * Метод-сеттер частоты оперативной памяти
     * @param frequency - Частота оперативной памяти
     */
    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    /**
     * Метод-геттер объема оперативной памяти в гигабайтах
     * @return Объем оперативной памяти в гигабайтах
     */
    public Integer getGigabytes() {
        return gigabytes;
    }

    /**
     * Метод-сеттер объема оперативной памяти в гигабайтах
     * @param gigabytes - Объем оперативной памяти в гигабайтах
     */
    public void setGigabytes(Integer gigabytes) {
        this.gigabytes = gigabytes;
    }

    @Override
    public void checkCompatibility(PCConfiguration configuration) {
        if (!configuration.getMotherboard().getRamType().equals(type)) {
            throw new ConfigurationIsIncompatibleException("RAM type doesn't match with motherboard");
        }
    }
}
