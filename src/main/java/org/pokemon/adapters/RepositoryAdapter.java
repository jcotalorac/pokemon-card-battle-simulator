package org.pokemon.adapters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.pokemon.domain.PokemonCard;
import org.pokemon.repository.entities.Fight;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RepositoryAdapter {


    @Mapping(target = "humanHealth", source = "pokemonCardHuman.healthPoints")
    @Mapping(target = "humanAttack", source = "pokemonCardHuman.attack")
    @Mapping(target = "computerHealth", source = "pokemonCardComputer.healthPoints")
    @Mapping(target = "computerAttack", source = "pokemonCardComputer.attack")
    Fight mapHuman(PokemonCard pokemonCardHuman, PokemonCard pokemonCardComputer);

    org.pokemon.domain.Fight map(Fight fightEntity);

    List<org.pokemon.domain.Fight> mapFight(List<Fight> fights);
}
