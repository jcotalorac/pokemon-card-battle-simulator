package org.pokemon.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.pokemon.adapters.RepositoryAdapter;
import org.pokemon.domain.Fight;
import org.pokemon.repository.FightRepository;
import org.pokemon.services.FightRetrievingService;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FightRetrievingServiceImplTest {

    private FightRetrievingService fightRetrievingService;

    @Mock
    private FightRepository fightRepository;

    @Mock
    private RepositoryAdapter repositoryAdapter;

    @BeforeEach
    public void setUp() {
        fightRetrievingService = new FightRetrievingServiceImpl(fightRepository, repositoryAdapter);
    }

    @Test
    public void retrieveFights() {

        int size = 3;

        List<org.pokemon.repository.entities.Fight> fightsPersisted = Collections
                .nCopies(size, new org.pokemon.repository.entities.Fight());

        when(fightRepository.findAll()).thenReturn(fightsPersisted);
        when(repositoryAdapter.mapFight(fightsPersisted)).thenReturn(Collections.nCopies(size, new Fight()));

        List<Fight> fights = fightRetrievingService.retrieveFights();

        assertEquals(size, fights.size());

    }
}
