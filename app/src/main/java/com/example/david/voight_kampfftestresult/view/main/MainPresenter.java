package com.example.david.voight_kampfftestresult.view.main;

import com.example.david.voight_kampfftestresult.manager.ApiManager;
import com.example.david.voight_kampfftestresult.model.local.LocalPatient;
import com.example.david.voight_kampfftestresult.model.remote.get.Entry;
import com.example.david.voight_kampfftestresult.model.remote.get.RecentQuery;
import com.example.david.voight_kampfftestresult.model.remote.get.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by David on 2017-12-11.
 */

public class MainPresenter implements MainContract.Presenter {


    private MainContract.View view;
    private ApiManager.Service service;
    private List<Entry> queryResult = new ArrayList<>();
    private HashMap<String, LocalPatient> patientList = new HashMap<>();

    public MainPresenter(MainContract.View view, ApiManager.Service service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void addView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView(MainContract.View view) {
        this.view = null;

    }

    @Override
    public void doRecentQuery(String dateFilter, int count) {

        final HashMap<String, String> queryMap = new HashMap<>();

        if(dateFilter != null && !dateFilter.isEmpty()){
            queryMap.put("_date", dateFilter);
        }
        queryMap.put("_count",String.valueOf(count));

        service.queryRecent(queryMap).enqueue(new Callback<RecentQuery>() {
            @Override
            public void onResponse(Call<RecentQuery> call, Response<RecentQuery> response) {
                if(response.body() != null){
                    queryResult.addAll(response.body().getEntry());
                    mapRemoteToLocal();
                }else{
                    view.showErrorMessage("Error");
                }
            }

            @Override
            public void onFailure(Call<RecentQuery> call, Throwable t) {
                t.printStackTrace();
                view.showErrorMessage(t.getMessage());
            }
        });

    }

    public void mapRemoteToLocal(){
        for(Entry entry : queryResult){
            Resource resource = entry.getResource();
            LocalPatient lp = new LocalPatient();
            lp.setLastUpdated(resource.getMeta().getLastUpdated());
            lp.setDateOfBirth(resource.getBirthDate());
            lp.setGender(resource.getGender());
            if(resource.getName() != null) {
                lp.setFamilyName(resource.getName().get(0).getFamily());
                if(resource.getName().get(0).getGiven() != null) {
                    lp.setGiveName(resource.getName().get(0).getGiven());
                }
            }
            patientList.put(resource.getId(),lp);
        }
        view.updateList(patientList);
    }
}
