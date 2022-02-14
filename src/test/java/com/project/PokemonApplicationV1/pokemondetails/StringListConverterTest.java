package com.project.PokemonApplicationV1.pokemondetails;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListConverterTest {

    private final StringListConverter stringListConverter = new StringListConverter();

    @Test
    void shouldConvertToDatabaseColumn() {

        //given
        List<String> inputList = Arrays.asList("bulbasau","ivysaur","charmander");

        //when
        String result = stringListConverter.convertToDatabaseColumn(inputList);

        //then
        assertNotNull(result);
        assertEquals("bulbasau,ivysaur,charmander",result);

    }

    @Test
    void shouldConvertToEntityAttribute() {

        //given

        String input = "overgrow,chlorophyll,static";


        //when
        List<String> result = stringListConverter.convertToEntityAttribute(input);

        //then
        assertNotNull(result);
        assertEquals(Arrays.asList("overgrow", "chlorophyll", "static"),result);
    }
}