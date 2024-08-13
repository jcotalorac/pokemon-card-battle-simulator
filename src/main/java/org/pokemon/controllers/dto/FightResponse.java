package org.pokemon.controllers.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FightResponse {

    private String humanHealth;
    private String humanAttack;
    private String computerHealth;
    private String computerAttack;

    private boolean result;
}
