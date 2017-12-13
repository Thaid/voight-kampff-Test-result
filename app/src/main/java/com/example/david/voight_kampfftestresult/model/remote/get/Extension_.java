
package com.example.david.voight_kampfftestresult.model.remote.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Extension_ {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("valueDecimal")
    @Expose
    private Double valueDecimal;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getValueDecimal() {
        return valueDecimal;
    }

    public void setValueDecimal(Double valueDecimal) {
        this.valueDecimal = valueDecimal;
    }

}
