package com.project.PokemonApplicationV1.pokemonlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {


    Optional<Pokemon> findByName(String name);

}
