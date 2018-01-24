
package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EvolvesFromSpecies implements Serializable, Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    public final static Parcelable.Creator<EvolvesFromSpecies> CREATOR = new Creator<EvolvesFromSpecies>() {


        @SuppressWarnings({
            "unchecked"
        })
        public EvolvesFromSpecies createFromParcel(Parcel in) {
            return new EvolvesFromSpecies(in);
        }

        public EvolvesFromSpecies[] newArray(int size) {
            return (new EvolvesFromSpecies[size]);
        }

    }
    ;
    private final static long serialVersionUID = -3171938316197373982L;

    protected EvolvesFromSpecies(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
    }

    public EvolvesFromSpecies() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(url);
    }

    public int describeContents() {
        return  0;
    }

}
