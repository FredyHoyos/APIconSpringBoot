package com.udea.FredyHoyos;

import com.udea.FredyHoyos.entities.AgePredictionDTO;
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
    public void testGetAgePredictionByName() {
        // Hacemos una petición con query param
        ResponseEntity<AgePredictionDTO> response = restTemplate.getForEntity("/ege?name=ash", AgePredictionDTO.class);

        // Verifica que el status sea 2xx
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();

        // Verifica que el cuerpo no sea nulo
        assertThat(response.getBody()).isNotNull();

        // Verifica que el nombre sea "ash"
        assertThat(response.getBody().getName()).isEqualTo("ash");
    }
}
