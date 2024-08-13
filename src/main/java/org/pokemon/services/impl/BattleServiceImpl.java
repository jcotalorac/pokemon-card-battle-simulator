package org.pokemon.services.impl;

import lombok.RequiredArgsConstructor;
import org.pokemon.domain.Battle;
import org.pokemon.domain.PokemonCard;
import org.pokemon.services.BattleService;
import org.pokemon.services.DeckService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class BattleServiceImpl implements
        BattleService {

    @Value("${cardsSize}")
    private Integer cardsSize;

    private final DeckService deckService;

    @Override
    public Battle play() {
        Battle battle = new Battle();

        List<PokemonCard> humanCards = new ArrayList<>(cardsSize);
        List<PokemonCard> computerCards = new ArrayList<>(cardsSize);

        int bound = deckService.getAvailableCards().size();

        IntStream.range(0, cardsSize).forEach(i -> {
            humanCards.add(deckService.getAvailableCards().get(new SecureRandom().nextInt(bound)));
            computerCards.add(deckService.getAvailableCards().get(new SecureRandom().nextInt(bound)));
        });

        battle.getHumanPlayer().setPokemonCards(humanCards);
        battle.getComputerPlayer().setPokemonCards(computerCards);

        return battle;
    }
}
