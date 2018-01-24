package com.thepokemoncompany.pokedex.viewModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.FontsContract;

import com.thepokemoncompany.pokedex.model.Constants;
import com.thepokemoncompany.pokedex.model.pojo.PokemonDB;
import com.thepokemoncompany.pokedex.model.pojo.Species;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giori on 18/01/2018.
 */

public class DatabaseController {

    private SQLiteDatabase db;
    private Database database;

    private String[] columns = {
            FontsContract.Columns._ID,
            Constants.TablePokemon.COLUMN_NUMBER,
            Constants.TablePokemon.COLUMN_NAME,
            Constants.TablePokemon.COLUMN_IMAGE,
            Constants.TablePokemon.COLUMN_HEIGHT,
            Constants.TablePokemon.COLUMN_WEIGHT,
            Constants.TablePokemon.COLUMN_ABILITIES,
            Constants.TablePokemon.COLUMN_HP,
            Constants.TablePokemon.COLUMN_ATTACK,
            Constants.TablePokemon.COLUMN_DEFENSE,
            Constants.TablePokemon.COLUMN_SP_ATTACK,
            Constants.TablePokemon.COLUMN_SP_DEFENSE,
            Constants.TablePokemon.COLUMN_SPEED,
            Constants.TablePokemon.COLUMN_TOTAL,
            Constants.TablePokemon.COLUMN_BASE_EXP,
            Constants.TablePokemon.COLUMN_CAPTURE_RATE,
            Constants.TablePokemon.COLUMN_GROWTH_RATE,
            Constants.TablePokemon.COLUMN_GENDER_FEMALE,
            Constants.TablePokemon.COLUMN_MOVEMENTS,
            Constants.TablePokemon.COLUMN_IS_CATCH,
            Constants.TablePokemon.COLUMN_IS_MY_TEAM
    };

    public DatabaseController(Context context){
        database = new Database(context);
        db = database.getWritableDatabase();
    }

    public String insertPokemon(PokemonDB pokemonDB){
       ContentValues values;
        long result;

        //db = database.getWritableDatabase();
        values = new ContentValues();
        values.put( Constants.TablePokemon.COLUMN_NAME, pokemonDB.getName());
        values.put( Constants.TablePokemon.COLUMN_NUMBER, pokemonDB.getNumber());
        values.put( Constants.TablePokemon.COLUMN_IMAGE, pokemonDB.getImage());
        values.put( Constants.TablePokemon.COLUMN_HEIGHT, pokemonDB.getHeight());
        values.put( Constants.TablePokemon.COLUMN_WEIGHT, pokemonDB.getWeight());
        values.put( Constants.TablePokemon.COLUMN_ABILITIES, pokemonDB.getAbilities());

        values.put( Constants.TablePokemon.COLUMN_HP, pokemonDB.getHp());
        values.put( Constants.TablePokemon.COLUMN_ATTACK, pokemonDB.getAttack());
        values.put( Constants.TablePokemon.COLUMN_DEFENSE, pokemonDB.getDefense());
        values.put( Constants.TablePokemon.COLUMN_SP_ATTACK, pokemonDB.getSp_attack());
        values.put( Constants.TablePokemon.COLUMN_SP_DEFENSE, pokemonDB.getSp_defense());
        values.put( Constants.TablePokemon.COLUMN_SPEED, pokemonDB.getSpeed());
        values.put( Constants.TablePokemon.COLUMN_TOTAL, pokemonDB.getTotal());

        values.put( Constants.TablePokemon.COLUMN_BASE_EXP, pokemonDB.getBase_xp());
        values.put( Constants.TablePokemon.COLUMN_CAPTURE_RATE, pokemonDB.getCapture_rate());
        values.put( Constants.TablePokemon.COLUMN_GROWTH_RATE, pokemonDB.getGrowth_rate());

        values.put( Constants.TablePokemon.COLUMN_GENDER_FEMALE, pokemonDB.getGender_female());
        values.put( Constants.TablePokemon.COLUMN_MOVEMENTS, pokemonDB.getMoviments());

        values.put( Constants.TablePokemon.COLUMN_IS_CATCH, pokemonDB.isCatch());
        values.put( Constants.TablePokemon.COLUMN_IS_MY_TEAM, pokemonDB.isMyTeam());

        result = db.insert(Constants.TablePokemon.TABLE_NAME, null, values);
       // db.close();

        if (result == -1)
            return "Error inserting";
        else
            return "Success";

    }

