package com.udea.FredyHoyos.controller;

import com.udea.FredyHoyos.entities.AgePredictionDTO;
import com.udea.FredyHoyos.services.AgePredictionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ApiController.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AgePredictionService agePredictionService;

    @Test
    public void getAgePrediction_ReturnsOkWithData() throws Exception {
        AgePredictionDTO dto = new AgePredictionDTO();
        dto.setName("pikachu");
        dto.setAge(10);
        dto.setCount(1234);

        when(agePredictionService.getAgePredictionByName("pikachu")).thenReturn(dto);

        mockMvc.perform(get("/pokemon?name=pikachu"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("pikachu"))
                .andExpect(jsonPath("$.age").value(10))
                .andExpect(jsonPath("$.count").value(1234));
    }
}
