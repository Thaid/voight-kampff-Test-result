
package com.example.david.voight_kampfftestresult.model.remote.get;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValueCodeableConcept {

    @SerializedName("coding")
    @Expose
    private List<Coding___> coding = null;
    @SerializedName("text")
    @Expose
    private String text;

    public List<Coding___> getCoding() {
        return coding;
    }

    public void setCoding(List<Coding___> coding) {
        this.coding = coding;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
