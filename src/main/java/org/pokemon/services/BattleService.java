package org.pokemon.services;

import org.pokemon.domain.Battle;

@FunctionalInterface
public interface BattleService {

    Battle play();
}
