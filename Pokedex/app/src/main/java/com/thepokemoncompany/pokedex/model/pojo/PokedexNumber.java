
package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PokedexNumber implements Serializable, Parcelable
{

    @SerializedName("entry_number")
    @Expose
    private Integer entryNumber;
    @SerializedName("pokedex")
    @Expose
    private Pokedex pokedex;
    public final static Parcelable.Creator<PokedexNumber> CREATOR = new Creator<PokedexNumber>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PokedexNumber createFromParcel(Parcel in) {
            return new PokedexNumber(in);
        }

        public PokedexNumber[] newArray(int size) {
            return (new PokedexNumber[size]);
        }

    }
    ;
    private final static long serialVersionUID = 1089298542690018125L;

    protected PokedexNumber(Parcel in) {
        this.entryNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.pokedex = ((Pokedex) in.readValue((Pokedex.class.getClassLoader())));
    }

    public PokedexNumber() {
    }

    public Integer getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(Integer entryNumber) {
        this.entryNumber = entryNumber;
    }

    public Pokedex getPokedex() {
        return pokedex;
    }

    public void setPokedex(Pokedex pokedex) {
        this.pokedex = pokedex;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(entryNumber);
        dest.writeValue(pokedex);
    }

    public int describeContents() {
        return  0;
    }

}
