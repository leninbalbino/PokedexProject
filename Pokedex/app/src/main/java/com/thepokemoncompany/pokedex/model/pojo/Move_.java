package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Move_ implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Parcelable.Creator<Move_> CREATOR = new Creator<Move_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Move_ createFromParcel(Parcel in) {
            return new Move_(in);
        }

        public Move_[] newArray(int size) {
            return (new Move_[size]);
        }

    }
    ;
    private final static long serialVersionUID = 826335699607298094L;

    protected Move_(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Move_() {
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}
