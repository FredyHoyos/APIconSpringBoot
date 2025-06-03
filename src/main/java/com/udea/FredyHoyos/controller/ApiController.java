package com.udea.FredyHoyos.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.udea.FredyHoyos.entities.PokemonDTO;
import com.udea.FredyHoyos.services.PokemonService;

@RestController
public class ApiController {


    private final PokemonService pokemonService;

    public ApiController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon/{id}")
    public PokemonDTO gPokemon(@PathVariable int id) {
        return pokemonService.getPokemonById(id);
    }
    
}
