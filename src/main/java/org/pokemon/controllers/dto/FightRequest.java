package org.pokemon.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FightRequest {

    private Integer healthPointsHumanSelected;
    private Integer attackPointsHumanSelected;
    private Integer healthPointsComputerSelected;
    private Integer attackPointsComputerSelected;
}
