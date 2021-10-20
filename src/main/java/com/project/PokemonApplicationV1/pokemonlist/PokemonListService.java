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
       int offset =0;
       int limit = 100;
       PokemonListResults pokemonListResults;

       do{
           pokemonListResults= pokemonListNetworkRepository.fetchPokemonList(offset,limit);
           pokemons.addAll(pokemonListResults.getResults());
           offset+=limit;

       }while (pokemonListResults.getNext()!=null);


       return pokemons;
    }
}
