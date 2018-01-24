package com.thepokemoncompany.pokedex.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.thepokemoncompany.pokedex.model.ApiClient;
import com.thepokemoncompany.pokedex.model.ApiInterface;
import com.thepokemoncompany.pokedex.viewModel.DatabaseController;
import com.thepokemoncompany.pokedex.viewModel.Helper;
import com.thepokemoncompany.pokedex.R;
import com.thepokemoncompany.pokedex.model.pojo.PokemonDB;
import com.thepokemoncompany.pokedex.model.pojo.Pokedex;
import com.thepokemoncompany.pokedex.model.pojo.Pokemon;
import com.thepokemoncompany.pokedex.model.pojo.Species;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    private ImageView pokeball;
    private TextView title;
    private static int SPLASH_TIME_OUT = 3000;
    private ApiInterface apiService;
    private Context mContex;

    private int totalPokemon;
    private float proportionRotation;

    DatabaseController databaseController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pokeball = (ImageView) findViewById(R.id.iv_pokeball);
        title = (TextView) findViewById(R.id.tv_splash);

        mContex = this;
        apiService = ApiClient.getClient().create(ApiInterface.class);
        databaseController = new DatabaseController(getBaseContext());

        if(Helper.isOnline(mContex))
            callPokedexCount();
        else
            openPokedex();
    }

    void verifyDataBase(){ //Verify if is necessary to load data from API

        int countDataDatabase = databaseController.readListPokemon().size();

        if(countDataDatabase == totalPokemon){
            openPokedex();
        }else{
            title.setText(getResources().getString(R.string.loading_pokemons));
            databaseController.deleteTablePokemon();
            proportionRotation = -(((float) 360)/totalPokemon);
            callPokemonsData(-1);
        }
    }

    private void callPokedexCount(){ //Call API to get how many Pokemons are in this Pokedex(5 - The base pokedex of game)

        new Thread(new Runnable() {
            @Override
            public void run() {

                Call<Pokedex> call = apiService.getPokedex(5);
                call.enqueue(new Callback<Pokedex>() {

                    @Override
                    public void onResponse(Call<Pokedex> call, Response<Pokedex> response) {

                        if(response.isSuccessful()){

                            totalPokemon = response.body().getPokemonEntries().size();
                            verifyDataBase();

                        }else {
                            Toast.makeText(mContex, R.string.m_error ,Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Pokedex> call, Throwable t) {
                        Toast.makeText(mContex, R.string.m_error + t.getMessage() ,Toast.LENGTH_LONG).show();
                    }

                });
            }
        }).start();
    }

    private void callPokemonsData(final int id){// Call API to get data of each Pokemon discovery

        new Thread(new Runnable() {
            @Override
            public void run() {

                int count, request;

                if(id == -1)
                    count = totalPokemon;
                else
                    count = 1;

                while(count > 0){

                    request = count;

                    if (id != -1)
                        request = id;

                    Call<Pokemon> call = apiService.getPokemon(request);
                    baseCallPokemon(call);
                    count--;
                }
            }
        }).start();
    }

    private void baseCallPokemon(final Call call){// Call API to get data, it is separated for recursion calls

        new Thread(new Runnable() {
            @Override
            public void run() {

                call.enqueue(new Callback<Pokemon>() {
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {

                        if(response.isSuccessful()) {

                            PokemonDB pokemonDB = new PokemonDB(response.body());
                            savePokemonData(pokemonDB);
                        }
                    }

                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t) {
                        Toast.makeText(mContex, R.string.m_weak_signal, Toast.LENGTH_SHORT).show();

                        try {
                            call.execute();
                        } catch (IOException e) {
                            //e.printStackTrace();
                        } catch (Exception e){
                            //e.printStackTrace();
                        } finally {
                            totalPokemon--;
                        }

                        //baseCallPokemon(reCall);
                    }
                });
            }
        }).start();
    }

    private void callPokemonsDataExtended(final int id){//Call API to get more data of each pokemon

        new Thread(new Runnable() {
            @Override
            public void run() {
                Call<Species> call = apiService.getSpecies(id);
                call.enqueue(new Callback<Species>() {
                    @Override
                    public void onResponse(Call<Species> call, Response<Species> response) {

                        if(response.isSuccessful())
                            savePokemonExtendedData(response.body());

                    }

                    @Override
                    public void onFailure(Call<Species> call, Throwable t) {
                        Toast.makeText(mContex, R.string.m_weak_signal, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }

    private void savePokemonData(final PokemonDB pokemon){//Save in the database the pokemon received

        new Thread(new Runnable() {
            @Override
            public void run() {
                databaseController.insertPokemon(pokemon);
                callPokemonsDataExtended(pokemon.getNumber());
            }
        }).start();
    }

    private void savePokemonExtendedData(final Species specie){//Save (Update) in Database, add extra data

        new Thread(new Runnable() {
            @Override
            public void run() {

                databaseController.updateDataSpecie(specie);

                totalPokemon--;
                rotationIcon(proportionRotation * totalPokemon);

                if(totalPokemon == 0)
                    openPokedex();
            }
        }).start();
    }

    private void rotationIcon(final float value){

        new Thread(new Runnable() {
            @Override
            public void run() {
                pokeball.setRotation(value);
            }
        }).start();
    }

    private void openPokedex(){
        Intent i = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }



}
