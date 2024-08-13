package org.pokemon.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pokemon.domain.Battle;
import org.pokemon.domain.PokemonCard;
import org.pokemon.services.BattleService;
import org.pokemon.services.DeckService;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BattleServiceImplTest {

    private final Integer cardsSize = 4;
    private BattleService battleService;

    @Mock
    private DeckService deckService;

    @BeforeEach
    public void setUp() {

        battleService = new BattleServiceImpl(deckService);
        ReflectionTestUtils.setField(battleService, "cardsSize", cardsSize);
    }

    @Test
    public void initSuccessfulBattlePlay() {

        int availableSize = 50;
        when(deckService.getAvailableCards()).thenReturn(Collections.nCopies(availableSize, new PokemonCard()));

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
