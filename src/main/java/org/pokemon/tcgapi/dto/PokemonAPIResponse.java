package org.pokemon.tcgapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PokemonAPIResponse {

    private List<PokemonAPICard> data;
}
