package com.thepokemoncompany.pokedex.viewModel;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.thepokemoncompany.pokedex.R;
import com.thepokemoncompany.pokedex.model.pojo.PokemonDB;
import com.thepokemoncompany.pokedex.view.DetailsActivity;

import java.util.List;

/**
 * Created by giori on 16/01/2018.
 */

public class PokemonAdapterMain extends RecyclerView.Adapter<PokemonAdapterMain.PokeViewHolder> {

    private List<PokemonDB> pokemonList;
    private Context mContext;

    public class PokeViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image, overflow;

        public PokeViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            image = (ImageView) itemView.findViewById(R.id.iv_icon);
            overflow = (ImageView) itemView.findViewById(R.id.overflow);
        }
    }

    public PokemonAdapterMain(Context mContext, List<PokemonDB> pokemonList) {
        this.mContext = mContext;
        this.pokemonList = pokemonList;
    }

    @Override
    public PokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.pokemon_card_main, parent, false);

        return new PokeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PokeViewHolder holder,final int position) {
        final PokemonDB pokemon = pokemonList.get(position);

        if(pokemon != null) {

            holder.name.setText(pokemon.getName());
            Picasso.with(mContext).load(pokemon.getImage()).into(holder.image);
            holder.overflow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    showPopupMenu(holder.overflow, position);
                }
            });

            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    openDetails(pokemon);
                }
            });
        }else{
            holder.name.setText("");
            holder.image.setImageBitmap(null);
        }
    }


    private void openDetails(final PokemonDB pokemon){

        Intent i = new Intent (mContext, DetailsActivity.class);
        i.putExtra("pokemon", pokemon);
        mContext.startActivity(i);
    }

    //Showing popup menu when tapping on 3 ic_dots

    private void showPopupMenu(View view, int position) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_info, popup.getMenu());
        popup.setOnMenuItemClickListener(new MenuItemClickListener(position));
        popup.show();
    }

    //Click listener for popup menu items

    class MenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        int position;

        public MenuItemClickListener(final int position) {
            this.position = position;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext,R.string.action_add_to_caught, Toast.LENGTH_SHORT).show();
                    changeStatusPokemon(pokemonList.get(position), true, position);
                    return true;
                case R.id.action_remove_favourite:
                    Toast.makeText(mContext, R.string.action_remove_caught, Toast.LENGTH_SHORT).show();
                    changeStatusPokemon(pokemonList.get(position), false, position);
                    return true;
                default:
            }
            return false;
        }
    }

    //Change status of catch in the Database
    private void changeStatusPokemon(final PokemonDB pokemon, final boolean catched, final int position){

        new Thread(new Runnable() {
            @Override
            public void run() {
                DatabaseController databaseController = new DatabaseController(mContext);
                pokemonList.get(position).setCatch(catched);
                pokemon.setCatch(catched);
                if(!catched)
                    pokemon.setMyTeam(false);
                databaseController.updateData(pokemon);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }
}