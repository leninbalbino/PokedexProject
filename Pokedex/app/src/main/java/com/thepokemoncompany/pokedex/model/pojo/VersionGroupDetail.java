package com.thepokemoncompany.pokedex.model.pojo;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VersionGroupDetail implements Serializable, Parcelable
{

    @SerializedName("move_learn_method")
    @Expose
    private MoveLearnMethod moveLearnMethod;
    @SerializedName("level_learned_at")
    @Expose
    private Integer levelLearnedAt;
    @SerializedName("version_group")
    @Expose
    private VersionGroup versionGroup;
    public final static Parcelable.Creator<VersionGroupDetail> CREATOR = new Creator<VersionGroupDetail>() {


        @SuppressWarnings({
            "unchecked"
        })
        public VersionGroupDetail createFromParcel(Parcel in) {
            return new VersionGroupDetail(in);
        }

        public VersionGroupDetail[] newArray(int size) {
            return (new VersionGroupDetail[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6222868940529322202L;

    protected VersionGroupDetail(Parcel in) {
        this.moveLearnMethod = ((MoveLearnMethod) in.readValue((MoveLearnMethod.class.getClassLoader())));
        this.levelLearnedAt = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.versionGroup = ((VersionGroup) in.readValue((VersionGroup.class.getClassLoader())));
    }

    public VersionGroupDetail() {
    }

    public MoveLearnMethod getMoveLearnMethod() {
        return moveLearnMethod;
    }

    public void setMoveLearnMethod(MoveLearnMethod moveLearnMethod) {
        this.moveLearnMethod = moveLearnMethod;
    }

    public Integer getLevelLearnedAt() {
        return levelLearnedAt;
    }

    public void setLevelLearnedAt(Integer levelLearnedAt) {
        this.levelLearnedAt = levelLearnedAt;
    }

    public VersionGroup getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(moveLearnMethod);
        dest.writeValue(levelLearnedAt);
        dest.writeValue(versionGroup);
    }

    public int describeContents() {
        return  0;
    }

}
