package com.xxavierr404.dreambuildr.model;

import jakarta.persistence.*;

/**
 * Сущность - предмет
 */
@MappedSuperclass
public class Item {
    /**
     * Поле - id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Поле - название
     */
    private String name;
    /**
     * Поле - цена
     */
    private Integer price;

    /**
     * Метод-геттер имени
     * @return Название предмета
     */
    public String getName() {
        return name;
    }

    /**
     * Метод-сеттер имени
     * @param name - Название предмета
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод-геттер цены
     * @return Цена предмета
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Метод-сеттер цены
     * @param price - Цена предмета
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * Метод-геттер id
     * @return id предмета
     */
    public Long getId() {
        return id;
    }

    /**
     * Метод-сеттер id
     * @param id - Идентификатор предмета
     */
    public void setId(Long id) {
        this.id = id;
    }
}
