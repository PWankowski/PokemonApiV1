package com.project.PokemonApplicationV1.pokemonlist;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PokemonListNetworkRepository {

    public PokemonListResults fetchPokemonList(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://pokeapi.co/api/v2/pokemon?limit=100&offset=0";
        return restTemplate.getForObject(url,PokemonListResults.class);
    }


}
