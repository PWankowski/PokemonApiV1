package com.project.PokemonApplicationV1.pokemonlist;


import com.project.PokemonApplicationV1.pokemondetails.PokemonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonListService {

    private final PokemonListNetworkRepository pokemonListNetworkRepository;
    private final PokemonRepository pokemonRepository;
    private final PokemonDto pokemonDto;
    private final PokemonDetailsService pokemonDetailsService;
    private  final PokemonListItemDto pokemonListItemDto;

    @Autowired
    public PokemonListService(PokemonListNetworkRepository pokemonListNetworkRepository,
                              PokemonRepository pokemonRepository,
                              PokemonDto pokemonDto,
                              PokemonDetailsService pokemonDetailsService,
                              PokemonListItemDto pokemonListItemDto) {
        this.pokemonListNetworkRepository = pokemonListNetworkRepository;
        this.pokemonRepository = pokemonRepository;
        this.pokemonDto = pokemonDto;
        this.pokemonDetailsService = pokemonDetailsService;
        this.pokemonListItemDto = pokemonListItemDto;
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

    public List<PokemonListItem> getPokemonListItems() {

        final List<PokemonListItem> pokemonListItems = new ArrayList<>();
        int offset =0;
        int limit =20;

        Pageable pageable = PageRequest.of(offset,limit);

       List<Pokemon> pokemonList = pokemonRepository.findAll(pageable).getContent();
      pokemonListItems.addAll(pokemonList.stream()
              .map(pokemon ->
                      pokemonDetailsService.getPokemonDetails(pokemon.getName()))
              .map(pokemonDetails -> {
               return   pokemonListItemDto.toEntity(pokemonDetails);
                      }).collect(Collectors.toList()));


      return  pokemonListItems;




    }
}
