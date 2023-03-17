package com.xxavierr404.dreambuildr.models;

import com.xxavierr404.dreambuildr.misc.enums.SocketType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Сущность - процессор
 */
@Entity
public class CPU extends Item {
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
}
