
package com.example.david.voight_kampfftestresult.model.remote.put;

import java.util.ArrayList;
import java.util.List;

import com.example.david.voight_kampfftestresult.model.local.LocalPatient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdatePatient {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private List<Name> name = null;

    @SerializedName("birthDate")
    @Expose
    private String birthDate;

    @SerializedName("gender")
    @Expose
    private String gender;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Name> getName() {
        return name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }


    public void convertLocalToRemote(LocalPatient localPatient){
        Name name = new Name();
        name.setFamily(localPatient.getFamilyName());
        name.setGiven(localPatient.getGiveName());
        List<Name> nameList = new ArrayList<>();
        nameList.add(name);
        this.setName(nameList);
        this.birthDate = localPatient.getDateOfBirth();
        this.gender = localPatient.getGender();
        this.id = localPatient.getId();

    }
}
