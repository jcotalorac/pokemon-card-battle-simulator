package org.pokemon.repository.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fight_generator")
    @SequenceGenerator(name = "fight_generator", sequenceName = "fight_seq", allocationSize = 1)
    private Integer id;
    private Integer humanHealth;
    private Integer humanAttack;
    private Integer computerHealth;
    private Integer computerAttack;
}
