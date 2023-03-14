package com.xxavierr404.dreambuildr.repositories;

import com.xxavierr404.dreambuildr.models.CPU;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CPURepository extends CrudRepository<CPU, Long> {
    List<CPU> findAllByIdBetween(Long from, Long to);
}
