package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PokemonEntry implements Serializable, Parcelable
{

    @SerializedName("entry_number")
    @Expose
    private Integer entryNumber;
    @SerializedName("pokemon_species")
    @Expose
    private PokemonSpecies pokemonSpecies;
    public final static Parcelable.Creator<PokemonEntry> CREATOR = new Creator<PokemonEntry>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PokemonEntry createFromParcel(Parcel in) {
            return new PokemonEntry(in);
        }

        public PokemonEntry[] newArray(int size) {
            return (new PokemonEntry[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5750990264354173670L;

    protected PokemonEntry(Parcel in) {
        this.entryNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pokemonSpecies = ((PokemonSpecies) in.readValue((PokemonSpecies.class.getClassLoader())));
    }

    public PokemonEntry() {
    }

    public Integer getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(Integer entryNumber) {
        this.entryNumber = entryNumber;
    }

    public PokemonSpecies getPokemonSpecies() {
        return pokemonSpecies;
    }

    public void setPokemonSpecies(PokemonSpecies pokemonSpecies) {
        this.pokemonSpecies = pokemonSpecies;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(entryNumber);
        dest.writeValue(pokemonSpecies);
    }

    public int describeContents() {
        return  0;
    }

}
