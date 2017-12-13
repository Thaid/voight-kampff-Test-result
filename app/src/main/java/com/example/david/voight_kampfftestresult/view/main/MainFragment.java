package com.example.david.voight_kampfftestresult.view.main;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.david.voight_kampfftestresult.R;
import com.example.david.voight_kampfftestresult.manager.ApiManager;
import com.example.david.voight_kampfftestresult.model.local.LocalPatient;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment implements MainContract.View, PatientInterface{


    private View rootView;
    private Toolbar toolbar;
    private MainPresenter presenter;
    private RecyclerView patientListRV;
    private PatientListAdapter mAdapater;
    private List<LocalPatient> patientList = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;
    private FrameLayout patientInfo;

    public MainFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new MainPresenter(this, ApiManager.getInstance().provideService());
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        patientInfo = (FrameLayout) rootView.findViewById(R.id.patientInfoContainer);
        setUpToolbar();
        setUpRecyclerView();
        fetchPatients("",10);
        return rootView;

    }

    private void setUpRecyclerView() {
        patientListRV = (RecyclerView) rootView.findViewById(R.id.patient_list_rv);
        mAdapater = new PatientListAdapter(patientList,getContext(),this);
        patientListRV.setAdapter(mAdapater);
        mLayoutManager = new LinearLayoutManager(getContext());
        patientListRV.setLayoutManager(mLayoutManager);

    }

    private void setUpToolbar(){
        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        toolbar.setTitle("Patients");
        toolbar.setTitleTextColor(Color.WHITE);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
    }


    @Override
    public void updateList(List<LocalPatient> patients) {
        patientList.clear();
        patientList.addAll(patients);
        mAdapater.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showToast(String message) {

    }

    private void fetchPatients(String dateFilter, int count){
        presenter.doRecentQuery(dateFilter,count);
    }

    @Override
    public void showPatientInfo(LocalPatient localPatient) {
        patientInfo.setVisibility(View.VISIBLE);

    }
}
