package com.project.PokemonApplicationV1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpComponentProvider {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}