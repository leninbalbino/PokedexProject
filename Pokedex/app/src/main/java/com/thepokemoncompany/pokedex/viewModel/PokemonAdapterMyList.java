package com.thepokemoncompany.pokedex.viewModel;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.thepokemoncompany.pokedex.R;
import com.thepokemoncompany.pokedex.model.pojo.PokemonDB;
import com.thepokemoncompany.pokedex.view.DetailsActivity;

import java.util.List;

/**
 * Created by lenin on 23/01/2018.
 */

public class PokemonAdapterMyList extends RecyclerView.Adapter<PokemonAdapterMyList.PokeViewHolder>  {

    private List<PokemonDB> pokemonList;
    private Context mContext;
    private int countTeam;

    public class PokeViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;
        public CheckBox isTeam;

        public PokeViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            image = (ImageView) itemView.findViewById(R.id.iv_icon);
            isTeam = (CheckBox) itemView.findViewById(R.id.cb_my_team);
        }
    }

    public PokemonAdapterMyList(Context mContext, List<PokemonDB> pokemonList, int countTeam) {
        this.mContext = mContext;
        this.pokemonList = pokemonList;
        this.countTeam = countTeam;
    }

    @Override
    public PokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.pokemon_card_my_pokemons, parent, false);

        return new PokeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PokeViewHolder holder, final int position) {
        final PokemonDB pokemon = pokemonList.get(position);

        if(pokemon != null) {

            holder.name.setText(pokemon.getName());
            Picasso.with(mContext).load(pokemon.getImage()).into(holder.image);

            if(pokemon.isMyTeam())
                holder.isTeam.setChecked(true);
            else
                holder.isTeam.setChecked(false);

            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    openDetails(pokemon);
                }
            });

            holder.isTeam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    if(b){
                        if (countTeam < 6) {
                            countTeam++;
                            changeStatusPokemon(pokemon, b, position);
                        } else {
                            Toast.makeText(mContext, R.string.m_team_full, Toast.LENGTH_SHORT).show();
                            compoundButton.setChecked(false);
                        }
                    }else {
                        countTeam--;
                        changeStatusPokemon(pokemon, b, position);
                    }
                }
            });

        }else{
            holder.name.setText("");
            holder.image.setImageBitmap(null);
            holder.isTeam.setChecked(false);
        }
    }

    private void openDetails(final PokemonDB pokemon){

        Intent i = new Intent (mContext, DetailsActivity.class);
        i.putExtra("pokemon", pokemon);
        mContext.startActivity(i);
    }

    //Change status if belong team(max 6 pokemons)
    private void changeStatusPokemon(final PokemonDB pokemon, final boolean isMyTeam, final int position){

        new Thread(new Runnable() {
            @Override
            public void run() {
                DatabaseController databaseController = new DatabaseController(mContext);
                pokemon.setMyTeam(isMyTeam);
                pokemonList.get(position).setMyTeam(isMyTeam);
                //notifyItemChanged(position);
                databaseController.updateData(pokemon);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }
}
