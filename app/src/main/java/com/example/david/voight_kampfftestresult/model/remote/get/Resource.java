
package com.example.david.voight_kampfftestresult.model.remote.get;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resource {

    @SerializedName("resourceType")
    @Expose
    private String resourceType;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("meta")
    @Expose
    private Meta_ meta;
    @SerializedName("text")
    @Expose
    private Text text;
    @SerializedName("identifier")
    @Expose
    private List<Identifier> identifier = null;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("name")
    @Expose
    private List<Name> name = null;
    @SerializedName("telecom")
    @Expose
    private List<Telecom> telecom = null;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("birthDate")
    @Expose
    private String birthDate;
    @SerializedName("address")
    @Expose
    private List<Address> address = null;
    @SerializedName("maritalStatus")
    @Expose
    private MaritalStatus maritalStatus;
    @SerializedName("multipleBirthBoolean")
    @Expose
    private Boolean multipleBirthBoolean;
    @SerializedName("contact")
    @Expose
    private List<Contact> contact = null;
    @SerializedName("generalPractitioner")
    @Expose
    private List<GeneralPractitioner> generalPractitioner = null;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("deceasedBoolean")
    @Expose
    private Boolean deceasedBoolean;
    @SerializedName("extension")
    @Expose
    private List<Extension__> extension = null;
    @SerializedName("communication")
    @Expose
    private List<Communication> communication = null;

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

    public Meta_ getMeta() {
        return meta;
    }

    public void setMeta(Meta_ meta) {
        this.meta = meta;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public List<Identifier> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<Identifier> identifier) {
        this.identifier = identifier;
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

    public List<Telecom> getTelecom() {
        return telecom;
    }

    public void setTelecom(List<Telecom> telecom) {
        this.telecom = telecom;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Boolean getMultipleBirthBoolean() {
        return multipleBirthBoolean;
    }

    public void setMultipleBirthBoolean(Boolean multipleBirthBoolean) {
        this.multipleBirthBoolean = multipleBirthBoolean;
    }

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    public List<GeneralPractitioner> getGeneralPractitioner() {
        return generalPractitioner;
    }

    public void setGeneralPractitioner(List<GeneralPractitioner> generalPractitioner) {
        this.generalPractitioner = generalPractitioner;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getDeceasedBoolean() {
        return deceasedBoolean;
    }

    public void setDeceasedBoolean(Boolean deceasedBoolean) {
        this.deceasedBoolean = deceasedBoolean;
    }

    public List<Extension__> getExtension() {
        return extension;
    }

    public void setExtension(List<Extension__> extension) {
        this.extension = extension;
    }

    public List<Communication> getCommunication() {
        return communication;
    }

    public void setCommunication(List<Communication> communication) {
        this.communication = communication;
    }

}
