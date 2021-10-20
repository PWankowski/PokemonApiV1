package com.project.PokemonApplicationV1.pokemonlist;

import java.util.List;

public class PokemonListResults {

    private List<PokemonItem> results;
    private String next;

    public PokemonListResults() {
    }


    public List<PokemonItem> getResults() {
        return results;
    }

    public void setResults(List<PokemonItem> results) {
        this.results = results;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
