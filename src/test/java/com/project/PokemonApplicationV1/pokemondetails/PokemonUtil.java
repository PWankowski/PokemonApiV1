package com.project.PokemonApplicationV1.pokemondetails;

import com.project.PokemonApplicationV1.pokemonlist.Pokemon;
import lombok.experimental.UtilityClass;


import java.util.Arrays;

@UtilityClass
public class PokemonUtil {



    public static PokemonDetails getPokemonDetails(String name){
        PokemonDetails pokemonDetails = new PokemonDetails();
        if(name.equals("pikachu")){

            pokemonDetails.setName(name);
            pokemonDetails.setAbilities(Arrays.asList("static", "lightning-rod"));
            pokemonDetails.setHeight(4);
            pokemonDetails.setWeight(60);
            pokemonDetails.setImageUrl("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png");
            pokemonDetails.setTypes(Arrays.asList("electric"));
            return pokemonDetails;
        }else if(name.equals("bulbasaur")){

            pokemonDetails.setName(name);
            pokemonDetails.setAbilities(Arrays.asList("overgrow", "chlorophyll"));
            pokemonDetails.setHeight(7);
            pokemonDetails.setWeight(69);
            pokemonDetails.setImageUrl("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png");
            pokemonDetails.setTypes(Arrays.asList("grass","poison"));

        }
        return pokemonDetails;

    }

    public static PokemonDetailsResponse getPokemonDetailsResponse(){

        Sprites sprites = new Sprites();
        sprites.setImg("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png");
        Abilities abilities1 = new Abilities();
        AbilityItem abilityItem1 = new AbilityItem();
        abilityItem1.setName("overgrow");
        abilities1.setAbility(abilityItem1);
        Abilities abilities2 = new Abilities();
        AbilityItem abilityItem2 = new AbilityItem();
        abilityItem2.setName("chlorophyll");
        abilities2.setAbility(abilityItem2);
        Types types1 = new Types();
        Type type1 = new Type();
        type1.setName("grass");
        types1.setType(type1);
        Types types2 = new Types();
        Type type2 = new Type();
        type2.setName("poison");
        types2.setType(type2);

        PokemonDetailsResponse pokemonDetailsResponse = new PokemonDetailsResponse();

        pokemonDetailsResponse.setName("bulbasaur");
        pokemonDetailsResponse.setAbilities(Arrays.asList(abilities1,abilities2));
        pokemonDetailsResponse.setHeight(7);
        pokemonDetailsResponse.setWeight(69);
        pokemonDetailsResponse.setSprites(sprites);
        pokemonDetailsResponse.setTypes(Arrays.asList(types1,types2));
        return pokemonDetailsResponse;
    }

}
