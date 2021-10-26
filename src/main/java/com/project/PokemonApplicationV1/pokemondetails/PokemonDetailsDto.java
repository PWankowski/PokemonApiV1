package com.project.PokemonApplicationV1.pokemondetails;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PokemonDetailsDto {


    public PokemonDetails toEntity(PokemonDetailsResponse pokemonDetailsResponse) {
        PokemonDetails pokemonDetails = new PokemonDetails();
        pokemonDetails.setName(pokemonDetailsResponse.getName());
        pokemonDetails.setHeight(pokemonDetailsResponse.getHeight());
        pokemonDetails.setWeight(pokemonDetailsResponse.getWeight());
        pokemonDetails.setImageUrl(pokemonDetailsResponse.getSprites().getImg());
        pokemonDetails.setAbilities(pokemonDetailsResponse.getAbilities()
                .stream().map(abilities -> abilities.getAbility())
                .map(abilityItem -> abilityItem.getName())
                .collect(Collectors.toList())
        );
        pokemonDetails.setTypes(pokemonDetailsResponse.getTypes()
                .stream().map(types -> types.getType())
                .map(type -> type.getName())
                .collect(Collectors.toList()));

        return pokemonDetails;
    }


}
