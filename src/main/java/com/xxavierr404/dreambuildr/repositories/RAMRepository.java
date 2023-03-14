package com.xxavierr404.dreambuildr.repositories;

import com.xxavierr404.dreambuildr.models.RAM;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RAMRepository extends CrudRepository<RAM, Long> {
    List<RAM> findAllByIdBetween(Long from, Long to);
}
