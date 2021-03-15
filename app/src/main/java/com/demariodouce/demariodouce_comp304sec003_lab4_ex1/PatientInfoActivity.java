package com.demariodouce.demariodouce_comp304sec003_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.PatientEntity;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.viewmodel.PatientViewModel;

public class PatientInfoActivity extends AppCompatActivity {

    //
    private Button btnEdit,btnAdd;
    private Intent intent;
    private TextView txtInfo;
    //Database
    private PatientViewModel patientViewModel;
    PatientEntity currentPatient;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);
        //
        txtInfo = (TextView)findViewById ( R.id.txtInfo );
        btnAdd = (Button)findViewById ( R.id.btnAddTest);
        btnEdit = (Button)findViewById ( R.id.btnEdit);
        //
        Bundle bundle = getIntent().getExtras();
        int id= bundle.getInt ("id");
        //
        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        //
        patientViewModel.findById( id).observe ( this, new Observer<PatientEntity>() {
            @Override
            public void onChanged(PatientEntity patientEntity) {
                currentPatient = patientEntity;
                txtInfo.setText ( patientEntity.toString () );

            }
        } );

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), PatientUpdateActivity.class);
                Object current = currentPatient;
                int currentId = ((PatientEntity)current).getPatientId ();
                Bundle bundle = new Bundle();
                bundle.putInt ( "id",currentId  );
                intent.putExtras (  bundle  );
                startActivity(intent);
            }
        });

    }
}