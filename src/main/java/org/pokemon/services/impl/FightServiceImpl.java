package org.pokemon.services.impl;

import lombok.RequiredArgsConstructor;
import org.javatuples.Pair;
import org.pokemon.adapters.RepositoryAdapter;
import org.pokemon.domain.PokemonCard;
import org.pokemon.repository.FightRepository;
import org.pokemon.services.FightService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FightServiceImpl implements FightService {

    private final FightRepository fightRepository;
    private final RepositoryAdapter repositoryAdapter;

    @Override
    public Pair<PokemonCard, PokemonCard> fight(PokemonCard humanCardSelected, PokemonCard computerCardSelected) {

        fightRepository.save(repositoryAdapter.mapHuman(humanCardSelected, computerCardSelected));

        Integer remainingHumanCardHealthPoints = humanCardSelected.getHealthPoints() - computerCardSelected.getAttack();

        Integer remainingComputerCardHealthPoints = computerCardSelected.getHealthPoints() - humanCardSelected.getAttack();

        humanCardSelected.setHealthPoints(remainingHumanCardHealthPoints);
        computerCardSelected.setHealthPoints(remainingComputerCardHealthPoints);

        return new Pair<>(humanCardSelected, computerCardSelected);
    }
}
