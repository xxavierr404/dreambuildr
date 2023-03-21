package com.xxavierr404.dreambuildr.model;

import com.xxavierr404.dreambuildr.misc.enums.SocketType;
import com.xxavierr404.dreambuildr.misc.exceptions.ConfigurationIsIncompatibleException;
import com.xxavierr404.dreambuildr.misc.objects.PCConfiguration;
import jakarta.persistence.Entity;

/**
 * Сущность - процессор
 */
@Entity
public class CPU extends Item implements Checkable {
    /**
     * Конструктор - создание нового объекта
     */
    public CPU () {}
    /**
     * Поле - частота
     */
    private Integer frequency;
    /**
     * Поле - тип сокета
     */
    private SocketType socketType;

    /**
     * Метод-геттер частоты
     * @return Частота процессора
     */
    public Integer getFrequency() {
        return frequency;
    }

    /**
     * Метод-сеттер частоты
     * @param frequency - Частота процессора
     */
    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    /**
     * Метод-геттер типа сокета
     * @return Тип сокета
     */
    public SocketType getSocketType() {
        return socketType;
    }

    /**
     * Метод-сеттер типа сокета
     * @param socketType - Тип сокета процессора
     */
    public void setSocketType(SocketType socketType) {
        this.socketType = socketType;
    }

    @Override
    public void checkCompatibility(PCConfiguration configuration) {
        if (!configuration.getMotherboard().getSocketType().equals(socketType)) {
            throw new ConfigurationIsIncompatibleException("CPU does not match with socket on motherboard");
        }
    }
}
