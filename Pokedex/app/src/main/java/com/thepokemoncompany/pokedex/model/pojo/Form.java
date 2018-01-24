
package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Form implements Serializable, Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Parcelable.Creator<Form> CREATOR = new Creator<Form>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Form createFromParcel(Parcel in) {
            return new Form(in);
        }

        public Form[] newArray(int size) {
            return (new Form[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8415671775693090030L;

    protected Form(Parcel in) {
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Form() {
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
