package com.xxavierr404.dreambuildr.repositories;

import com.xxavierr404.dreambuildr.models.Motherboard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotherboardRepository extends CrudRepository<Motherboard, Long> {
    List<Motherboard> findAllByIdBetween(Long from, Long to);
}
