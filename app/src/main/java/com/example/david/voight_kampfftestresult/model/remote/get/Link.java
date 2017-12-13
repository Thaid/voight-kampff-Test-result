
package com.example.david.voight_kampfftestresult.model.remote.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link {

    @SerializedName("relation")
    @Expose
    private String relation;
    @SerializedName("url")
    @Expose
    private String url;

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
