package com.xxavierr404.dreambuildr.repositories;

import com.xxavierr404.dreambuildr.models.RAM;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Репозиторий модулей оперативной памяти
 */
@Repository
public interface RAMRepository extends CrudRepository<RAM, Long> {
    /**
     * Метод поиска по id
     * @param from - Левая граница
     * @param to - Правая граница
     * @return Список модулей оперативной памяти
     */
    List<RAM> findAllByIdBetween(Long from, Long to);
}
