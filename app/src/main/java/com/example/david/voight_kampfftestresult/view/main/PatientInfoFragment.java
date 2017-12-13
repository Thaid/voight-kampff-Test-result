package com.example.david.voight_kampfftestresult.view.main;


import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.voight_kampfftestresult.R;
import com.example.david.voight_kampfftestresult.model.local.LocalPatient;

import java.util.Calendar;


public class PatientInfoFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    View view;
    LocalPatient localPatient;

    private OnPatientUpdate mListener;

    EditText givenNameEdit;
    EditText familyNameEdit;
    EditText genderEdit;
    TextView dobText;
    LinearLayout dobLayout;
    Calendar calendar;
    Button updateButton;
    Button deleteButton;

    public PatientInfoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle args = getArguments();
        if (args != null) {
            localPatient = (LocalPatient) args.getParcelable("PatientInfo");
        }
        view = inflater.inflate(R.layout.fragment_patient_info, container, false);
        setUpView();
        setUpListeners();

        if (localPatient != null) {
            populateView();
        }
        calendar = Calendar.getInstance();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPatientUpdate) {
            mListener = (OnPatientUpdate) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void setUpView() {
        givenNameEdit = (EditText) view.findViewById(R.id.given_name_edit);
        familyNameEdit = (EditText) view.findViewById(R.id.family_name_edit);
        genderEdit = (EditText) view.findViewById(R.id.gender_edit);
        dobLayout = (LinearLayout) view.findViewById(R.id.dob_linear_layout);
        dobText = (TextView) view.findViewById(R.id.dob_text);
        updateButton = (Button) view.findViewById(R.id.update_patient_info);
        deleteButton = (Button) view.findViewById(R.id.delete_patient_info);
    }

    private void populateView() {
        if (localPatient.getFamilyName() != null) {
            familyNameEdit.setText(localPatient.getFamilyName());
        }
        if (localPatient.getGender() != null) {
            genderEdit.setText(localPatient.getGender());
        }
        if (localPatient.getDateOfBirth() != null) {
            dobText.setText(localPatient.getDateOfBirth());
        }
    }

    private void setUpListeners() {
        dobLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCalendarPicker();
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                localPatient.setDateOfBirth(dobText.getText().toString());
                localPatient.setFamilyName(familyNameEdit.getText().toString());
                localPatient.setGender(genderEdit.getText().toString());
                mListener.updatePatient(localPatient);
            }
        });

    }

    private void showCalendarPicker() {
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), this, year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();

        String dob = String.valueOf(year);
        String monthString = String.valueOf(month+1);
        if (monthString.length() < 2) {
            monthString = "0" + monthString;
        }

        dob = dob + "-" + monthString;

        String dayString = String.valueOf(day);

        if (dayString.length() < 2) {
            dayString = "0" + dayString;
        }
        dob = dob+'-'+dayString;
        dobText.setText(dob);
    }

    public interface OnPatientUpdate {
        void updatePatient(LocalPatient localPatient);
    }
}
