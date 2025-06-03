package com.udea.FredyHoyos.services;

import com.udea.FredyHoyos.entities.PokemonDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PokemonService {

    private final WebClient webClient;

    public PokemonService(WebClient webClient) {
        this.webClient = webClient;
    }

    public PokemonDTO getPokemonById(int id) {
        return webClient.get()
                .uri("pokemon/{id}", id)
                .retrieve()
                .bodyToMono(PokemonDTO.class)
                .block();
    }
}
