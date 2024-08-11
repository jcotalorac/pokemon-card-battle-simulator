package org.pokemon.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pokemon.domain.PokemonCard;
import org.pokemon.services.VerifyPokemonHealthService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VerifyPokemonHealthServiceImplTest {

    private VerifyPokemonHealthService verifyPokemonHealthService;

    @BeforeEach
    public void setUp() {
        verifyPokemonHealthService = new VerifyPokemonHealthServiceImpl();
    }

    @Test
    public void checkOnePokemonAlive() {

        PokemonCard pokemonCard = new PokemonCard();
        pokemonCard.setHealthPoints(5);
        List<PokemonCard> cards = List.of(pokemonCard);

        boolean anyPokemonAlive = verifyPokemonHealthService.isAnyPokemonAlive(cards);

        assertTrue(anyPokemonAlive);
    }

    @Test
    public void checkNoPokemonAlive() {

        List<PokemonCard> cards = List.of();

        boolean anyPokemonAlive = verifyPokemonHealthService.isAnyPokemonAlive(cards);

        assertFalse(anyPokemonAlive);
    }
}