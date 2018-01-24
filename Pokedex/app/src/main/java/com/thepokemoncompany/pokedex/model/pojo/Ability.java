
package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ability implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slot")
    @Expose
    private Integer slot;
    @SerializedName("is_hidden")
    @Expose
    private Boolean isHidden;
    @SerializedName("ability")
    @Expose
    private Ability ability;
    public final static Parcelable.Creator<Ability> CREATOR = new Creator<Ability>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Ability createFromParcel(Parcel in) {
            return new Ability(in);
        }

        public Ability[] newArray(int size) {
            return (new Ability[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6458497198184147251L;

    protected Ability(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.slot = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isHidden = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.ability = ((Ability) in.readValue((Ability.class.getClassLoader())));
    }

    public Ability() {
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

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(name);
        dest.writeValue(slot);
        dest.writeValue(isHidden);
        dest.writeValue(ability);
    }

    public int describeContents() {
        return  0;
    }

}
