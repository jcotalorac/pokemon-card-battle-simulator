package org.pokemon.services;

import org.javatuples.Pair;
import org.pokemon.domain.PokemonCard;

@FunctionalInterface
public interface FightService {

    Pair<PokemonCard, PokemonCard> fight(PokemonCard humanCardSelected, PokemonCard computerCardSelected);
}
