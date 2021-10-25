package com.project.PokemonApplicationV1.pokemondetails;

import com.project.PokemonApplicationV1.pokemonlist.Pokemon;
import com.project.PokemonApplicationV1.pokemonlist.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonDetailsService {

    private final PokemonRepository pokemonRepository;
    private final PokemonDetailsNetworkRepository pokemonDetailsNetworkRepository;

    @Autowired
    public PokemonDetailsService(PokemonRepository pokemonRepository,
                                 PokemonDetailsNetworkRepository pokemonDetailsNetworkRepository) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonDetailsNetworkRepository = pokemonDetailsNetworkRepository;
    }

    public PokemonDetailsResponse getPokemonDetails(String pokemonName){

       Pokemon pokemon = pokemonRepository.findByName(pokemonName)
               .orElseThrow( () -> new NoPokemonFoundException(pokemonName));

       return pokemonDetailsNetworkRepository.fetchPokemonDetails(pokemon.getId());
    }



}
