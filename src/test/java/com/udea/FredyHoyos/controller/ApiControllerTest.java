package com.udea.FredyHoyos.controller;

import com.udea.FredyHoyos.entities.PokemonDTO;
import com.udea.FredyHoyos.services.PokemonService;
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
    private PokemonService pokemonService;

    @Test
    public void getPokemon_ReturnsOkWithData() throws Exception {
        PokemonDTO dto = new PokemonDTO();
        dto.setName("pikachu");

        when(pokemonService.getPokemonById(25)).thenReturn(dto);

        mockMvc.perform(get("/pokemon/25"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("pikachu"));
    }
}
