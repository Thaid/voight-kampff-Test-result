package com.example.david.voight_kampfftestresult.view.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.david.voight_kampfftestresult.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientInfoFragment extends Fragment {


    public PatientInfoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_patient_info, container, false);
    }

}
