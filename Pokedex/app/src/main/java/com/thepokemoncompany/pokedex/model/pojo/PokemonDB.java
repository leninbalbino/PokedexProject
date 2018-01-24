package com.thepokemoncompany.pokedex.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by giori on 18/01/2018.
 */

public class PokemonDB implements Parcelable {
    
    private int id;
    private int number;
    private String name;
    private String image;
    private float height;
    private float weight;
    private String abilities;

    private int hp;
    private int attack;
    private int defense;
    private int sp_attack;
    private int sp_defense;
    private int speed;
    private int total;

    private int base_xp;
    private int capture_rate;
    private String growth_rate;

    private float gender_female;
    private String moviments;

    private boolean isCatch;
    private boolean isMyTeam;

    public PokemonDB(){
    }

    public PokemonDB(Pokemon pokemon){

        this.number = pokemon.getId();

        this.name = firstCharUpper(pokemon.getName());
        this.image = pokemon.getSprites().getFrontDefault();
        this.height = pokemon.getHeight() / 10;
        this.weight = pokemon.getWeight() / 10;

        this.abilities = "";
        for(Ability ability : pokemon.getAbilities())
            this.abilities += firstCharUpper(ability.getAbility().getName()) + ", ";

        if(this.abilities.length() > 3)
            this.abilities = this.abilities.substring( 0, abilities.length() - 2);

        this.hp = pokemon.getStats().get(5).getBaseStat();
        this.attack = pokemon.getStats().get(4).getBaseStat();
        this.defense = pokemon.getStats().get(3).getBaseStat();
        this.sp_attack = pokemon.getStats().get(2).getBaseStat();
        this.sp_defense = pokemon.getStats().get(1).getBaseStat();
        this.speed = pokemon.getStats().get(0).getBaseStat();
        this.total = (this.hp + this.attack + this.defense + this.sp_attack + this.sp_defense + this.speed);

        this.base_xp = pokemon.getBaseExperience();

        this.moviments = "";
        for(Move move : pokemon.getMoves())
            this.moviments += firstCharUpper(move.getMove().getName()) + "\n";

        if(this.moviments.length() > 2)
            this.moviments = this.moviments.substring(0, this.moviments.length() - 1);

        this.isCatch = false;
        this.isMyTeam = false;
    }

    private String firstCharUpper(String str){

        String stringFinal = str.substring(0,1).toUpperCase();
        stringFinal += str.substring(1,str.length());

        return stringFinal;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSp_attack() {
        return sp_attack;
    }

    public void setSp_attack(int sp_attack) {
        this.sp_attack = sp_attack;
    }

    public int getSp_defense() {
        return sp_defense;
    }

    public void setSp_defense(int sp_defense) {
        this.sp_defense = sp_defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBase_xp() {
        return base_xp;
    }

    public void setBase_xp(int base_xp) {
        this.base_xp = base_xp;
    }

    public int getCapture_rate() {
        return capture_rate;
    }

    public void setCapture_rate(int capture_rate) {
        this.capture_rate = capture_rate;
    }

    public String getGrowth_rate() {
        return growth_rate;
    }

    public void setGrowth_rate(String growth_rate) {
        this.growth_rate = growth_rate;
    }

    public float getGender_female() {
        return gender_female;
    }

    public void setGender_female(float gender_female) {
        this.gender_female = gender_female;
    }

    public String getMoviments() {
        return moviments;
    }

    public void setMoviments(String moviments) {
        this.moviments = moviments;
    }

    public boolean isCatch() {
        return isCatch;
    }

    public void setCatch(boolean aCatch) {
        isCatch = aCatch;
    }

    public boolean isMyTeam() {
        return isMyTeam;
    }

    public void setMyTeam(boolean myTeam) {
        isMyTeam = myTeam;
    }

    protected PokemonDB(Parcel in) {
        id = in.readInt();
        number = in.readInt();
        name = in.readString();
        image = in.readString();
        height = in.readFloat();
        weight = in.readFloat();
        abilities = in.readString();
        hp = in.readInt();
        attack = in.readInt();
        defense = in.readInt();
        sp_attack = in.readInt();
        sp_defense = in.readInt();
        speed = in.readInt();
        total = in.readInt();
        base_xp = in.readInt();
        capture_rate = in.readInt();
        growth_rate = in.readString();
        gender_female = in.readFloat();
        moviments = in.readString();
        isCatch = Boolean.getBoolean(in.readString());
        isMyTeam = Boolean.getBoolean(in.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(id);
        dest.writeInt(number);
        dest.writeString(name);
        dest.writeString(image);
        dest.writeFloat(height);
        dest.writeFloat(weight);
        dest.writeString(abilities);
        dest.writeInt(hp);
        dest.writeInt(attack);
        dest.writeInt(defense);
        dest.writeInt(sp_attack);
        dest.writeInt(sp_defense);
        dest.writeInt(speed);
        dest.writeInt(total);
        dest.writeInt(base_xp);
        dest.writeInt(capture_rate);
        dest.writeString(growth_rate);
        dest.writeFloat(gender_female);
        dest.writeString(moviments);
        dest.writeString(String.valueOf(isCatch));
        dest.writeString(String.valueOf(isMyTeam));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PokemonDB> CREATOR = new Parcelable.Creator<PokemonDB>() {
        @Override
        public PokemonDB createFromParcel(Parcel in) {
            return new PokemonDB(in);
        }

        @Override
        public PokemonDB[] newArray(int size) {
            return new PokemonDB[size];
        }
    };
}
