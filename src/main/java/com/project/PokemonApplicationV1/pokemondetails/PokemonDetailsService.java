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
    private final PokemonDetailsRepository pokemonDetailsRepository;

    @Autowired
    public PokemonDetailsService(PokemonRepository pokemonRepository,
                                 PokemonDetailsNetworkRepository pokemonDetailsNetworkRepository,
                                 PokemonDetailsDto pokemonDetailsDto,
                                 PokemonDetailsRepository pokemonDetailsRepository) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonDetailsNetworkRepository = pokemonDetailsNetworkRepository;
        this.pokemonDetailsDto = pokemonDetailsDto;
        this.pokemonDetailsRepository = pokemonDetailsRepository;
    }

    public PokemonDetails getPokemonDetails(String pokemonName) {
        return pokemonDetailsRepository.findById(pokemonName).orElseGet(() ->{
            Pokemon pokemon = pokemonRepository.findByName(pokemonName)
                    .orElseThrow(() -> new NoPokemonFoundException(pokemonName));
            PokemonDetailsResponse pokemonDetailsResponse = pokemonDetailsNetworkRepository.fetchPokemonDetails(pokemon.getId());
            PokemonDetails pokemonDetails = pokemonDetailsDto.toEntity(pokemonDetailsResponse);
            return pokemonDetailsRepository.save(pokemonDetails);
        });
    }

    public List<PokemonDetails> getPokemonDetailsList(String pokemonNameList){

        List<PokemonDetails> pokemonDetailsList;
        String[] pokemonNames = pokemonNameList.split(",");

        pokemonDetailsList = Arrays.stream(pokemonNames).map(name -> getPokemonDetails(name))
                .collect(Collectors.toList());


        return pokemonDetailsList;

    }


}
