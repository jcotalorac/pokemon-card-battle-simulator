package org.pokemon.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Battle {

    private final Player humanPlayer;
    private final Player computerPlayer;

    public Battle() {
        this(new Player(), new Player());
    }
}
