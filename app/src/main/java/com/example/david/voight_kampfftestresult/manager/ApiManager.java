package com.example.david.voight_kampfftestresult.manager;

import com.example.david.voight_kampfftestresult.model.remote.get.RecentQuery;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by David on 2017-12-11.
 */

public class ApiManager {

    private String BASE_URL = "http://fhirtest.uhn.ca/baseDstu3/Patient/";
    private static volatile ApiManager instance = null;

    public static ApiManager getInstance(){
        if(instance == null){
            synchronized (ApiManager.class){
                if(instance == null){
                    instance = new ApiManager();
                }
            }
        }
        return instance;
    }


    private Retrofit createService(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Service provideService(){
        return createService().create(Service.class);
    }

    public interface Service{

        @GET("_history?")
        Call<RecentQuery> queryRecent(@QueryMap HashMap<String, String> query);
    }
}
