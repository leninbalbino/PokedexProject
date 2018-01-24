package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokedex implements Serializable, Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("region")
    @Expose
    private Object region;
    @SerializedName("version_groups")
    @Expose
    private List<Object> versionGroups = null;
    @SerializedName("is_main_series")
    @Expose
    private Boolean isMainSeries;
    @SerializedName("descriptions")
    @Expose
    private List<Description> descriptions = null;
    @SerializedName("pokemon_entries")
    @Expose
    private List<PokemonEntry> pokemonEntries = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("names")
    @Expose
    private List<Name> names = null;
    public final static Parcelable.Creator<Pokedex> CREATOR = new Creator<Pokedex>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Pokedex createFromParcel(Parcel in) {
            return new Pokedex(in);
        }

        public Pokedex[] newArray(int size) {
            return (new Pokedex[size]);
        }

    }
    ;
    private final static long serialVersionUID = -3334902990390380113L;

    protected Pokedex(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.region = ((Object) in.readValue((Object.class.getClassLoader())));
        in.readList(this.versionGroups, (java.lang.Object.class.getClassLoader()));
        this.isMainSeries = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.descriptions, (Description.class.getClassLoader()));
        in.readList(this.pokemonEntries, (PokemonEntry.class.getClassLoader()));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.names, (Name.class.getClassLoader()));
    }

    public Pokedex() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getRegion() {
        return region;
    }

    public void setRegion(Object region) {
        this.region = region;
    }

    public List<Object> getVersionGroups() {
        return versionGroups;
    }

    public void setVersionGroups(List<Object> versionGroups) {
        this.versionGroups = versionGroups;
    }

    public Boolean getIsMainSeries() {
        return isMainSeries;
    }

    public void setIsMainSeries(Boolean isMainSeries) {
        this.isMainSeries = isMainSeries;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public List<PokemonEntry> getPokemonEntries() {
        return pokemonEntries;
    }

    public void setPokemonEntries(List<PokemonEntry> pokemonEntries) {
        this.pokemonEntries = pokemonEntries;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(region);
        dest.writeList(versionGroups);
        dest.writeValue(isMainSeries);
        dest.writeList(descriptions);
        dest.writeList(pokemonEntries);
        dest.writeValue(id);
        dest.writeValue(url);
        dest.writeList(names);
    }

    public int describeContents() {
        return  0;
    }

}
