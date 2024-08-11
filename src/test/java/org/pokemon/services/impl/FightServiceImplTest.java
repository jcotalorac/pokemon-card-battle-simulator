package org.pokemon.services.impl;

import org.javatuples.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pokemon.domain.PokemonCard;
import org.pokemon.services.FightService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FightServiceImplTest {

    private FightService fightService;

    @BeforeEach
    public void setUp() {
        fightService = new FightServiceImpl();
    }

    @Test
    public void successfulFight() {

        PokemonCard humanCardSelected = new PokemonCard();
        humanCardSelected.setHealthPoints(10);
        humanCardSelected.setAttack(9);

        PokemonCard computerCardSelected = new PokemonCard();
        computerCardSelected.setHealthPoints(8);
        computerCardSelected.setAttack(7);

        Pair<PokemonCard, PokemonCard> cards = fightService.fight(humanCardSelected, computerCardSelected);

        assertEquals(humanCardSelected, cards.getValue0());
        assertEquals(computerCardSelected, cards.getValue1());
        assertEquals(3, humanCardSelected.getHealthPoints());
        assertEquals(-1, computerCardSelected.getHealthPoints());
    }
}