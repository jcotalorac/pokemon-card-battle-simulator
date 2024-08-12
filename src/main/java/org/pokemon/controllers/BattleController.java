package org.pokemon.controllers;

import lombok.extern.slf4j.Slf4j;
import org.pokemon.controllers.dto.BattleInPlayResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/battles")
@Slf4j
public class BattleController {

    @GetMapping
    public void getBattles(){
        log.debug("Getting battles");
    }

    @GetMapping("/play")
    public BattleInPlayResponse playBattle() {
        log.debug("Play battle");
        return new BattleInPlayResponse();
    }
}
