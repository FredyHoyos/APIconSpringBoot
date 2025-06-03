package com.udea.FredyHoyos.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.udea.FredyHoyos.entities.AgePredictionDTO;
import com.udea.FredyHoyos.services.AgePredictionService;

@RestController
public class ApiController {


    private final AgePredictionService pokemonService;

    public ApiController(AgePredictionService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon")
    public AgePredictionDTO gPokemon(@RequestParam String name) {
        return pokemonService.getAgePredictionByName(name);
    }
    
}
