
package com.example.david.voight_kampfftestresult.model.remote.put;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("versionId")
    @Expose
    private String versionId;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
