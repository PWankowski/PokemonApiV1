package com.project.PokemonApplicationV1.pokemonlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
 class PokemonController {

    private final PokemonListService pokemonListService;

    @Autowired
     PokemonController(PokemonListService pokemonListService) {
        this.pokemonListService = pokemonListService;
    }

    @GetMapping("/list")
     List<Pokemon> getPokemonList(){

      return   pokemonListService.getPokemonList();
    }



}
