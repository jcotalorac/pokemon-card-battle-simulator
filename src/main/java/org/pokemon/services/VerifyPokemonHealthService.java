package org.pokemon.services;

import org.pokemon.domain.PokemonCard;

import java.util.List;

@FunctionalInterface
public interface VerifyPokemonHealthService {

    boolean isAnyPokemonAlive(List<PokemonCard> cards);
}
