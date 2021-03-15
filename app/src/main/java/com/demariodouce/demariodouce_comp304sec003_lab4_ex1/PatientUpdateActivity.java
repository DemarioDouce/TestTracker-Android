package com.demariodouce.demariodouce_comp304sec003_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.PatientEntity;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.viewmodel.PatientViewModel;

public class PatientUpdateActivity extends AppCompatActivity {
//
Intent intent3;
    //Database
    private PatientViewModel patientViewModel;
    PatientEntity updatedPatient;
    //UI variables
    private EditText firstName;
    private EditText lastName;
    private EditText department;
    private EditText room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_update);
        //
        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");
        //
        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        //
        patientViewModel.findById(id).observe(this, new Observer<PatientEntity>() {
            @Override
            public void onChanged(PatientEntity patientEntity) {
                //UI variables
                firstName = findViewById(R.id.firstNameUpdateEtt);
                lastName = findViewById(R.id.lastNameUpdateEtt);
                department = findViewById(R.id.departmentUpdateEtt);
                room = findViewById(R.id.roomUpdateEtt);
                //
                try {
                    updatedPatient = patientEntity;
                    Toast.makeText(PatientUpdateActivity.this, "Your selected ID number: "+String.valueOf(id), Toast.LENGTH_SHORT).show();
                    firstName.setText(String.valueOf(patientEntity.getFirstname()));
                    lastName.setText(patientEntity.getLastname());
                    department.setText(patientEntity.getDepartment());
                    room.setText(patientEntity.getRoom());
                }
                catch (Exception e){
                    Toast.makeText(PatientUpdateActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void patientUpdate(View view) {
        //UI variables
        firstName = findViewById(R.id.firstNameUpdateEtt);
        lastName = findViewById(R.id.lastNameUpdateEtt);
        department = findViewById(R.id.departmentUpdateEtt);
        room = findViewById(R.id.roomUpdateEtt);
        //
        try {
            updatedPatient.setFirstname(firstName.getText().toString().trim());
            updatedPatient.setLastname(lastName.getText().toString().trim());
            updatedPatient.setDepartment(department.getText().toString().trim());
            updatedPatient.setRoom(room.getText().toString().trim());

            patientViewModel.update(updatedPatient);

            intent3 = new Intent(PatientUpdateActivity.this, PatientActivity.class);

            Toast.makeText(PatientUpdateActivity.this, "Patient successfully updated.", Toast.LENGTH_SHORT).show();
            startActivity(intent3);
        } catch (Exception e) {
            Toast.makeText(PatientUpdateActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}