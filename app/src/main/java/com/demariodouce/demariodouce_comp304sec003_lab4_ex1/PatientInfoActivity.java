package com.demariodouce.demariodouce_comp304sec003_lab4_ex1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.PatientEntity;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.TestEntity;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.viewmodel.PatientViewModel;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.viewmodel.TestViewModel;

import java.util.List;

public class PatientInfoActivity extends AppCompatActivity {

    //
    private Button btnEdit,btnAdd;
    private Intent intent;
    private TextView txtInfo;
    //Database
    private PatientViewModel patientViewModel;
    PatientEntity currentPatient;
    //
    ListView listViewTest;
    //
    TestViewModel testViewModel;
    private ArrayAdapter<TestEntity> testAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);
        //
        txtInfo = (TextView)findViewById ( R.id.txtInfo );
        btnAdd = (Button)findViewById ( R.id.btnAddTest);
        btnEdit = (Button)findViewById ( R.id.btnEdit);
        listViewTest = (ListView) findViewById ( R.id.listviewTest);
        //
        Bundle bundle = getIntent().getExtras();
        int id= bundle.getInt ("id");
        //
        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        //
        testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);
        patientViewModel.findById( id).observe ( this, new Observer<PatientEntity>() {
            @Override
            public void onChanged(PatientEntity patientEntity) {
                currentPatient = patientEntity;
                txtInfo.setText ( patientEntity.toString () );

            }
        } );
        testViewModel.alltests (id).observe(this, new Observer<List<TestEntity>>() {

            public void onChanged(@Nullable final List<TestEntity> tests) {

                testAdapter = new ArrayAdapter<TestEntity>(getBaseContext(), android.R.layout.simple_list_item_1,  tests);
                listViewTest.setAdapter(testAdapter);

            }

        });
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
        //
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(v.getContext(), TestActivity.class);
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