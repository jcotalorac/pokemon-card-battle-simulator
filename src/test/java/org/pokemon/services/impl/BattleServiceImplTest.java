package org.pokemon.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pokemon.domain.Battle;
import org.pokemon.services.BattleService;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BattleServiceImplTest {

    private final Integer cardsSize = 4;
    private BattleService battleService;

    @BeforeEach
    public void setUp() {

        battleService = new BattleServiceImpl();
        ReflectionTestUtils.setField(battleService, "cardsSize", cardsSize);
    }

    @Test
    public void initSuccessfulBattlePlay() {

        Battle battle = battleService.play();

        assertNotNull(battle, "Failing battle creation");
        assertNotNull(battle.getHumanPlayer(), "Human player is not initialized");
        assertNotNull(battle.getComputerPlayer(), "Computer player is not initialized");
        assertNotNull(battle.getHumanPlayer().getPokemonCards(), "Human player must have dealt cards");
        assertNotNull(battle.getHumanPlayer().getPokemonCards(), "Computer player must have dealt cards");
        assertEquals(cardsSize, battle.getHumanPlayer().getPokemonCards().size());
        assertEquals(cardsSize, battle.getComputerPlayer().getPokemonCards().size());
    }
}