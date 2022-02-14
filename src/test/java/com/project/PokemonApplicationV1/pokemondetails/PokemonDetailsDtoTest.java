package com.project.PokemonApplicationV1.pokemondetails;

import org.junit.jupiter.api.Test;


import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

class PokemonDetailsDtoTest {

    private final PokemonDetailsDto pokemonDetailsDto = new PokemonDetailsDto();

    @Test
    void shouldReturnPokemonDetails() {

        //given
        PokemonDetailsResponse pokemonDetailsResponse = PokemonUtil.getPokemonDetailsResponse();

        //when
        PokemonDetails result = pokemonDetailsDto.toEntity(pokemonDetailsResponse);

        //then
        assertNotNull(result);
        assertEquals("bulbasaur", result.getName());
        assertEquals(Arrays.asList("overgrow", "chlorophyll"), result.getAbilities());
        assertEquals(7, result.getHeight());
        assertEquals(69, result.getWeight());
        assertEquals("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", result.getImageUrl());
        assertEquals(Arrays.asList("grass","poison"), result.getTypes());



    }
}