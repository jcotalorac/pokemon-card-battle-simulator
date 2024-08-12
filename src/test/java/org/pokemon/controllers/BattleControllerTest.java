package org.pokemon.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.pokemon.controllers.dto.BattleInPlayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(BattleController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BattleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private JacksonTester<BattleInPlayResponse> json;

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
    public void playBattle() throws Exception {

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
                .get("/battles/play")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        BattleInPlayResponse battleInPlayResponse = new BattleInPlayResponse();
        battleInPlayResponse.setWinner("champion");
        assertEquals(json.write(battleInPlayResponse).getJson(), response.getContentAsString());
    }
}
