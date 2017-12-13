package com.example.david.voight_kampfftestresult.view.main;

import com.example.david.voight_kampfftestresult.model.local.LocalPatient;

import java.util.List;

/**
 * Created by David on 2017-12-11.
 */

public class MainContract {

    interface View{
        void updateList(List<LocalPatient> patientList);

        void showErrorMessage(String message);

        void showToast(String message);
    }

    interface Presenter{
        void addView(View view);
        void removeView(View view);

        void doRecentQuery(String dateFilter, int count);

        void updatePatient(String id, LocalPatient localPatient);

        void deletePatient(String id);
    }
}
