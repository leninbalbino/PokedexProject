package com.thepokemoncompany.pokedex.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thepokemoncompany.pokedex.R;
import com.thepokemoncompany.pokedex.model.pojo.PokemonDB;

public class DetailsActivity extends AppCompatActivity {

    private PokemonDB pokemon;
    private ImageView imagePokemon;
    private TextView namePokemon;
    private TextView heightPokemon;
    private TextView weightPokemon;
    private TextView abilitiesPokemon;

    private TextView hpPokemon;
    private TextView attackPokemon;
    private TextView defensePokemon;
    private TextView spAttackPokemon;
    private TextView spDefensePokemon;
    private TextView speedPokemon;
    private TextView totalPokemon;

    private TextView genderFemalePokemon;
    private TextView genderMalePokemon;
    private TextView growRatePokemon;
    private TextView captureRatePokemon;
    private TextView movimentsPokemon;

    private ProgressBar progHpPokemon;
    private ProgressBar progAttackPokemon;
    private ProgressBar progDefensePokemon;
    private ProgressBar progSpAttackPokemon;
    private ProgressBar progSpDefensePokemon;
    private ProgressBar progSpeedPokemon;
    private ProgressBar progTotalPokemon;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imagePokemon = (ImageView) findViewById(R.id.iv_details_icon);
        namePokemon = (TextView) findViewById(R.id.tv_details_name);
        heightPokemon = (TextView) findViewById(R.id.tv_details_height);
        weightPokemon = (TextView) findViewById(R.id.tv_details_weight);
        abilitiesPokemon = (TextView) findViewById(R.id.tv_details_abilities);

        hpPokemon = (TextView) findViewById(R.id.tv_details_hp);
        attackPokemon = (TextView) findViewById(R.id.tv_details_attack);
        defensePokemon = (TextView) findViewById(R.id.tv_details_defense);
        spAttackPokemon = (TextView) findViewById(R.id.tv_details_sp_attack);
        spDefensePokemon = (TextView) findViewById(R.id.tv_details_sp_defense);
        speedPokemon = (TextView) findViewById(R.id.tv_details_speed);
        totalPokemon = (TextView) findViewById(R.id.tv_details_total);

        genderFemalePokemon = (TextView) findViewById(R.id.tv_details_gender_female);
        genderMalePokemon = (TextView) findViewById(R.id.tv_details_gender_male);
        growRatePokemon = (TextView) findViewById(R.id.tv_details_growth_rate);
        captureRatePokemon = (TextView) findViewById(R.id.tv_details_capture_rate);
        movimentsPokemon = (TextView) findViewById(R.id.tv_details_movements);

        progHpPokemon = (ProgressBar) findViewById(R.id.progress_details_hp);
        progAttackPokemon = (ProgressBar) findViewById(R.id.progress_details_attack);
        progDefensePokemon = (ProgressBar) findViewById(R.id.progress_details_defense);
        progSpAttackPokemon = (ProgressBar) findViewById(R.id.progress_details_sp_attack);
        progSpDefensePokemon = (ProgressBar) findViewById(R.id.progress_details_sp_defense);
        progSpeedPokemon = (ProgressBar) findViewById(R.id.progress_details_speed);
        progTotalPokemon = (ProgressBar) findViewById(R.id.progress_details_total);

        Intent i = getIntent();
        pokemon = i.getParcelableExtra("pokemon");

        mContext = this;

        printData();
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

    private void printData(){

        Picasso.with(mContext).load(pokemon.getImage()).into(imagePokemon);
        namePokemon.setText(pokemon.getName());
        heightPokemon.setText(String.valueOf(pokemon.getHeight()) + " m");
        weightPokemon.setText(String.valueOf(pokemon.getWeight()) + " Kg");
        abilitiesPokemon.setText(pokemon.getAbilities());

        hpPokemon.setText(String.valueOf(pokemon.getHp()));
        attackPokemon.setText(String.valueOf(pokemon.getAttack()));
        defensePokemon.setText(String.valueOf(pokemon.getAttack()));
        spAttackPokemon.setText(String.valueOf(pokemon.getSp_attack()));
        spDefensePokemon.setText(String.valueOf(pokemon.getSp_defense()));
        speedPokemon.setText(String.valueOf(pokemon.getSpeed()));
        totalPokemon.setText(String.valueOf(pokemon.getTotal()));

        progHpPokemon.setProgress(pokemon.getHp());
        progAttackPokemon.setProgress(pokemon.getAttack());
        progDefensePokemon.setProgress(pokemon.getDefense());
        progSpAttackPokemon.setProgress(pokemon.getSp_attack());
        progSpDefensePokemon.setProgress(pokemon.getSp_defense());
        progSpeedPokemon.setProgress(pokemon.getSpeed());
        progTotalPokemon.setProgress(pokemon.getTotal());

        if(pokemon.getGender_female() < 0){ //For genderless Pokemon
            genderFemalePokemon.setText(0);
            genderMalePokemon.setText(0);
        }else{
            genderFemalePokemon.setText(String.valueOf(pokemon.getGender_female()));
            genderMalePokemon.setText(String.valueOf(1 - pokemon.getGender_female()));
        }
        growRatePokemon.setText(pokemon.getGrowth_rate());
        captureRatePokemon.setText(String.valueOf(pokemon.getCapture_rate()));
        movimentsPokemon.setText(pokemon.getMoviments());
    }
}

