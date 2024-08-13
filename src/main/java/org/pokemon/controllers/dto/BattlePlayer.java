package org.pokemon.controllers.dto;

import lombok.Data;

import java.util.List;

@Data
public class BattlePlayer {

    private List<PokemonCardResponse> pokemonCardResponses;
}
