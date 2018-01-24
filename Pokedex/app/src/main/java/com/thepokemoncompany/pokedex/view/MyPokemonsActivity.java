package com.thepokemoncompany.pokedex.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.thepokemoncompany.pokedex.viewModel.DatabaseController;
import com.thepokemoncompany.pokedex.viewModel.PokemonAdapterMyList;
import com.thepokemoncompany.pokedex.R;
import com.thepokemoncompany.pokedex.model.pojo.PokemonDB;

import java.util.ArrayList;
import java.util.List;

public class MyPokemonsActivity extends AppCompatActivity {

    private TextView tvNoTeam;
    private LinearLayout layout;

    private TextView hpPokemon;
    private TextView attackPokemon;
    private TextView defensePokemon;
    private TextView spAttackPokemon;
    private TextView spDefensePokemon;
    private TextView speedPokemon;
    private TextView totalPokemon;

    private ProgressBar progHpPokemon;
    private ProgressBar progAttackPokemon;
    private ProgressBar progDefensePokemon;
    private ProgressBar progSpAttackPokemon;
    private ProgressBar progSpDefensePokemon;
    private ProgressBar progSpeedPokemon;
    private ProgressBar progTotalPokemon;
    
    private TextView bestAttack;
    
    private RecyclerView recyclerView;

    private Context mContext;
    private DatabaseController controller;
    private List<PokemonDB> listMyPokemons;
    private PokemonAdapterMyList pokemonAdapter;
    private int countTeam;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pokemons);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvNoTeam = (TextView) findViewById(R.id.tv_team_empty);
        layout = (LinearLayout) findViewById(R.id.layout);

        hpPokemon = (TextView) findViewById(R.id.tv_my_pokemons_hp);
        attackPokemon = (TextView) findViewById(R.id.tv_my_pokemons_attack);
        defensePokemon = (TextView) findViewById(R.id.tv_my_pokemons_defense);
        spAttackPokemon = (TextView) findViewById(R.id.tv_my_pokemons_sp_attack);
        spDefensePokemon = (TextView) findViewById(R.id.tv_my_pokemons_sp_defense);
        speedPokemon = (TextView) findViewById(R.id.tv_my_pokemons_speed);
        totalPokemon = (TextView) findViewById(R.id.tv_my_pokemons_total);

        progHpPokemon = (ProgressBar) findViewById(R.id.progress_my_pokemons_hp);
        progAttackPokemon = (ProgressBar) findViewById(R.id.progress_my_pokemons_attack);
        progDefensePokemon = (ProgressBar) findViewById(R.id.progress_my_pokemons_defense);
        progSpAttackPokemon = (ProgressBar) findViewById(R.id.progress_my_pokemons_sp_attack);
        progSpDefensePokemon = (ProgressBar) findViewById(R.id.progress_my_pokemons_sp_defense);
        progSpeedPokemon = (ProgressBar) findViewById(R.id.progress_my_pokemons_speed);
        progTotalPokemon = (ProgressBar) findViewById(R.id.progress_my_pokemons_total);

        bestAttack = (TextView) findViewById(R.id.tv_my_pokemons_best_attack);
        recyclerView = (RecyclerView) findViewById(R.id.rv_my_pokemons);

        mContext = this;
        countTeam = 0;
        controller = new DatabaseController(mContext);
        listMyPokemons = new ArrayList<PokemonDB>();
        getMyPokemons();
        printData();

        pokemonAdapter = new PokemonAdapterMyList(this, listMyPokemons, countTeam);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(pokemonAdapter);

        if(listMyPokemons.size() == 0) {
            tvNoTeam.setVisibility(View.VISIBLE);
            layout.setVisibility(View.GONE);
        }else{
            tvNoTeam.setVisibility(View.GONE);
            layout.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getMyPokemons(){
        listMyPokemons.addAll(controller.readListMyPokemons());
    }

    private void printData(){

        int hp = 0, attack = 0, defense = 0, sp_attack = 0, sp_defense = 0, speed = 0, total = 0;

        for(PokemonDB pokemon : listMyPokemons){

            if(pokemon.isMyTeam() == true){

                countTeam++;
                hp += pokemon.getHp();
                attack += pokemon.getAttack();
                defense += pokemon.getDefense();
                sp_attack += pokemon.getSp_attack();
                sp_defense += pokemon.getSp_defense();
                speed += pokemon.getSpeed();
                total += pokemon.getTotal();
            }
        }

        hpPokemon.setText(String.valueOf(hp));
        attackPokemon.setText(String.valueOf(attack));
        defensePokemon.setText(String.valueOf(defense));
        spAttackPokemon.setText(String.valueOf(sp_attack));
        spDefensePokemon.setText(String.valueOf(sp_defense));
        speedPokemon.setText(String.valueOf(speed));
        totalPokemon.setText(String.valueOf(total));

        progHpPokemon.setProgress(hp);
        progAttackPokemon.setProgress(attack);
        progDefensePokemon.setProgress(defense);
        progSpAttackPokemon.setProgress(sp_attack);
        progSpDefensePokemon.setProgress(sp_defense);
        progSpeedPokemon.setProgress(speed);
        progTotalPokemon.setProgress(total);

        bestAttack.setText(String.valueOf(controller.bestAtack()));
    }
}
