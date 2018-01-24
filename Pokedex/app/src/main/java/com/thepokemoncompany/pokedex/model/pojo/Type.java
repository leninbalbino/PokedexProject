package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Type implements Serializable, Parcelable
{

    @SerializedName("slot")
    @Expose
    private Integer slot;
    @SerializedName("type")
    @Expose
    private Type_ type;
    public final static Parcelable.Creator<Type> CREATOR = new Creator<Type>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Type createFromParcel(Parcel in) {
            return new Type(in);
        }

        public Type[] newArray(int size) {
            return (new Type[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8774393137917177720L;

    protected Type(Parcel in) {
        this.slot = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.type = ((Type_) in.readValue((Type_.class.getClassLoader())));
    }

    public Type() {
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Type_ getType() {
        return type;
    }

    public void setType(Type_ type) {
        this.type = type;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(slot);
        dest.writeValue(type);
    }

    public int describeContents() {
        return  0;
    }

}
