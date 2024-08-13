package org.pokemon.services.impl;

import org.javatuples.Pair;
import org.pokemon.domain.PokemonCard;
import org.pokemon.services.FightService;
import org.springframework.stereotype.Service;

@Service
public class FightServiceImpl implements FightService {

    @Override
    public Pair<PokemonCard, PokemonCard> fight(PokemonCard humanCardSelected, PokemonCard computerCardSelected) {

        Integer remainingHumanCardHealthPoints = humanCardSelected.getHealthPoints() - computerCardSelected.getAttack();

        Integer remainingComputerCardHealthPoints = computerCardSelected.getHealthPoints() - humanCardSelected.getAttack();

        humanCardSelected.setHealthPoints(remainingHumanCardHealthPoints);
        computerCardSelected.setHealthPoints(remainingComputerCardHealthPoints);

        return new Pair<>(humanCardSelected, computerCardSelected);
    }
}
