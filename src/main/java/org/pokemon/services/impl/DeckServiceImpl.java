package org.pokemon.services.impl;

import lombok.RequiredArgsConstructor;
import org.pokemon.adapters.ApiAdapter;
import org.pokemon.domain.PokemonCard;
import org.pokemon.services.DeckService;
import org.pokemon.tcgapi.dto.PokemonAPICard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeckServiceImpl implements DeckService {

    private final List<PokemonAPICard> cardsFromApi;
    private final ApiAdapter apiAdapter;

    @Override
    public List<PokemonCard> getAvailableCards() {
        return apiAdapter.mapCards(cardsFromApi);
    }
}
