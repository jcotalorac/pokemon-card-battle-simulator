package org.pokemon.controllers.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FightsResponse {
    private List<FightResponse> fights;
    private String count;
}
