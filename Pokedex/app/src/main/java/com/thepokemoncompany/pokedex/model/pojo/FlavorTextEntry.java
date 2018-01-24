
package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlavorTextEntry implements Serializable, Parcelable
{

    @SerializedName("flavor_text")
    @Expose
    private String flavorText;
    @SerializedName("language")
    @Expose
    private Language language;
    @SerializedName("version")
    @Expose
    private Version version;
    public final static Parcelable.Creator<FlavorTextEntry> CREATOR = new Creator<FlavorTextEntry>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FlavorTextEntry createFromParcel(Parcel in) {
            return new FlavorTextEntry(in);
        }

        public FlavorTextEntry[] newArray(int size) {
            return (new FlavorTextEntry[size]);
        }

    }
    ;
    private final static long serialVersionUID = 5998820286109955086L;

    protected FlavorTextEntry(Parcel in) {
        this.flavorText = ((String) in.readValue((String.class.getClassLoader())));
        this.language = ((Language) in.readValue((Language.class.getClassLoader())));
        this.version = ((Version) in.readValue((Version.class.getClassLoader())));
    }

    public FlavorTextEntry() {
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(flavorText);
        dest.writeValue(language);
        dest.writeValue(version);
    }

    public int describeContents() {
        return  0;
    }

}
