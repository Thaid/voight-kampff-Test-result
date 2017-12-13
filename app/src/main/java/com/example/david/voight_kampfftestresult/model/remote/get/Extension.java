
package com.example.david.voight_kampfftestresult.model.remote.get;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Extension {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("extension")
    @Expose
    private List<Extension_> extension = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Extension_> getExtension() {
        return extension;
    }

    public void setExtension(List<Extension_> extension) {
        this.extension = extension;
    }

}
