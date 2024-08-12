package org.pokemon.services.impl;

import org.pokemon.domain.Battle;
import org.pokemon.domain.PokemonCard;
import org.pokemon.services.BattleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleServiceImpl implements BattleService {

    @Override
    public Battle play() {
        Battle battle = new Battle();

        PokemonCard card1 = new PokemonCard();
        card1.setHealthPoints(74);
        card1.setAttack(41);

        PokemonCard card2 = new PokemonCard();
        card2.setHealthPoints(68);
        card2.setAttack(81);

        battle.getComputerPlayer().setPokemonCards(List.of(card1));
        battle.getHumanPlayer().setPokemonCards(List.of(card2));

        return battle;
    }
}
