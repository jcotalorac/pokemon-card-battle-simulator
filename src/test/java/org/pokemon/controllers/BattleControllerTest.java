package org.pokemon.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.pokemon.adapters.ControllerAdapter;
import org.pokemon.controllers.dto.*;
import org.pokemon.services.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(BattleController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BattleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ControllerAdapter controllerAdapter;

    @MockBean
    private BattleService battleService;

    private JacksonTester<BattleResponse> jsonBattleResponse;
    private JacksonTester<FightRequest> jsonFightRequest;
    private JacksonTester<FightResponse> jsonFightResponse;

    @BeforeAll
    public void setUp() {
        JacksonTester.initFields(this, ObjectMapper::new);
    }

    @Test
    public void getBattles() throws Exception {

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
                .get("/battles")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void successfulPlayBattle() throws Exception {

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

        BattleResponse battleResponse = new BattleResponse();
        battleResponse.setHumanPlayer(humanPlayer);
        battleResponse.setComputerPlayer(computerPlayer);

        when(controllerAdapter.mapBattle(any())).thenReturn(battleResponse);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
                .get("/battles/play")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(jsonBattleResponse.write(battleResponse).getJson(), response.getContentAsString());
    }

    @Test
    public void successfulFightWithCard() throws Exception {

        FightRequest fightRequest = new FightRequest();
        fightRequest.setSelectedCard(2);

        FightResponse fightResponse = new FightResponse();

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
                        .post("/battles/fight").contentType(MediaType.APPLICATION_JSON)
                        .content(jsonFightRequest.write(fightRequest).getJson()))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        assertEquals(jsonFightResponse.write(fightResponse).getJson(), response.getContentAsString());
    }
}
