package com.xxavierr404.dreambuildr.model;

import com.xxavierr404.dreambuildr.misc.enums.RAMType;
import com.xxavierr404.dreambuildr.misc.enums.SocketType;
import jakarta.persistence.*;

/**
 * Сущность - материнская плата
 */
@Entity
@Table(name = "motherboard")
public class Motherboard extends Item {
    /**
     * Конструктор - создание нового объекта
     */
    public Motherboard () {}

    /**
     * Поле - тип оперативной памяти
     */
    private RAMType ramType;
    /**
     * Поле - количество слотов под оперативную память
     */
    private int ramSlotsCount;
    /**
     * Поле - тип сокета
     */
    private SocketType socketType;

    /**
     * Метод-геттер типа оперативной памяти
     * @return Тип оперативной памяти
     */
    public RAMType getRamType() {
        return ramType;
    }

    /**
     * Метод-сеттер типа оперативной памяти
     * @param ramType - Тип оперативной памяти
     */
    public void setRamType(RAMType ramType) {
        this.ramType = ramType;
    }

    /**
     * Метод-геттер количества слотов оперативной памяти
     * @return Количество слотов под оперативную память
     */
    public int getRamSlotsCount() {
        return ramSlotsCount;
    }

    /**
     * Метод-сеттер количества слотов под оперативную память
     * @param ramSlotsCount - Количество слотов под оперативную память
     */
    public void setRamSlotsCount(int ramSlotsCount) {
        this.ramSlotsCount = ramSlotsCount;
    }

    /**
     * Метод-геттер типа сокеты
     * @return Тип сокета
     */
    public SocketType getSocketType() {
        return socketType;
    }

    /**
     * Метод-сеттер типа сокета
     * @param socketType - Тип сокета
     */
    public void setSocketType(SocketType socketType) {
        this.socketType = socketType;
    }
}
