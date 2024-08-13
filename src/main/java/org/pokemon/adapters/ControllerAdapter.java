package org.pokemon.adapters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.pokemon.controllers.dto.*;
import org.pokemon.domain.Battle;
import org.pokemon.domain.Fight;
import org.pokemon.domain.Player;
import org.pokemon.domain.PokemonCard;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ControllerAdapter {

    @Mapping(target = "attackPoints", source = "attack")
    PokemonCardResponse mapCard(PokemonCard pokemonCard);

    List<PokemonCardResponse> mapCards(List<PokemonCard> pokemonCards);

    @Mapping(target = "pokemonCardResponses", source = "pokemonCards")
    BattlePlayer mapPlayer(Player player);

    BattleResponse mapBattle(Battle battle);

    @Mapping(target = "healthPoints", source = "healthPointsHumanSelected")
    @Mapping(target = "attack", source = "attackPointsHumanSelected")
    PokemonCard mapHumanInput(FightRequest fightRequest);

    @Mapping(target = "healthPoints", source = "healthPointsComputerSelected")
    @Mapping(target = "attack", source = "attackPointsComputerSelected")
    PokemonCard mapComputerInput(FightRequest fightRequest);

    FightResponse map(Fight fight);

    @Mapping(target = "fights", source = "fights")
    FightsResponse mapList(Integer count, List<Fight> fights);

}
