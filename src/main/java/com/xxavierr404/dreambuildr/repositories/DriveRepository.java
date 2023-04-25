package com.xxavierr404.dreambuildr.repositories;

import com.xxavierr404.dreambuildr.model.Drive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Репозиторий запоминающих устройств
 */
@Repository
public interface DriveRepository extends JpaRepository<Drive, Long> {
    /**
     * Метод поиска по id
     * @param from - Левая граница
     * @param to - Правая граница
     * @return Список запоминающих устройств
     */
    List<Drive> findAllByIdBetween(Long from, Long to);
}
