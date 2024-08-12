package org.pokemon.adapters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.pokemon.controllers.dto.PokemonCardResponse;
import org.pokemon.domain.PokemonCard;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ControllerAdapter {

    @Mapping(target = "attackPoints", source = "attack")
    PokemonCardResponse map(PokemonCard pokemonCard);


}
