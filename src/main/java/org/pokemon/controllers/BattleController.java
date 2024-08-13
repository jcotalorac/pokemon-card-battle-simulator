package org.pokemon.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pokemon.adapters.ControllerAdapter;
import org.pokemon.controllers.dto.BattleResponse;
import org.pokemon.controllers.dto.FightRequest;
import org.pokemon.controllers.dto.FightResponse;
import org.pokemon.services.BattleService;
import org.pokemon.services.FightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/battles")
@Slf4j
@RequiredArgsConstructor
public class BattleController {

    private final ControllerAdapter controllerAdapter;
    private final BattleService battleService;
    private final FightService fightService;

    @GetMapping
    public void getBattles(){
        log.debug("Getting battles");
    }

    @GetMapping("/play")
    public BattleResponse playBattle() {
        log.debug("Play battle");

        return controllerAdapter.mapBattle(battleService.play());
    }


    @PostMapping("/fight")
    public ResponseEntity<FightResponse> fightWithCards(@RequestBody FightRequest fightRequest) {
        log.debug("Request body: {}", fightRequest);
        fightService.fight(controllerAdapter.mapHumanInput(fightRequest),
                controllerAdapter.mapComputerInput(fightRequest));
        return ResponseEntity.ok(new FightResponse());
    }
}
