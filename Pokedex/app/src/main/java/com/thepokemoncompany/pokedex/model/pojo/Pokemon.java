
package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon implements Serializable, Parcelable
{

    @SerializedName("forms")
    @Expose
    private List<Form> forms = null;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("abilities")
    @Expose
    private List<Ability> abilities = null;
    @SerializedName("stats")
    @Expose
    private List<Stat> stats = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("moves")
    @Expose
    private List<Move> moves = null;
    @SerializedName("sprites")
    @Expose
    private Sprites sprites;
    @SerializedName("held_items")
    @Expose
    private List<Object> heldItems = null;
    @SerializedName("location_area_encounters")
    @Expose
    private String locationAreaEncounters;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("is_default")
    @Expose
    private Boolean isDefault;
    @SerializedName("species")
    @Expose
    private Species species;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("game_indices")
    @Expose
    private List<GameIndex> gameIndices = null;
    @SerializedName("base_experience")
    @Expose
    private Integer baseExperience;
    @SerializedName("types")
    @Expose
    private List<Type> types = null;
    public final static Parcelable.Creator<Pokemon> CREATOR = new Creator<Pokemon>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        public Pokemon[] newArray(int size) {
            return (new Pokemon[size]);
        }

    }
    ;
    private final static long serialVersionUID = 7460994027463030019L;

    protected Pokemon(Parcel in) {
        in.readList(this.forms, (Form.class.getClassLoader()));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.abilities, (Ability.class.getClassLoader()));
        in.readList(this.stats, (Stat.class.getClassLoader()));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.weight = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.moves, (Move.class.getClassLoader()));
        this.sprites = ((Sprites) in.readValue((Sprites.class.getClassLoader())));
        in.readList(this.heldItems, (java.lang.Object.class.getClassLoader()));
        this.locationAreaEncounters = ((String) in.readValue((String.class.getClassLoader())));
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isDefault = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.species = ((Species) in.readValue((Species.class.getClassLoader())));
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.order = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.gameIndices, (GameIndex.class.getClassLoader()));
        this.baseExperience = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.types, (Type.class.getClassLoader()));
    }

    public Pokemon() {
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<Object> getHeldItems() {
        return heldItems;
    }

    public void setHeldItems(List<Object> heldItems) {
        this.heldItems = heldItems;
    }

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<GameIndex> getGameIndices() {
        return gameIndices;
    }

    public void setGameIndices(List<GameIndex> gameIndices) {
        this.gameIndices = gameIndices;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(forms);
        dest.writeValue(url);
        dest.writeList(abilities);
        dest.writeList(stats);
        dest.writeValue(name);
        dest.writeValue(weight);
        dest.writeList(moves);
        dest.writeValue(sprites);
        dest.writeList(heldItems);
        dest.writeValue(locationAreaEncounters);
        dest.writeValue(height);
        dest.writeValue(isDefault);
        dest.writeValue(species);
        dest.writeValue(id);
        dest.writeValue(order);
        dest.writeList(gameIndices);
        dest.writeValue(baseExperience);
        dest.writeList(types);
    }

    public int describeContents() {
        return  0;
    }

}
