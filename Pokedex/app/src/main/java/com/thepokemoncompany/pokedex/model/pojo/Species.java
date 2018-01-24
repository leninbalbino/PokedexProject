
package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Species implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("gender_rate")
    @Expose
    private Integer genderRate;
    @SerializedName("capture_rate")
    @Expose
    private Integer captureRate;
    @SerializedName("base_happiness")
    @Expose
    private Integer baseHappiness;
    @SerializedName("is_baby")
    @Expose
    private Boolean isBaby;
    @SerializedName("hatch_counter")
    @Expose
    private Integer hatchCounter;
    @SerializedName("has_gender_differences")
    @Expose
    private Boolean hasGenderDifferences;
    @SerializedName("forms_switchable")
    @Expose
    private Boolean formsSwitchable;
    @SerializedName("growth_rate")
    @Expose
    private GrowthRate growthRate;
    @SerializedName("pokedex_numbers")
    @Expose
    private List<PokedexNumber> pokedexNumbers = null;
    @SerializedName("egg_groups")
    @Expose
    private List<EggGroup> eggGroups = null;
    @SerializedName("color")
    @Expose
    private Color color;
    @SerializedName("shape")
    @Expose
    private Shape shape;
    @SerializedName("evolves_from_species")
    @Expose
    private EvolvesFromSpecies evolvesFromSpecies;
    @SerializedName("evolution_chain")
    @Expose
    private EvolutionChain evolutionChain;
    @SerializedName("habitat")
    @Expose
    private Object habitat;
    @SerializedName("generation")
    @Expose
    private Generation generation;
    @SerializedName("names")
    @Expose
    private List<Name> names = null;
    @SerializedName("flavor_text_entries")
    @Expose
    private List<FlavorTextEntry> flavorTextEntries = null;
    @SerializedName("form_descriptions")
    @Expose
    private List<FormDescription> formDescriptions = null;
    @SerializedName("genera")
    @Expose
    private List<Genera> genera = null;
    @SerializedName("varieties")
    @Expose
    private List<Variety> varieties = null;
    public final static Parcelable.Creator<Species> CREATOR = new Creator<Species>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Species createFromParcel(Parcel in) {
            return new Species(in);
        }

        public Species[] newArray(int size) {
            return (new Species[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8002143407168354862L;

    protected Species(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.order = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.genderRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.captureRate = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.baseHappiness = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isBaby = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.hatchCounter = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.hasGenderDifferences = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.formsSwitchable = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.growthRate = ((GrowthRate) in.readValue((GrowthRate.class.getClassLoader())));
        in.readList(this.pokedexNumbers, (PokedexNumber.class.getClassLoader()));
        in.readList(this.eggGroups, (EggGroup.class.getClassLoader()));
        this.color = ((Color) in.readValue((Color.class.getClassLoader())));
        this.shape = ((Shape) in.readValue((Shape.class.getClassLoader())));
        this.evolvesFromSpecies = ((EvolvesFromSpecies) in.readValue((EvolvesFromSpecies.class.getClassLoader())));
        this.evolutionChain = ((EvolutionChain) in.readValue((EvolutionChain.class.getClassLoader())));
        this.habitat = ((Object) in.readValue((Object.class.getClassLoader())));
        this.generation = ((Generation) in.readValue((Generation.class.getClassLoader())));
        in.readList(this.names, (Name.class.getClassLoader()));
        in.readList(this.flavorTextEntries, (FlavorTextEntry.class.getClassLoader()));
        in.readList(this.formDescriptions, (FormDescription.class.getClassLoader()));
        in.readList(this.genera, (Genera.class.getClassLoader()));
        in.readList(this.varieties, (Variety.class.getClassLoader()));
    }

    public Species() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getGenderRate() {
        return genderRate;
    }

    public void setGenderRate(Integer genderRate) {
        this.genderRate = genderRate;
    }

    public Integer getCaptureRate() {
        return captureRate;
    }

    public void setCaptureRate(Integer captureRate) {
        this.captureRate = captureRate;
    }

    public Integer getBaseHappiness() {
        return baseHappiness;
    }

    public void setBaseHappiness(Integer baseHappiness) {
        this.baseHappiness = baseHappiness;
    }

    public Boolean getIsBaby() {
        return isBaby;
    }

    public void setIsBaby(Boolean isBaby) {
        this.isBaby = isBaby;
    }

    public Integer getHatchCounter() {
        return hatchCounter;
    }

    public void setHatchCounter(Integer hatchCounter) {
        this.hatchCounter = hatchCounter;
    }

    public Boolean getHasGenderDifferences() {
        return hasGenderDifferences;
    }

    public void setHasGenderDifferences(Boolean hasGenderDifferences) {
        this.hasGenderDifferences = hasGenderDifferences;
    }

    public Boolean getFormsSwitchable() {
        return formsSwitchable;
    }

    public void setFormsSwitchable(Boolean formsSwitchable) {
        this.formsSwitchable = formsSwitchable;
    }

    public GrowthRate getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(GrowthRate growthRate) {
        this.growthRate = growthRate;
    }

    public List<PokedexNumber> getPokedexNumbers() {
        return pokedexNumbers;
    }

    public void setPokedexNumbers(List<PokedexNumber> pokedexNumbers) {
        this.pokedexNumbers = pokedexNumbers;
    }

    public List<EggGroup> getEggGroups() {
        return eggGroups;
    }

    public void setEggGroups(List<EggGroup> eggGroups) {
        this.eggGroups = eggGroups;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public EvolvesFromSpecies getEvolvesFromSpecies() {
        return evolvesFromSpecies;
    }

    public void setEvolvesFromSpecies(EvolvesFromSpecies evolvesFromSpecies) {
        this.evolvesFromSpecies = evolvesFromSpecies;
    }

    public EvolutionChain getEvolutionChain() {
        return evolutionChain;
    }

    public void setEvolutionChain(EvolutionChain evolutionChain) {
        this.evolutionChain = evolutionChain;
    }

    public Object getHabitat() {
        return habitat;
    }

    public void setHabitat(Object habitat) {
        this.habitat = habitat;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public List<FlavorTextEntry> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public void setFlavorTextEntries(List<FlavorTextEntry> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    public List<FormDescription> getFormDescriptions() {
        return formDescriptions;
    }

    public void setFormDescriptions(List<FormDescription> formDescriptions) {
        this.formDescriptions = formDescriptions;
    }

    public List<Genera> getGenera() {
        return genera;
    }

    public void setGenera(List<Genera> genera) {
        this.genera = genera;
    }

    public List<Variety> getVarieties() {
        return varieties;
    }

    public void setVarieties(List<Variety> varieties) {
        this.varieties = varieties;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(url);
        dest.writeValue(name);
        dest.writeValue(order);
        dest.writeValue(genderRate);
        dest.writeValue(captureRate);
        dest.writeValue(baseHappiness);
        dest.writeValue(isBaby);
        dest.writeValue(hatchCounter);
        dest.writeValue(hasGenderDifferences);
        dest.writeValue(formsSwitchable);
        dest.writeValue(growthRate);
        dest.writeList(pokedexNumbers);
        dest.writeList(eggGroups);
        dest.writeValue(color);
        dest.writeValue(shape);
        dest.writeValue(evolvesFromSpecies);
        dest.writeValue(evolutionChain);
        dest.writeValue(habitat);
        dest.writeValue(generation);
        dest.writeList(names);
        dest.writeList(flavorTextEntries);
        dest.writeList(formDescriptions);
        dest.writeList(genera);
        dest.writeList(varieties);
    }

    public int describeContents() {
        return  0;
    }

}
