package org.pokemon.services.impl;

import org.javatuples.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pokemon.adapters.RepositoryAdapter;
import org.pokemon.domain.PokemonCard;
import org.pokemon.repository.FightRepository;
import org.pokemon.repository.entities.Fight;
import org.pokemon.services.FightService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FightServiceImplTest {

    private FightService fightService;

    @Mock
    private FightRepository fightRepository;

    @Mock
    private RepositoryAdapter repositoryAdapter;

    @BeforeEach
    public void setUp() {
        fightService = new FightServiceImpl(fightRepository, repositoryAdapter);
    }

    @Test
    public void successfulFight() {

        PokemonCard humanCardSelected = new PokemonCard();
        humanCardSelected.setHealthPoints(10);
        humanCardSelected.setAttack(9);

        PokemonCard computerCardSelected = new PokemonCard();
        computerCardSelected.setHealthPoints(8);
        computerCardSelected.setAttack(7);

        when(fightRepository.save(any())).thenReturn(new Fight());

        Pair<PokemonCard, PokemonCard> cards = fightService.fight(humanCardSelected, computerCardSelected);

        assertEquals(humanCardSelected, cards.getValue0());
        assertEquals(computerCardSelected, cards.getValue1());
        assertEquals(3, humanCardSelected.getHealthPoints());
        assertEquals(-1, computerCardSelected.getHealthPoints());
    }
}
