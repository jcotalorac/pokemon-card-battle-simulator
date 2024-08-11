package org.pokemon.services.impl;

import org.pokemon.domain.Battle;
import org.pokemon.services.BattleService;

import java.util.List;

public class BattleServiceImpl implements BattleService {

    @Override
    public Battle play() {
        Battle battle = new Battle();

        battle.getComputerPlayer().setPokemonCards(List.of());
        battle.getHumanPlayer().setPokemonCards(List.of());

        return battle;
    }
}
