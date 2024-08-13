package org.pokemon.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.pokemon.adapters.ControllerAdapter;
import org.pokemon.controllers.dto.FightsResponse;
import org.pokemon.services.FightRetrievingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(FightController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FightRetrievingService fightRetrievingService;

    @MockBean
    private ControllerAdapter controllerAdapter;

    private JacksonTester<FightsResponse> jsonFightResponse;

    @BeforeAll
    public void setUp() {
        JacksonTester.initFields(this, ObjectMapper::new);
    }

    @Test
    public void successfulGetFights() throws Exception {

        FightsResponse fightsResponse = new FightsResponse();

        when(controllerAdapter.mapList(any(), any())).thenReturn(fightsResponse);


        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
                .get("/fights")).andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(jsonFightResponse.write(fightsResponse).getJson(), response.getContentAsString());
    }
}
