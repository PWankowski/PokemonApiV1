package com.project.PokemonApplicationV1;

import com.project.PokemonApplicationV1.pokemondetails.NoPokemonFoundException;
import com.project.PokemonApplicationV1.pokemondetails.PokemonDetailsService;
import com.project.PokemonApplicationV1.pokemonlist.Pokemon;
import com.project.PokemonApplicationV1.pokemonlist.PokemonListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
 public class PokemonController {

    private final PokemonListService pokemonListService;
    private final PokemonDetailsService pokemonDetailsService;

    @Autowired
    public PokemonController(PokemonListService pokemonListService, PokemonDetailsService pokemonDetailsService) {
        this.pokemonListService = pokemonListService;
        this.pokemonDetailsService = pokemonDetailsService;
    }




    @GetMapping("/list")
    public  List<Pokemon> getPokemonList(){

      return   pokemonListService.getPokemonList();
    }

    @GetMapping("/{name}")
    public Pokemon getPokemonDetails(@PathVariable String name){
        return pokemonDetailsService.getPokemonDetails(name);
    }

    @ExceptionHandler(value = NoPokemonFoundException.class)
    public ResponseEntity<ErrorMessage> handleNoPokemonFoundException(NoPokemonFoundException exception){
        return new ResponseEntity<ErrorMessage>(new ErrorMessage(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }





}
