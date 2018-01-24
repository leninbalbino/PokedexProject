package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sprites implements Serializable, Parcelable
{

    @SerializedName("back_female")
    @Expose
    private Object backFemale;
    @SerializedName("back_shiny_female")
    @Expose
    private Object backShinyFemale;
    @SerializedName("back_default")
    @Expose
    private String backDefault;
    @SerializedName("front_female")
    @Expose
    private Object frontFemale;
    @SerializedName("front_shiny_female")
    @Expose
    private Object frontShinyFemale;
    @SerializedName("back_shiny")
    @Expose
    private String backShiny;
    @SerializedName("front_default")
    @Expose
    private String frontDefault;
    @SerializedName("front_shiny")
    @Expose
    private String frontShiny;
    public final static Parcelable.Creator<Sprites> CREATOR = new Creator<Sprites>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Sprites createFromParcel(Parcel in) {
            return new Sprites(in);
        }

        public Sprites[] newArray(int size) {
            return (new Sprites[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8133468373937078167L;

    protected Sprites(Parcel in) {
        this.backFemale = ((Object) in.readValue((Object.class.getClassLoader())));
        this.backShinyFemale = ((Object) in.readValue((Object.class.getClassLoader())));
        this.backDefault = ((String) in.readValue((String.class.getClassLoader())));
        this.frontFemale = ((Object) in.readValue((Object.class.getClassLoader())));
        this.frontShinyFemale = ((Object) in.readValue((Object.class.getClassLoader())));
        this.backShiny = ((String) in.readValue((String.class.getClassLoader())));
        this.frontDefault = ((String) in.readValue((String.class.getClassLoader())));
        this.frontShiny = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Sprites() {
    }

    public Object getBackFemale() {
        return backFemale;
    }

    public void setBackFemale(Object backFemale) {
        this.backFemale = backFemale;
    }

    public Object getBackShinyFemale() {
        return backShinyFemale;
    }

    public void setBackShinyFemale(Object backShinyFemale) {
        this.backShinyFemale = backShinyFemale;
    }

    public String getBackDefault() {
        return backDefault;
    }

    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    public Object getFrontFemale() {
        return frontFemale;
    }

    public void setFrontFemale(Object frontFemale) {
        this.frontFemale = frontFemale;
    }

    public Object getFrontShinyFemale() {
        return frontShinyFemale;
    }

    public void setFrontShinyFemale(Object frontShinyFemale) {
        this.frontShinyFemale = frontShinyFemale;
    }

    public String getBackShiny() {
        return backShiny;
    }

    public void setBackShiny(String backShiny) {
        this.backShiny = backShiny;
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public String getFrontShiny() {
        return frontShiny;
    }

    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(backFemale);
        dest.writeValue(backShinyFemale);
        dest.writeValue(backDefault);
        dest.writeValue(frontFemale);
        dest.writeValue(frontShinyFemale);
        dest.writeValue(backShiny);
        dest.writeValue(frontDefault);
        dest.writeValue(frontShiny);
    }

    public int describeContents() {
        return  0;
    }

}
