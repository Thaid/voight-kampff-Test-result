
package com.example.david.voight_kampfftestresult.model.remote.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Extension__ {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("valueCodeableConcept")
    @Expose
    private ValueCodeableConcept valueCodeableConcept;
    @SerializedName("valueAddress")
    @Expose
    private ValueAddress valueAddress;
    @SerializedName("valueString")
    @Expose
    private String valueString;
    @SerializedName("valueCode")
    @Expose
    private String valueCode;
    @SerializedName("valueBoolean")
    @Expose
    private Boolean valueBoolean;
    @SerializedName("valueHumanName")
    @Expose
    private ValueHumanName valueHumanName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ValueCodeableConcept getValueCodeableConcept() {
        return valueCodeableConcept;
    }

    public void setValueCodeableConcept(ValueCodeableConcept valueCodeableConcept) {
        this.valueCodeableConcept = valueCodeableConcept;
    }

    public ValueAddress getValueAddress() {
        return valueAddress;
    }

    public void setValueAddress(ValueAddress valueAddress) {
        this.valueAddress = valueAddress;
    }

    public String getValueString() {
        return valueString;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public String getValueCode() {
        return valueCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode;
    }

    public Boolean getValueBoolean() {
        return valueBoolean;
    }

    public void setValueBoolean(Boolean valueBoolean) {
        this.valueBoolean = valueBoolean;
    }

    public ValueHumanName getValueHumanName() {
        return valueHumanName;
    }

    public void setValueHumanName(ValueHumanName valueHumanName) {
        this.valueHumanName = valueHumanName;
    }

}
