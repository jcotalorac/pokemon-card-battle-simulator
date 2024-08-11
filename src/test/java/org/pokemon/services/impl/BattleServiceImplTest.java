package org.pokemon.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pokemon.domain.Battle;
import org.pokemon.services.BattleService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BattleServiceImplTest {

    private BattleService battleService;

    @BeforeEach
    public void setUp() {
        battleService = new BattleServiceImpl();
    }

    @Test
    public void initSuccessfulBattlePlay() {

        Battle battle = battleService.play();

        assertNotNull(battle, "Failing battle creation");
        assertNotNull(battle.getHumanPlayer(), "Human player is not initialized");
        assertNotNull(battle.getComputerPlayer(), "Computer player is not initialized");
        assertNotNull(battle.getHumanPlayer().getPokemonCards(), "Human player must have dealt cards");
        assertNotNull(battle.getHumanPlayer().getPokemonCards(), "Computer player must have dealt cards");
    }
}