package org.pokemon.services;

import org.pokemon.domain.Fight;

import java.util.List;

@FunctionalInterface
public interface FightRetrievingService {

    List<Fight> retrieveFights();
}
