package com.xxavierr404.dreambuildr.repositories;

import com.xxavierr404.dreambuildr.models.Videocard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideocardRepository extends CrudRepository<Videocard, Long> {
    List<Videocard> findAllByIdBetween(Long from, Long to);
}
