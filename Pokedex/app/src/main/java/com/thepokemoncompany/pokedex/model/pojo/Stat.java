package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stat implements Serializable, Parcelable
{

    @SerializedName("stat")
    @Expose
    private Stat_ stat;
    @SerializedName("effort")
    @Expose
    private Integer effort;
    @SerializedName("base_stat")
    @Expose
    private Integer baseStat;
    public final static Parcelable.Creator<Stat> CREATOR = new Creator<Stat>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Stat createFromParcel(Parcel in) {
            return new Stat(in);
        }

        public Stat[] newArray(int size) {
            return (new Stat[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2183900253415614451L;

    protected Stat(Parcel in) {
        this.stat = ((Stat_) in.readValue((Stat_.class.getClassLoader())));
        this.effort = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.baseStat = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Stat() {
    }

    public Stat_ getStat() {
        return stat;
    }

    public void setStat(Stat_ stat) {
        this.stat = stat;
    }

    public Integer getEffort() {
        return effort;
    }

    public void setEffort(Integer effort) {
        this.effort = effort;
    }

    public Integer getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(Integer baseStat) {
        this.baseStat = baseStat;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(stat);
        dest.writeValue(effort);
        dest.writeValue(baseStat);
    }

    public int describeContents() {
        return  0;
    }

}