    public String updateData(PokemonDB pokemon){

        ContentValues values = new ContentValues();

        values.put( Constants.TablePokemon.COLUMN_NAME, pokemon.getName());
        values.put( Constants.TablePokemon.COLUMN_NUMBER, pokemon.getNumber());
        values.put( Constants.TablePokemon.COLUMN_IMAGE, pokemon.getImage());
        values.put( Constants.TablePokemon.COLUMN_HEIGHT, pokemon.getHeight());
        values.put( Constants.TablePokemon.COLUMN_WEIGHT, pokemon.getWeight());
        values.put( Constants.TablePokemon.COLUMN_ABILITIES, pokemon.getAbilities());

        values.put( Constants.TablePokemon.COLUMN_HP, pokemon.getHp());
        values.put( Constants.TablePokemon.COLUMN_ATTACK, pokemon.getAttack());
        values.put( Constants.TablePokemon.COLUMN_DEFENSE, pokemon.getDefense());
        values.put( Constants.TablePokemon.COLUMN_SP_ATTACK, pokemon.getSp_attack());
        values.put( Constants.TablePokemon.COLUMN_SP_DEFENSE, pokemon.getSp_defense());
        values.put( Constants.TablePokemon.COLUMN_SPEED, pokemon.getSpeed());
        values.put( Constants.TablePokemon.COLUMN_TOTAL, pokemon.getTotal());

        values.put( Constants.TablePokemon.COLUMN_BASE_EXP, pokemon.getBase_xp());
        values.put( Constants.TablePokemon.COLUMN_CAPTURE_RATE, pokemon.getCapture_rate());
        values.put( Constants.TablePokemon.COLUMN_GROWTH_RATE, pokemon.getGrowth_rate());

        values.put( Constants.TablePokemon.COLUMN_GENDER_FEMALE, pokemon.getGender_female());
        values.put( Constants.TablePokemon.COLUMN_MOVEMENTS, pokemon.getMoviments());

        values.put( Constants.TablePokemon.COLUMN_IS_CATCH, pokemon.isCatch());
        values.put( Constants.TablePokemon.COLUMN_IS_MY_TEAM, pokemon.isMyTeam());

        int result = db.update(Constants.TablePokemon.TABLE_NAME,
                values,
                "_id = " + pokemon.getId(),
                null );

        if (result == -1)
            return "Error inserting";
        else
            return "Success";
    }

    public String updateDataSpecie(Species specie){

        ContentValues values = new ContentValues();

        values.put( Constants.TablePokemon.COLUMN_CAPTURE_RATE, specie.getCaptureRate());
        values.put( Constants.TablePokemon.COLUMN_GROWTH_RATE, specie.getGrowthRate().getName());
        values.put( Constants.TablePokemon.COLUMN_GENDER_FEMALE, (specie.getGenderRate()/8.0));//From API = The chance of this Pokémon being female, in eighths

        int result = db.update(Constants.TablePokemon.TABLE_NAME,
                values,
                Constants.TablePokemon.COLUMN_NUMBER + " = " + specie.getId(),
                null);

        if (result == -1)
            return "Error inserting";
        else
            return "Success";
    }

    public  PokemonDB readPokemon(int id){

        Cursor cursor;
        PokemonDB pokemon = new PokemonDB();

        db = database.getReadableDatabase();
        cursor = db.query(Constants.TablePokemon.TABLE_NAME,
                columns,
                null,
                null,
                null,
                Constants.TablePokemon.COLUMN_NUMBER + " = " + id,
                null,
                null);

        if(cursor != null)
            pokemon = cursorToPokemonDB(cursor);

        return pokemon;
    }


    public List<PokemonDB> readListPokemon(){

        Cursor cursor;
        List<PokemonDB> pokemonList = new ArrayList<PokemonDB>();

        db = database.getReadableDatabase();
        cursor = db.query(Constants.TablePokemon.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                Constants.TablePokemon.COLUMN_NUMBER,
                null);

        if(cursor != null){
            while (cursor.moveToNext()){

                PokemonDB pokemon = cursorToPokemonDB(cursor);
                pokemonList.add(pokemon);
            }
        }
        return pokemonList;
    }

