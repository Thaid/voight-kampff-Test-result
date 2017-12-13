
package com.example.david.voight_kampfftestresult.model.remote.get;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta_ {

    @SerializedName("versionId")
    @Expose
    private String versionId;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    @SerializedName("tag")
    @Expose
    private List<Tag> tag = null;
    @SerializedName("profile")
    @Expose
    private List<String> profile = null;

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

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    public List<String> getProfile() {
        return profile;
    }

    public void setProfile(List<String> profile) {
        this.profile = profile;
    }

}
