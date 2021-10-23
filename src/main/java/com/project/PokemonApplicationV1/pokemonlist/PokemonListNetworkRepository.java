package com.project.PokemonApplicationV1.pokemonlist;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PokemonListNetworkRepository {

    private final static String ENDPOINT = "pokemon?offset=%d&limit=%d";
    private final String endpointUrl;
    private final RestTemplate restTemplate;


    public PokemonListNetworkRepository(@Value("${pokeapi.url}") String baseUrl, RestTemplate restTemplate) {
        this.endpointUrl = baseUrl + ENDPOINT;
        this.restTemplate = restTemplate;
    }

    public PokemonListResults fetchPokemonList(int offset, int limit){

        String url = String.format(endpointUrl,offset,limit);
        return restTemplate.getForObject(url,PokemonListResults.class);
    }


}
