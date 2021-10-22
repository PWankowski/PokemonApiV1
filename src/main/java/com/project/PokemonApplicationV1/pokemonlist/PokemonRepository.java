package com.project.PokemonApplicationV1.pokemonlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonItem,Integer> {


}
