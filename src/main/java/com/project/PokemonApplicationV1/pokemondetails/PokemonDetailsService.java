package com.project.PokemonApplicationV1.pokemondetails;

import com.project.PokemonApplicationV1.pokemonlist.Pokemon;
import com.project.PokemonApplicationV1.pokemonlist.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonDetailsService {

    private final PokemonRepository pokemonRepository;
    private final PokemonDetailsNetworkRepository pokemonDetailsNetworkRepository;
    private final PokemonDetailsDto pokemonDetailsDto;


    @Autowired
    public PokemonDetailsService(PokemonRepository pokemonRepository,
                                 PokemonDetailsNetworkRepository pokemonDetailsNetworkRepository,
                                 PokemonDetailsDto pokemonDetailsDto) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonDetailsNetworkRepository = pokemonDetailsNetworkRepository;
        this.pokemonDetailsDto = pokemonDetailsDto;
    }

    public PokemonDetails getPokemonDetails(String pokemonName) {

        Pokemon pokemon = pokemonRepository.findByName(pokemonName)
                .orElseThrow(() -> new NoPokemonFoundException(pokemonName));

        PokemonDetails pokemonDetails = pokemonDetailsDto.toEntity(pokemonDetailsNetworkRepository.fetchPokemonDetails(pokemon.getId()));

        return pokemonDetails;

    }

    public List<PokemonDetails> getPokemonDetailsList(String pokemonNameList){

        List<PokemonDetails> pokemonDetailsList;
        String[] pokemonNames = pokemonNameList.split(",");

        pokemonDetailsList = Arrays.stream(pokemonNames).map(name -> getPokemonDetails(name))
                .collect(Collectors.toList());


        return pokemonDetailsList;

    }


}
