package com.project.PokemonApplicationV1.pokemonlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonListService {

    private final PokemonListNetworkRepository pokemonListNetworkRepository;

    @Autowired
    public PokemonListService(PokemonListNetworkRepository pokemonListNetworkRepository) {
        this.pokemonListNetworkRepository = pokemonListNetworkRepository;
    }


    public List<PokemonItem> getPokemonList(){

       final List<PokemonItem> pokemons = new ArrayList<>();
       PokemonListResults pokemonListResults = pokemonListNetworkRepository.fetchPokemonList();

       pokemons.addAll(pokemonListResults.getResults());

       return pokemons;
    }
}