    public List<PokemonDB> readListPokemonForMenu(int idLast){

        Cursor cursor;
        List<PokemonDB> pokemonList = new ArrayList<PokemonDB>();

        db = database.getReadableDatabase();
        cursor = db.query(Constants.TablePokemon.TABLE_NAME,
                columns,
                null,
                null,
                Constants.TablePokemon.COLUMN_NUMBER,
                Constants.TablePokemon.COLUMN_NUMBER + " > " + String.valueOf(idLast) ,
                Constants.TablePokemon.COLUMN_NUMBER,
                "20");

        if(cursor != null){
            while (cursor.moveToNext()){

                PokemonDB pokemon = cursorToPokemonDB(cursor);
                pokemonList.add(pokemon);
            }
        }

        return pokemonList;
    }


    public List<PokemonDB> readListMyPokemons() {

        Cursor cursor;
        List<PokemonDB> pokemonList = new ArrayList<PokemonDB>();

        db = database.getReadableDatabase();
        cursor = db.query(Constants.TablePokemon.TABLE_NAME,
                columns,
                null,
                null,
                Constants.TablePokemon.COLUMN_NUMBER,
                Constants.TablePokemon.COLUMN_IS_CATCH + " = 1",
                Constants.TablePokemon.COLUMN_NUMBER,
                null);

        if(cursor != null){
            while (cursor.moveToNext()){

                PokemonDB pokemon = cursorToPokemonDB(cursor);
                pokemonList.add(pokemon);
            }
        }

        return pokemonList;
    }

    public int bestAtack() {

        Cursor cursor;
        int bestAttack = 0;

        db = database.getReadableDatabase();
        cursor = db.query(Constants.TablePokemon.TABLE_NAME,
                columns,
                null,
                null,
                Constants.TablePokemon.COLUMN_NUMBER,
                Constants.TablePokemon.COLUMN_IS_CATCH + " = 1" ,
                Constants.TablePokemon.COLUMN_NUMBER,
                "6");

        if(cursor != null){

            while (cursor.moveToNext())
                bestAttack += cursorToPokemonDB(cursor).getAttack();
        }

        return bestAttack;
    }


    public void deleteTablePokemon(){
        database.deleteTable(db, Constants.TablePokemon.TABLE_NAME);

    }

    private PokemonDB cursorToPokemonDB(Cursor cursor){

        PokemonDB pokemon = new PokemonDB();

        pokemon.setId(
                cursor.getInt(
                        cursor.getColumnIndex(FontsContract.Columns._ID))
        );

        pokemon.setNumber(
                cursor.getInt(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_NUMBER))
        );

        pokemon.setName(
                cursor.getString(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_NAME))
        );

        pokemon.setImage(
                cursor.getString(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_IMAGE))
        );

        pokemon.setHeight(
                cursor.getFloat(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_HEIGHT))
        );

        pokemon.setWeight(
                cursor.getFloat(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_WEIGHT))
        );

        pokemon.setAbilities(
                cursor.getString(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_ABILITIES))
        );

        pokemon.setHp(
                cursor.getInt(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_HP))
        );

        pokemon.setAttack(
                cursor.getInt(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_ATTACK))
        );

        pokemon.setDefense(
                cursor.getInt(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_DEFENSE))
        );

        pokemon.setSp_attack(
                cursor.getInt(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_SP_ATTACK))
        );

        pokemon.setSp_defense(
                cursor.getInt(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_SP_DEFENSE))
        );

        pokemon.setSpeed(
                cursor.getInt(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_SPEED))
        );

        pokemon.setTotal(
                cursor.getInt(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_TOTAL))
        );

        pokemon.setBase_xp(
                cursor.getInt(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_BASE_EXP))
        );

        pokemon.setCapture_rate(
                cursor.getInt(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_CAPTURE_RATE))
        );

        pokemon.setGrowth_rate(
                cursor.getString(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_GROWTH_RATE))
        );

        pokemon.setGender_female(
                cursor.getFloat(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_GENDER_FEMALE))
        );

        pokemon.setMoviments(
                cursor.getString(
                        cursor.getColumnIndex(
                                Constants.TablePokemon.COLUMN_MOVEMENTS))
        );

        int aux; //To help get boolean value
        aux = cursor.getInt(
                cursor.getColumnIndex(
                        Constants.TablePokemon.COLUMN_IS_CATCH));

        if(aux == 1)
            pokemon.setCatch(true);
        else
            pokemon.setCatch(false);

        aux = cursor.getInt(
                cursor.getColumnIndex(
                        Constants.TablePokemon.COLUMN_IS_MY_TEAM));

        if(aux == 1)
            pokemon.setMyTeam(true);
        else
            pokemon.setMyTeam(false);

        return pokemon;
    }
}
