package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GameIndex implements Serializable, Parcelable
{

    @SerializedName("version")
    @Expose
    private Version version;
    @SerializedName("game_index")
    @Expose
    private Integer gameIndex;
    public final static Parcelable.Creator<GameIndex> CREATOR = new Creator<GameIndex>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GameIndex createFromParcel(Parcel in) {
            return new GameIndex(in);
        }

        public GameIndex[] newArray(int size) {
            return (new GameIndex[size]);
        }

    }
    ;
    private final static long serialVersionUID = 3132656807053505795L;

    protected GameIndex(Parcel in) {
        this.version = ((Version) in.readValue((Version.class.getClassLoader())));
        this.gameIndex = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public GameIndex() {
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Integer getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(Integer gameIndex) {
        this.gameIndex = gameIndex;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(version);
        dest.writeValue(gameIndex);
    }

    public int describeContents() {
        return  0;
    }

}
