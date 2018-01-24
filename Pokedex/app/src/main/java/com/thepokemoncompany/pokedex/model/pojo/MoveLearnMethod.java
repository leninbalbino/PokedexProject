package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoveLearnMethod implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Parcelable.Creator<MoveLearnMethod> CREATOR = new Creator<MoveLearnMethod>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MoveLearnMethod createFromParcel(Parcel in) {
            return new MoveLearnMethod(in);
        }

        public MoveLearnMethod[] newArray(int size) {
            return (new MoveLearnMethod[size]);
        }

    }
    ;
    private final static long serialVersionUID = -2761867401126490370L;

    protected MoveLearnMethod(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public MoveLearnMethod() {
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
