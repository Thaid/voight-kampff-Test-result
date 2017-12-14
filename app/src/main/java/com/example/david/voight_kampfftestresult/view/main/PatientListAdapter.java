package com.example.david.voight_kampfftestresult.view.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.david.voight_kampfftestresult.R;
import com.example.david.voight_kampfftestresult.model.local.LocalPatient;

import java.util.List;

/**
 * Created by David on 2017-12-12.
 */

public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.ViewHolder> {


    private List<LocalPatient> mData;
    private Context context;
    private PatientInterface mListener;

    public PatientListAdapter(List<LocalPatient> mdata, Context context, PatientInterface listener) {
        this.mData = mdata;
        this.context = context;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_patient,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final LocalPatient localPatient = mData.get(position);
        holder.familyName.setText("Family name: "+localPatient.getFamilyName());
        if(localPatient.getGiveName() != null && !localPatient.getGiveName().isEmpty()) {
            holder.givenName.setText("Given name: " + localPatient.getGiveName().get(0));
        }else{
            holder.givenName.setText("Given name: ");
        }
        holder.gender.setText(localPatient.getGender());
        holder.dob.setText(localPatient.getDateOfBirth());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.showPatientInfo(localPatient);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView familyName;
        private TextView givenName;
        private TextView dob;
        private TextView gender;
        private LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            familyName = (TextView) itemView.findViewById(R.id.li_family_name);
            givenName = (TextView) itemView.findViewById(R.id.li_patient_name);
            dob = (TextView) itemView.findViewById(R.id.li_birth_date);
            gender = (TextView) itemView.findViewById(R.id.li_gender);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.list_item_layout);
        }
    }

}
