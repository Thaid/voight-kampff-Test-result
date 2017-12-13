
package com.example.david.voight_kampfftestresult.model.remote.put;

import java.util.ArrayList;
import java.util.List;

import com.example.david.voight_kampfftestresult.model.local.LocalPatient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdatePatient {

    @SerializedName("resourceType")
    @Expose
    private String resourceType;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("text")
    @Expose
    private Text text;
    @SerializedName("active")
    @Expose
    private Boolean active;
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

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
