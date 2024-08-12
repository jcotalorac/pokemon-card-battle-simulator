package org.pokemon.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(BattleController.class)
public class BattleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getBattles() throws Exception {

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
                .get("/battles")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}