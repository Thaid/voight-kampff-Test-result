package com.example.david.voight_kampfftestresult.view.main;

import com.example.david.voight_kampfftestresult.manager.ApiManager;
import com.example.david.voight_kampfftestresult.model.local.LocalPatient;
import com.example.david.voight_kampfftestresult.model.remote.get.Entry;
import com.example.david.voight_kampfftestresult.model.remote.get.RecentQuery;
import com.example.david.voight_kampfftestresult.model.remote.get.Resource;
import com.example.david.voight_kampfftestresult.model.remote.put.Name;
import com.example.david.voight_kampfftestresult.model.remote.put.UpdatePatient;

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
    private List<LocalPatient> patientList = new ArrayList<>();

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

        queryResult.clear();
        service.queryRecent(queryMap).enqueue(new Callback<RecentQuery>() {
            @Override
            public void onResponse(Call<RecentQuery> call, Response<RecentQuery> response) {
                if(response.body() != null){
                    queryResult.addAll(response.body().getEntry());
                    mapRemoteToLocal();
                }else{
                    view.showErrorMessage(response.message());
                }
            }

            @Override
            public void onFailure(Call<RecentQuery> call, Throwable t) {
                t.printStackTrace();
                view.showErrorMessage(t.getMessage());
            }
        });

    }

    @Override
    public void updatePatient(String id, LocalPatient localPatient) {
        UpdatePatient updatePatient = new UpdatePatient();
        updatePatient.convertLocalToRemote(localPatient);
        service.updatePatientInfo(id,updatePatient).enqueue(new Callback<UpdatePatient>() {
            @Override
            public void onResponse(Call<UpdatePatient> call, Response<UpdatePatient> response) {
                if(response.body() != null){
                    view.showToast("Update Successful");
                }else{
                    view.showErrorMessage(response.message());
                }
            }

            @Override
            public void onFailure(Call<UpdatePatient> call, Throwable t) {

            }
        });
    }

    @Override
    public void deletePatient(String id) {
        service.deletePatient(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.body() != null){
                    view.showToast(response.message());
                }else{
                    view.showErrorMessage(response.message());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void mapRemoteToLocal(){
        patientList.clear();
        for(Entry entry : queryResult){
            Resource resource = entry.getResource();
            LocalPatient lp = new LocalPatient();
            lp.setDateOfBirth(resource.getBirthDate());
            lp.setId(resource.getId());
            lp.setGender(resource.getGender());
            if(resource.getName() != null) {
                lp.setFamilyName(resource.getName().get(0).getFamily());
                if(resource.getName().get(0).getGiven() != null) {
                    lp.setGiveName(resource.getName().get(0).getGiven());
                }
            }
            patientList.add(lp);
        }
        view.updateList(patientList);
    }
}
