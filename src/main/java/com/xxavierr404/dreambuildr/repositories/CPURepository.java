package com.xxavierr404.dreambuildr.repositories;

import com.xxavierr404.dreambuildr.models.CPU;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Репозиторий процессоров
 */
@Repository
public interface CPURepository extends CrudRepository<CPU, Long> {
    /**
     * Метод поиска по id
     * @param from - Левая граница
     * @param to - Правая граница
     * @return Список процессоров
     */
    List<CPU> findAllByIdBetween(Long from, Long to);
}
