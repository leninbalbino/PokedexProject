
package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FormDescription implements Serializable, Parcelable
{

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("language")
    @Expose
    private Language language;
    public final static Parcelable.Creator<FormDescription> CREATOR = new Creator<FormDescription>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FormDescription createFromParcel(Parcel in) {
            return new FormDescription(in);
        }

        public FormDescription[] newArray(int size) {
            return (new FormDescription[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6384955734139828632L;

    protected FormDescription(Parcel in) {
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.language = ((Language) in.readValue((Language.class.getClassLoader())));
    }

    public FormDescription() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(description);
        dest.writeValue(language);
    }

    public int describeContents() {
        return  0;
    }

}
