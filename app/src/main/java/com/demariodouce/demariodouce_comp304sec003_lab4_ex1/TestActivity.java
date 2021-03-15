package com.demariodouce.demariodouce_comp304sec003_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.PatientEntity;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.TestEntity;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.viewmodel.PatientViewModel;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.viewmodel.TestViewModel;

import java.util.Calendar;

public class TestActivity extends AppCompatActivity {

    TestViewModel testViewModel;
    PatientViewModel patientViewModel;

    Button btnAddTest;
    Intent intent4;
    PatientEntity currentPatient;
    EditText txtTemp, txtBPL, txtBPH;
    DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_test);

        btnAddTest= (Button)findViewById(R.id.btnAddTest);
        txtTemp = (EditText) findViewById ( R.id.temperatureEtt );
        txtBPL = (EditText) findViewById ( R.id.bplEtt );
        txtBPH = (EditText) findViewById ( R.id.bphEtt );

        Bundle bundle = getIntent().getExtras();
        int id= bundle.getInt ("id");
        testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);
        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        patientViewModel.findById( id).observe ( this, new Observer<PatientEntity> () {
            @Override
            public void onChanged(PatientEntity patientEntity) {
                currentPatient = patientEntity;

            }
        } );
        btnAddTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    TestEntity test = new TestEntity ( currentPatient.getPatientId (), txtBPL.getText ().toString (), txtBPH.getText ().toString (), txtTemp.getText ().toString ());
                    testViewModel.insert ( test );
                    intent4 = new Intent ( TestActivity.this, PatientActivity.class );
                    Toast.makeText ( TestActivity.this, "Test successfully saved.", Toast.LENGTH_SHORT ).show ();
                    startActivity(intent4);
                }


                catch (Exception e)
                {
                    Toast.makeText(TestActivity.this, e.getMessage (), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}