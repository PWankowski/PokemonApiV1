package com.project.PokemonApplicationV1.pokemondetails;

public class NoPokemonFoundException extends RuntimeException {

    public NoPokemonFoundException(String pokemonName) {
        super(String.format("No pokemon with name %s found! ", pokemonName));
    }


}
