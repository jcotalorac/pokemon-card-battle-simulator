package org.pokemon.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Fight {

    private Integer humanHealth;
    private Integer humanAttack;
    private Integer computerHealth;
    private Integer computerAttack;
}
