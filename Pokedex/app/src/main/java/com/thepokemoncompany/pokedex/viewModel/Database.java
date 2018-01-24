package com.thepokemoncompany.pokedex.viewModel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.thepokemoncompany.pokedex.model.Constants;

/**
 * Created by giori on 18/01/2018.
 */

public class Database extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "pokedex.db";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTablePokemon(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TablePokemon.TABLE_NAME);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void deleteTable(SQLiteDatabase db, String table){
        db.execSQL("DROP TABLE IF EXISTS " + table);
        if(table.equals(Constants.TablePokemon.TABLE_NAME)){
            createTablePokemon(db);
        }
    }

    private void createTablePokemon(SQLiteDatabase db){
        String sql = "CREATE TABLE " + Constants.TablePokemon.TABLE_NAME +"("
                + Constants.TablePokemon._ID + " integer primary key autoincrement,"
                + Constants.TablePokemon.COLUMN_NUMBER + " integer,"
                + Constants.TablePokemon.COLUMN_NAME + " text,"
                + Constants.TablePokemon.COLUMN_IMAGE + " text,"
                + Constants.TablePokemon.COLUMN_HEIGHT + " real,"
                + Constants.TablePokemon.COLUMN_WEIGHT + " real,"
                + Constants.TablePokemon.COLUMN_ABILITIES + " text,"
                + Constants.TablePokemon.COLUMN_HP + " integer,"
                + Constants.TablePokemon.COLUMN_ATTACK + " integer,"
                + Constants.TablePokemon.COLUMN_DEFENSE + " integer,"
                + Constants.TablePokemon.COLUMN_SP_ATTACK + " integer,"
                + Constants.TablePokemon.COLUMN_SP_DEFENSE + " integer,"
                + Constants.TablePokemon.COLUMN_SPEED + " integer,"
                + Constants.TablePokemon.COLUMN_TOTAL + " integer,"
                + Constants.TablePokemon.COLUMN_BASE_EXP + " integer,"
                + Constants.TablePokemon.COLUMN_CAPTURE_RATE + " integer,"
                + Constants.TablePokemon.COLUMN_GROWTH_RATE + " text,"
                + Constants.TablePokemon.COLUMN_GENDER_FEMALE + " real,"
                + Constants.TablePokemon.COLUMN_MOVEMENTS + " text,"
                + Constants.TablePokemon.COLUMN_IS_CATCH + " boolean,"
                + Constants.TablePokemon.COLUMN_IS_MY_TEAM + " boolean"
                +")";
        db.execSQL(sql);
    }

}
