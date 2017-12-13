package com.example.david.voight_kampfftestresult.view.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.david.voight_kampfftestresult.R;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        setUpFragment();
    }

    private void setUpFragment(){
        Fragment fragment = fragmentManager.findFragmentByTag("mainFragment");
        MainFragment mainFragment;
        if(fragment == null){
            mainFragment = new MainFragment();
        }else{
            mainFragment = (MainFragment) fragment;
        }
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer,mainFragment,"mainFragment");
        fragmentTransaction.commit();
    }
}
