package com.thepokemoncompany.pokedex.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;


import com.thepokemoncompany.pokedex.viewModel.DatabaseController;
import com.thepokemoncompany.pokedex.viewModel.PokemonAdapterMain;
import com.thepokemoncompany.pokedex.R;
import com.thepokemoncompany.pokedex.model.pojo.PokemonDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private FloatingActionButton fbMyPokemons;
    private List<PokemonDB> pokemonListShow = new ArrayList<>();
    private int sizeList;
    private RecyclerView recyclerView;
    private PokemonAdapterMain pokemonAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        initCollapsingToolbar();

        fbMyPokemons = (FloatingActionButton) findViewById(R.id.fbMyPokemons);
        recyclerView = (RecyclerView) findViewById(R.id.rv_pokemons);
        pokemonAdapter = new PokemonAdapterMain(mContext,pokemonListShow);

        final RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                // To hide/ to show floatingButton
                if (dy > 0 && fbMyPokemons.getVisibility() == View.VISIBLE) {
                    fbMyPokemons.hide();
                } else if (dy < 0 && fbMyPokemons.getVisibility() != View.VISIBLE) {
                    fbMyPokemons.show();
                }

                if(pokemonListShow.size() == ((GridLayoutManager)mLayoutManager).findLastCompletelyVisibleItemPosition() + 2)
                    addDataDatabase();

            }
        });
        recyclerView.setAdapter(pokemonAdapter);

        fbMyPokemons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMyPokemons();
            }
        });
        addDataDatabase();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void initCollapsingToolbar() { //Control head of mainActivity
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    // RecyclerView item decoration - give equal margin around grid item

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    public void addDataDatabase(){//Add data to list of pokemons visible

        List<PokemonDB> list;
        DatabaseController databaseController = new DatabaseController(mContext);

        if(pokemonListShow.size() == 0)
            pokemonListShow.addAll(databaseController.readListPokemonForMenu(0));
        else {
            list = databaseController.readListPokemonForMenu(pokemonListShow.get(pokemonListShow.size() - 1).getNumber());
            pokemonListShow.addAll(list);
        }
        pokemonAdapter.notifyDataSetChanged();
    }

    private void openMyPokemons(){

        Intent i = new Intent(MainActivity.this, MyPokemonsActivity.class);
        startActivity(i);
    }

    private int dpToPx(int dp) {// Designer assistant
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
