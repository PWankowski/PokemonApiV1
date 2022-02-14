package com.project.PokemonApplicationV1.pokemondetails;

import com.project.PokemonApplicationV1.pokemonlist.PokemonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PokemonDetailsServiceTest {

    @Mock
    private  PokemonRepository pokemonRepository;
    @Mock
    private  PokemonDetailsNetworkRepository pokemonDetailsNetworkRepository;
    @Mock
    private  PokemonDetailsDto pokemonDetailsDto;
    @Mock
    private  PokemonDetailsRepository pokemonDetailsRepository;
    @InjectMocks
    private PokemonDetailsService pokemonDetailsService;



    @Test
    void shouldReturnPokemonDetailsForPokemonName(){

        //given
        Mockito.when(pokemonDetailsRepository.findById(any()))
                .thenReturn(Optional.of(PokemonUtil.getPokemonDetails("bulbasaur")));


        //when
        PokemonDetails result = pokemonDetailsService.getPokemonDetails("bulbasaur");
        //then
        assertNotNull(result);
        assertEquals("bulbasaur", result.getName());
        assertEquals(Arrays.asList("overgrow", "chlorophyll"), result.getAbilities());
        assertEquals(7, result.getHeight());
        assertEquals(69, result.getWeight());
        assertEquals("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", result.getImageUrl());
        assertEquals(Arrays.asList("grass","poison"), result.getTypes());

    }

    @Test
    void shouldThrowNoPokemonFoundException(){

        //given
        String name = "pikachuuu";
        Mockito.when(pokemonDetailsRepository.findById(name))
                .thenThrow(new NoPokemonFoundException(name));

        //when
        NoPokemonFoundException result = assertThrows(NoPokemonFoundException.class,
                () -> pokemonDetailsService.getPokemonDetails(name));


        //then
        assertEquals(result.getClass(),NoPokemonFoundException.class);
        assertEquals("No pokemon with name pikachuuu found! ",result.getMessage());

    }

    @Test
    void shouldReturnListOfPokemonDetails(){

        //given
        String names = "bulbasaur,pikachu";
        Mockito.when(pokemonDetailsRepository.findById("bulbasaur"))
                .thenReturn(Optional.of(PokemonUtil.getPokemonDetails("bulbasaur")));
        Mockito.when(pokemonDetailsRepository.findById("pikachu"))
                .thenReturn(Optional.of(PokemonUtil.getPokemonDetails("pikachu")));

        //when
        List<PokemonDetails> resultList = pokemonDetailsService.getPokemonDetailsList(names);

        //then
        assertNotNull(resultList);
        assertEquals("bulbasaur", resultList.get(0).getName());
        assertEquals(Arrays.asList("overgrow", "chlorophyll"), resultList.get(0).getAbilities());
        assertEquals(7, resultList.get(0).getHeight());
        assertEquals(69, resultList.get(0).getWeight());
        assertEquals("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", resultList.get(0).getImageUrl());
        assertEquals(Arrays.asList("grass","poison"), resultList.get(0).getTypes());


        assertEquals("pikachu", resultList.get(1).getName());
        assertEquals(Arrays.asList("static", "lightning-rod"), resultList.get(1).getAbilities());
        assertEquals(4, resultList.get(1).getHeight());
        assertEquals(60, resultList.get(1).getWeight());
        assertEquals("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png", resultList.get(1).getImageUrl());
        assertEquals(Arrays.asList("electric"), resultList.get(1).getTypes());

    }

}
