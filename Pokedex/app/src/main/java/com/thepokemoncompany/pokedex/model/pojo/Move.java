package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Move implements Serializable, Parcelable
{

    @SerializedName("version_group_details")
    @Expose
    private List<VersionGroupDetail> versionGroupDetails = null;
    @SerializedName("move")
    @Expose
    private Move_ move;
    public final static Parcelable.Creator<Move> CREATOR = new Creator<Move>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Move createFromParcel(Parcel in) {
            return new Move(in);
        }

        public Move[] newArray(int size) {
            return (new Move[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8400175993809642831L;

    protected Move(Parcel in) {
        in.readList(this.versionGroupDetails, (VersionGroupDetail.class.getClassLoader()));
        this.move = ((Move_) in.readValue((Move_.class.getClassLoader())));
    }

    public Move() {
    }

    public List<VersionGroupDetail> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    public void setVersionGroupDetails(List<VersionGroupDetail> versionGroupDetails) {
        this.versionGroupDetails = versionGroupDetails;
    }

    public Move_ getMove() {
        return move;
    }

    public void setMove(Move_ move) {
        this.move = move;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(versionGroupDetails);
        dest.writeValue(move);
    }

    public int describeContents() {
        return  0;
    }

}
