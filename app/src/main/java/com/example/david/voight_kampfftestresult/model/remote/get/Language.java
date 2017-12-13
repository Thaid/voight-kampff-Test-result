
package com.example.david.voight_kampfftestresult.model.remote.get;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Language {

    @SerializedName("coding")
    @Expose
    private List<Coding____> coding = null;

    public List<Coding____> getCoding() {
        return coding;
    }

    public void setCoding(List<Coding____> coding) {
        this.coding = coding;
    }

}
