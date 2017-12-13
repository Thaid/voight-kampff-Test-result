
package com.example.david.voight_kampfftestresult.model.remote.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entry {

    @SerializedName("fullUrl")
    @Expose
    private String fullUrl;
    @SerializedName("resource")
    @Expose
    private Resource resource;
    @SerializedName("request")
    @Expose
    private Request request;

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

}
