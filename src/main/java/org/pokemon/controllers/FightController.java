package org.pokemon.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pokemon.adapters.ControllerAdapter;
import org.pokemon.controllers.dto.FightsResponse;
import org.pokemon.services.FightRetrievingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fights")
@Slf4j
@RequiredArgsConstructor
public class FightController {

    private final FightRetrievingService fightRetrievingService;
    private final ControllerAdapter controllerAdapter;

    @GetMapping
    public FightsResponse getFights() {
        log.debug("Getting all fights");
        return controllerAdapter.mapList(0, fightRetrievingService.retrieveFights());
    }
}
