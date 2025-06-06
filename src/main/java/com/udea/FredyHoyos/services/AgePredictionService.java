package com.udea.FredyHoyos.services;

import com.udea.FredyHoyos.entities.AgePredictionDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AgePredictionService {

    private final WebClient webClient;

    public AgePredictionService(WebClient webClient) {
        this.webClient = webClient;
    }

    public AgePredictionDTO getAgePredictionByName(String name) {
        return webClient.get()
                .uri("/?name={name}", name)
                .retrieve()
                .bodyToMono(AgePredictionDTO.class)
                .block();
    }
}
