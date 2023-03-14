package com.xxavierr404.dreambuildr.repositories;

import com.xxavierr404.dreambuildr.models.PowerUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerUnitRepository extends CrudRepository<PowerUnit, Long> {
    List<PowerUnit> findAllByIdBetween(Long from, Long to);
}
