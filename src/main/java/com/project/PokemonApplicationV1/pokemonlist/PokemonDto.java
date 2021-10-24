package com.project.PokemonApplicationV1.pokemonlist;

import org.springframework.stereotype.Component;

@Component
 class PokemonDto {

     Pokemon toEntity(PokemonItem pokemonItem){

        Pokemon pokemon = new Pokemon();

        pokemon.setName(pokemonItem.getName());
        pokemon.setUrl(pokemonItem.getUrl());
        String[] splitUrl =pokemonItem.getUrl().split("/");
        pokemon.setId(Integer.parseInt(splitUrl[splitUrl.length-1]));

        return pokemon;


    }
}
