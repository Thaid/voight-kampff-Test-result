package com.example.david.voight_kampfftestresult.model.local;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by David on 2017-12-12.
 */

public class LocalPatient implements Parcelable  {
    private List<String> giveName;
    private String familyName;
    private String gender;
    private String dateOfBirth;
    private String id;


    public LocalPatient(List<String> giveName, String familyName, String gender, String dateOfBirth) {
        this.giveName = giveName;
        this.familyName = familyName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public List<String> getGiveName() {
        return giveName;
    }

    public void setGiveName(List<String> giveName) {
        this.giveName = giveName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalPatient() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.giveName);
        dest.writeString(this.familyName);
        dest.writeString(this.gender);
        dest.writeString(this.dateOfBirth);
        dest.writeString(this.id);
    }

    protected LocalPatient(Parcel in) {
        this.giveName = in.createStringArrayList();
        this.familyName = in.readString();
        this.gender = in.readString();
        this.dateOfBirth = in.readString();
        this.id = in.readString();
    }

    public static final Creator<LocalPatient> CREATOR = new Creator<LocalPatient>() {
        @Override
        public LocalPatient createFromParcel(Parcel source) {
            return new LocalPatient(source);
        }

        @Override
        public LocalPatient[] newArray(int size) {
            return new LocalPatient[size];
        }
    };
}
