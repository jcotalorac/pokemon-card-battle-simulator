package org.pokemon.repository;

import org.pokemon.repository.entities.Fight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FightRepository extends CrudRepository<Fight, Integer> {
}
