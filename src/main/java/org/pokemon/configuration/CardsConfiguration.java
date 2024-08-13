package org.pokemon.configuration;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.pokemon.tcgapi.dto.PokemonAPICard;
import org.pokemon.tcgapi.dto.PokemonAPIResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.List;

@Configuration
@Slf4j
public class CardsConfiguration {

    @Value("${pokemon.api.url}")
    private String pokemonAPIURL;

    @Bean
    public List<PokemonAPICard> cardsFromApi() {

        log.debug("Loading cards from TCG API");

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        Request request = new Request.Builder().url(pokemonAPIURL).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            PokemonAPIResponse pokemonAPIResponse = new Gson().fromJson(response.body().string(), PokemonAPIResponse.class);
            return pokemonAPIResponse.getData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
