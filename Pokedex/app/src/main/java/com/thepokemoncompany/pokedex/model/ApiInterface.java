package com.thepokemoncompany.pokedex.model;
import com.thepokemoncompany.pokedex.model.pojo.Pokedex;
import com.thepokemoncompany.pokedex.model.pojo.Pokemon;
import com.thepokemoncompany.pokedex.model.pojo.Species;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by giori on 16/01/2018.
 */

public interface ApiInterface {//Request datas

    @GET("pokedex/{id}")
    Call<Pokedex> getPokedex(@Path("id") int id);

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemon(@Path("id") int id);

    @GET("pokemon-species/{id}")
    Call<Species> getSpecies(@Path("id") int id);
}
