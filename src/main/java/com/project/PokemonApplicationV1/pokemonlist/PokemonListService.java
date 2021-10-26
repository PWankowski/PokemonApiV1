package com.project.PokemonApplicationV1.pokemonlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonListService {

    private final PokemonListNetworkRepository pokemonListNetworkRepository;
    private final PokemonRepository pokemonRepository;
    private final PokemonDto pokemonDto;

    @Autowired
    PokemonListService(PokemonListNetworkRepository pokemonListNetworkRepository,
                       PokemonRepository pokemonRepository,
                       PokemonDto pokemonDto) {
        this.pokemonListNetworkRepository = pokemonListNetworkRepository;
        this.pokemonRepository = pokemonRepository;
        this.pokemonDto = pokemonDto;
    }


    public List<Pokemon> getPokemonList() {

        if (pokemonRepository.count() != 0) {
            return pokemonRepository.findAll();
        }

        final List<Pokemon> pokemons = new ArrayList<>();
        int offset = 0;
        int limit = 100;
        PokemonListResults pokemonListResults;

        do {
            pokemonListResults = pokemonListNetworkRepository.fetchPokemonList(offset, limit);
            pokemons.addAll(pokemonListResults.getResults().stream()
                    .map(pokemon -> pokemonDto.toEntity(pokemon))
                    .collect(Collectors.toList()));

            offset += limit;

        } while (pokemonListResults.getNext() != null);
        pokemonRepository.saveAll(pokemons);
        return pokemons;
    }
}
