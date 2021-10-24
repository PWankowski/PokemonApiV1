package com.project.PokemonApplicationV1.pokemondetails;

import com.project.PokemonApplicationV1.pokemonlist.Pokemon;
import com.project.PokemonApplicationV1.pokemonlist.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonDetailsService {

    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonDetailsService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }


    public Pokemon getPokemonDetails(String pokemonName){

       Pokemon pokemon = pokemonRepository.findByName(pokemonName).orElseThrow( () ->{
           return new NoPokemonFoundException(pokemonName);
       });
        return pokemon;
    }



}
