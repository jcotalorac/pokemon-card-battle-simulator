package org.pokemon.services.impl;

import org.pokemon.domain.PokemonCard;
import org.pokemon.services.VerifyPokemonHealthService;

import java.util.List;

public class VerifyPokemonHealthServiceImpl implements VerifyPokemonHealthService {

    @Override
    public boolean isAnyPokemonAlive(List<PokemonCard> cards) {
        return cards.stream().anyMatch(pokemonCard -> pokemonCard.getHealthPoints() > 0);
    }
}
