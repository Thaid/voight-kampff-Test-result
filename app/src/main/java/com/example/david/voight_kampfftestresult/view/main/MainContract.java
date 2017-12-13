package com.example.david.voight_kampfftestresult.view.main;

import com.example.david.voight_kampfftestresult.model.local.LocalPatient;
import com.example.david.voight_kampfftestresult.model.remote.get.Entry;
import com.example.david.voight_kampfftestresult.model.remote.get.RecentQuery;

import java.util.HashMap;
import java.util.List;

/**
 * Created by David on 2017-12-11.
 */

public class MainContract {

    interface View{
        void updateList(HashMap<String, LocalPatient> patientList);

        void showErrorMessage(String message);
    }

    interface Presenter{
        void addView(View view);
        void removeView(View view);

        void doRecentQuery(String dateFilter, int count);
    }
}
