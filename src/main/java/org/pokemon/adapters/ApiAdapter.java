package org.pokemon.adapters;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.pokemon.domain.PokemonCard;
import org.pokemon.tcgapi.dto.PokemonAPICard;

import java.util.List;
import java.util.Objects;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApiAdapter {

    @Mapping(target = "healthPoints", source = "hp")
    @Mapping(target = "attack", source = "pokemonAPICard", qualifiedByName = "firstDamage")
    PokemonCard map(PokemonAPICard pokemonAPICard);

    @Named("firstDamage")
    default String firstAttackDamage(PokemonAPICard pokemonAPICard) {
        String damage = pokemonAPICard.getAttacks().get(0).getDamage();
        if (Objects.nonNull(damage)) {
            String digitPart = damage.replaceAll("\\D+", "");
            if (digitPart.isEmpty()) {
                return "0";
            }
            return digitPart;
        }
        return "0";
    }

    List<PokemonCard> mapCards(List<PokemonAPICard> pokemonAPICards);
}
