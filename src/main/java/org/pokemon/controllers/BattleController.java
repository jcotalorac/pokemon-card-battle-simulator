package org.pokemon.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pokemon.controllers.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/battles")
@Slf4j
@RequiredArgsConstructor
public class BattleController {

    @GetMapping
    public void getBattles(){
        log.debug("Getting battles");
    }

    @GetMapping("/play")
    public BattleResponse playBattle() {
        log.debug("Play battle");
        BattleResponse battleResponse = new BattleResponse();
        PokemonCardResponse card1 = new PokemonCardResponse();
        card1.setHealthPoints(74);
        card1.setAttackPoints(41);
        PokemonCardResponse card2 = new PokemonCardResponse();
        card2.setHealthPoints(68);
        card2.setAttackPoints(81);


        BattlePlayer humanPlayer = new BattlePlayer();
        humanPlayer.setPokemonCardResponses(List.of(card1));

        BattlePlayer computerPlayer = new BattlePlayer();
        computerPlayer.setPokemonCardResponses(List.of(card2));

        battleResponse.setHumanPlayer(humanPlayer);
        battleResponse.setComputerPlayer(computerPlayer);

        return battleResponse;
    }


    @PostMapping("/fight")
    public ResponseEntity<FightResponse> fightWithCard(@RequestBody FightRequest fightRequest) {
        log.debug("Request body: {}", fightRequest);
        return ResponseEntity.ok(new FightResponse());
    }
}
