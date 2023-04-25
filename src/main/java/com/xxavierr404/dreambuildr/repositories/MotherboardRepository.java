package com.xxavierr404.dreambuildr.repositories;

import com.xxavierr404.dreambuildr.model.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Репозиторий материнских плат
 */
@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {
    /**
     * Метод поиска по id
     * @param from - Левая граница
     * @param to - Правая граница
     * @return Список материнских плат
     */
    List<Motherboard> findAllByIdBetween(Long from, Long to);
}
