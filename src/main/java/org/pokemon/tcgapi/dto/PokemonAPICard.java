package org.pokemon.tcgapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PokemonAPICard {

    private String id;
    private String name;
    private String hp;
    private List<String> types;
    private List<PokemonAPIAttack> attacks;
}
