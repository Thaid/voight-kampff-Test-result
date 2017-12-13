
package com.example.david.voight_kampfftestresult.model.remote.get;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Relationship {

    @SerializedName("coding")
    @Expose
    private List<Coding__> coding = null;

    public List<Coding__> getCoding() {
        return coding;
    }

    public void setCoding(List<Coding__> coding) {
        this.coding = coding;
    }

}
