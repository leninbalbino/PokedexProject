
package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variety implements Serializable, Parcelable
{

    @SerializedName("is_default")
    @Expose
    private Boolean isDefault;
    @SerializedName("pokemon")
    @Expose
    private Pokemon pokemon;
    public final static Parcelable.Creator<Variety> CREATOR = new Creator<Variety>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Variety createFromParcel(Parcel in) {
            return new Variety(in);
        }

        public Variety[] newArray(int size) {
            return (new Variety[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4624200660490933275L;

    protected Variety(Parcel in) {
        this.isDefault = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.pokemon = ((Pokemon) in.readValue((Pokemon.class.getClassLoader())));
    }

    public Variety() {
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(isDefault);
        dest.writeValue(pokemon);
    }

    public int describeContents() {
        return  0;
    }

}
