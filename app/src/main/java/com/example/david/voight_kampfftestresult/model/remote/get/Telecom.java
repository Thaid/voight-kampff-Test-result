
package com.example.david.voight_kampfftestresult.model.remote.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Telecom {

    @SerializedName("system")
    @Expose
    private String system;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("use")
    @Expose
    private String use;

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

}
