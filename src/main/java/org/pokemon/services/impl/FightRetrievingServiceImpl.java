package org.pokemon.services.impl;

import lombok.RequiredArgsConstructor;
import org.pokemon.adapters.RepositoryAdapter;
import org.pokemon.domain.Fight;
import org.pokemon.repository.FightRepository;
import org.pokemon.services.FightRetrievingService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class FightRetrievingServiceImpl implements FightRetrievingService {

    private final FightRepository fightRepository;
    private final RepositoryAdapter repositoryAdapter;

    @Override
    public List<Fight> retrieveFights() {
        Iterable<org.pokemon.repository.entities.Fight> allFights = fightRepository.findAll();

        Iterator<org.pokemon.repository.entities.Fight> fightIterator = allFights.iterator();

        List<org.pokemon.repository.entities.Fight> fightList = StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(fightIterator, Spliterator.ORDERED), false)
                .collect(Collectors.toList());

        return repositoryAdapter.mapFight(fightList);

    }
}
