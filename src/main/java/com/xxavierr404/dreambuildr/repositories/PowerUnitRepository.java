package com.xxavierr404.dreambuildr.repositories;

import com.xxavierr404.dreambuildr.models.PowerUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Репозиторий блоков питания
 */
@Repository
public interface PowerUnitRepository extends CrudRepository<PowerUnit, Long> {
    /**
     * Метод поиска по id
     * @param from - Левая граница
     * @param to - Правая граница
     * @return Список блоков питания
     */
    List<PowerUnit> findAllByIdBetween(Long from, Long to);
}
