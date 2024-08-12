package org.pokemon.services.impl;

import org.pokemon.domain.Battle;
import org.pokemon.domain.PokemonCard;
import org.pokemon.services.BattleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class BattleServiceImpl implements BattleService {

    @Value("${cardsSize}")
    private Integer cardsSize;

    @Override
    public Battle play() {
        Battle battle = new Battle();

        PokemonCard card1 = new PokemonCard();
        card1.setHealthPoints(74);
        card1.setAttack(41);

        PokemonCard card2 = new PokemonCard();
        card2.setHealthPoints(68);
        card2.setAttack(81);

        List<PokemonCard> humanCards = new ArrayList<>(cardsSize);
        List<PokemonCard> computerCards = new ArrayList<>(cardsSize);

        IntStream.range(0, cardsSize).forEach(i -> {
            humanCards.add(card1);
            computerCards.add(card2);
        });

        battle.getHumanPlayer().setPokemonCards(humanCards);
        battle.getComputerPlayer().setPokemonCards(computerCards);

        return battle;
    }
}
