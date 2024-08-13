package org.pokemon.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pokemon.adapters.ApiAdapter;
import org.pokemon.domain.PokemonCard;
import org.pokemon.services.DeckService;
import org.pokemon.tcgapi.dto.PokemonAPICard;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DeckServiceImplTest {

    @Mock
    private ApiAdapter apiAdapter;

    @Mock
    private List<PokemonAPICard> cards;

    private DeckService deckService;

    @BeforeEach
    public void setUp() {

        deckService = new DeckServiceImpl(cards, apiAdapter);
    }

    @Test
    public void getAvailableCards() {

        List<PokemonCard> availableCards = deckService.getAvailableCards();

        assertEquals(cards.size(), availableCards.size());
    }
}
