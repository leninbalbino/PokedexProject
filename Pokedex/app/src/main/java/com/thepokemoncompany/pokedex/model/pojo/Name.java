
package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name implements Serializable, Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("language")
    @Expose
    private Language language;
    public final static Parcelable.Creator<Name> CREATOR = new Creator<Name>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Name createFromParcel(Parcel in) {
            return new Name(in);
        }

        public Name[] newArray(int size) {
            return (new Name[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4294369359483138776L;

    protected Name(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.language = ((Language) in.readValue((Language.class.getClassLoader())));
    }

    public Name() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(language);
    }

    public int describeContents() {
        return  0;
    }

}
