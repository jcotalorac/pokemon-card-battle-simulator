package org.pokemon.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.pokemon.controllers.dto.BattlePlayer;
import org.pokemon.controllers.dto.BattleResponse;
import org.pokemon.controllers.dto.PokemonCardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(BattleController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BattleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private JacksonTester<BattleResponse> json;

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

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
                .get("/battles/play")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(json.write(battleResponse).getJson(), response.getContentAsString());
    }
}
