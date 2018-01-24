
package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EvolutionChain implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    public final static Parcelable.Creator<EvolutionChain> CREATOR = new Creator<EvolutionChain>() {


        @SuppressWarnings({
            "unchecked"
        })
        public EvolutionChain createFromParcel(Parcel in) {
            return new EvolutionChain(in);
        }

        public EvolutionChain[] newArray(int size) {
            return (new EvolutionChain[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5844642053218527944L;

    protected EvolutionChain(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
    }

    public EvolutionChain() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
    }

    public int describeContents() {
        return  0;
    }

}
