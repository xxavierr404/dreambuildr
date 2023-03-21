package com.xxavierr404.dreambuildr.model;

import com.xxavierr404.dreambuildr.misc.enums.DriveType;
import com.xxavierr404.dreambuildr.misc.objects.PCConfiguration;

/**
 * Сущность - запоминающее устройство
 */
public class Drive extends Item implements Checkable {
    /**
     * Конструктор - создание нового объекта
     */
    public Drive() {}

    /**
     * Поле - тип запоминающего устройства
     */
    private DriveType type;
    /**
     * Поле - объем запоминающего устройства в гигабайтах
     */
    private Integer gigabytes;

    /**
     * Метод-геттер типа запоминающего устройства
     * @return Тип запоминающего устройства
     */
    public DriveType getType() {
        return type;
    }

    /**
     * Метод-сеттер типа запоминающего устройства
     * @param type - Тип запоминающего устройства
     */
    public void setType(DriveType type) {
        this.type = type;
    }

    /**
     * Метод-геттер объема запоминающего устройства
     * @return Объем запоминающего устройства в гигабайтах
     */
    public Integer getGigabytes() {
        return gigabytes;
    }

    /**
     * Метод-сеттер объема запоминающего устройства
     * @param gigabytes - Объем запоминающего устройства в гигабайтах
     */
    public void setGigabytes(Integer gigabytes) {
        this.gigabytes = gigabytes;
    }

    @Override
    public void checkCompatibility(PCConfiguration configuration) {
        // TODO: Connection interface check
    }
}
