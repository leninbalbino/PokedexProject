
package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genera implements Serializable, Parcelable
{

    @SerializedName("genus")
    @Expose
    private String genus;
    @SerializedName("language")
    @Expose
    private Language language;
    public final static Parcelable.Creator<Genera> CREATOR = new Creator<Genera>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Genera createFromParcel(Parcel in) {
            return new Genera(in);
        }

        public Genera[] newArray(int size) {
            return (new Genera[size]);
        }

    }
    ;
    private final static long serialVersionUID = 6449698359096610229L;

    protected Genera(Parcel in) {
        this.genus = ((String) in.readValue((String.class.getClassLoader())));
        this.language = ((Language) in.readValue((Language.class.getClassLoader())));
    }

    public Genera() {
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(genus);
        dest.writeValue(language);
    }

    public int describeContents() {
        return  0;
    }

}
