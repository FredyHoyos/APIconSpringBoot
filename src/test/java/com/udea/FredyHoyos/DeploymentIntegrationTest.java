package com.udea.FredyHoyos;

import com.udea.FredyHoyos.entities.PokemonDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeploymentIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetPokemonById() {
        // Aquí haces una petición HTTP real a tu API
        ResponseEntity<PokemonDTO> response = restTemplate.getForEntity("/pokemon/1", PokemonDTO.class);
        
        // Verificas que la respuesta HTTP sea 200 OK
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        
        // Verificas que el cuerpo no sea nulo
        assertThat(response.getBody()).isNotNull();
        
        // Verificas que el nombre del pokemon sea el esperado
        assertThat(response.getBody().getName()).isEqualTo("bulbasaur");
    }
}
