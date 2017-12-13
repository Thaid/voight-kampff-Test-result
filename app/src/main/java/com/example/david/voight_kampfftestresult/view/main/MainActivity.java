package com.example.david.voight_kampfftestresult.view.main;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.david.voight_kampfftestresult.R;
import com.example.david.voight_kampfftestresult.manager.ApiManager;
import com.example.david.voight_kampfftestresult.model.local.LocalPatient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, PatientInterface, PatientInfoFragment.OnPatientUpdate{

    FragmentManager fragmentManager;

    private Toolbar toolbar;
    private MainPresenter presenter;
    private RecyclerView patientListRV;
    private PatientListAdapter mAdapater;
    private List<LocalPatient> patientList = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;
    private FrameLayout patientInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        presenter = new MainPresenter(this, ApiManager.getInstance().provideService());
        patientInfo = (FrameLayout) findViewById(R.id.patientInfoContainer);
        setUpRecyclerView();
        setUpToolbar();
        fetchPatients("", 10);

    }

    private void setUpRecyclerView() {
        patientListRV = (RecyclerView) findViewById(R.id.patient_list_rv);
        mAdapater = new PatientListAdapter(patientList, this, this);
        patientListRV.setAdapter(mAdapater);
        mLayoutManager = new LinearLayoutManager(this);
        patientListRV.setLayoutManager(mLayoutManager);

    }

    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Patients");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed() {
        if (patientInfo.getVisibility() == View.VISIBLE) {
            patientInfo.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void updateList(HashMap<String, LocalPatient> patients) {
        patientList.clear();
        patientList.addAll(patients.values());
        mAdapater.notifyDataSetChanged();
    }

    @Override
    public void showErrorMessage(String message) {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Error")
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();

    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        if (patientInfo.getVisibility() == View.VISIBLE) {
            patientInfo.setVisibility(View.GONE);
        }
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void fetchPatients(String dateFilter, int count) {
        presenter.doRecentQuery(dateFilter, count);
    }

    @Override
    public void showPatientInfo(LocalPatient localPatient) {
        Bundle args = new Bundle();
        args.putParcelable("PatientInfo",localPatient);
        PatientInfoFragment infoFragment;
        infoFragment = new PatientInfoFragment();
        infoFragment.setArguments(args);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.patientInfoContainer, infoFragment, "infoFragment");
        fragmentTransaction.commit();

        patientInfo.setVisibility(View.VISIBLE);

    }

    @Override
    public void updatePatient(LocalPatient localPatient) {
        presenter.updatePatient(localPatient.getId(),localPatient);

    }
}
