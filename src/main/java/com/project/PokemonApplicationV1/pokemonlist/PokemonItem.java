package com.project.PokemonApplicationV1.pokemonlist;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PokemonItem {

    @Id
    private int id;

    private String name;
    private String url;

    public PokemonItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
