package com.project.PokemonApplicationV1.pokemonlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonListService {

    private final PokemonListNetworkRepository pokemonListNetworkRepository;
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonListService(PokemonListNetworkRepository pokemonListNetworkRepository,
                              PokemonRepository pokemonRepository) {
        this.pokemonListNetworkRepository = pokemonListNetworkRepository;
        this.pokemonRepository = pokemonRepository;
    }





    public List<PokemonItem> getPokemonList(){

        if(pokemonRepository.count()!=0){
          return   pokemonRepository.findAll();
        }

       final List<PokemonItem> pokemons = new ArrayList<>();
       int offset =0;
       int limit = 100;
       PokemonListResults pokemonListResults;

       do{
           pokemonListResults= pokemonListNetworkRepository.fetchPokemonList(offset,limit);
           pokemonListResults.getResults().forEach(pokemon -> {
                       String[] splitUrl =pokemon.getUrl().split("/");
                       pokemon.setId(Integer.parseInt(splitUrl[splitUrl.length-1]));
                   });

           pokemons.addAll(pokemonListResults.getResults());
           offset+=limit;

       }while (pokemonListResults.getNext()!=null);
       pokemonRepository.saveAll(pokemons);
       return pokemons;
    }
}
