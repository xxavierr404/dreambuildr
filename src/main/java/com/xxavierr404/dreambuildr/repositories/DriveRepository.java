package com.xxavierr404.dreambuildr.repositories;

import com.xxavierr404.dreambuildr.models.Drive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriveRepository extends CrudRepository<Drive, Long> {
    List<Drive> findAllByIdBetween(Long from, Long to);
}
