package com.project.PokemonApplicationV1.pokemonlist;

import com.project.PokemonApplicationV1.pokemondetails.PokemonDetails;
import org.springframework.stereotype.Component;

@Component
 class PokemonListItemDto {


    public PokemonListItem toEntity(PokemonDetails pokemonDetails){
        PokemonListItem pokemonListItem = new PokemonListItem();
        pokemonListItem.setName(pokemonDetails.getName());
        pokemonListItem.setImageurl(pokemonDetails.getImageUrl());
        pokemonListItem.setUrl("localhost:8080/pokemon?names=" + pokemonDetails.getName());
        return pokemonListItem;


    }
}
