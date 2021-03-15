package com.demariodouce.demariodouce_comp304sec003_lab4_ex1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.NurseEntity;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.PatientEntity;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.viewmodel.PatientViewModel;

import java.util.List;

public class PatientActivity extends AppCompatActivity {

    //Database
    private PatientViewModel patientViewModel;
    PatientEntity patientEntity;
    //
    ListView listView;
    LinearLayout layout;
    private ArrayAdapter<PatientEntity> aAdapter;
    //UI variables
    private EditText firstName;
    private EditText lastName;
    private EditText department;
    private EditText room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        //
        listView = (ListView)findViewById(R.id.listview);
        //
        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        //
        patientViewModel.getAllPatients().observe(this, new Observer<List<PatientEntity>>() {
            @Override
            public void onChanged(@Nullable final List<PatientEntity> patients) {

                aAdapter = new ArrayAdapter<PatientEntity>(getBaseContext(), android.R.layout.simple_list_item_1, patients);
                listView.setAdapter(aAdapter);

            }
        });
        //
        patientEntity = new PatientEntity();
        patientViewModel.getInsertResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer result) {
                if (result == 1) {
                    Toast.makeText(PatientActivity.this, "Successfully registered.", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(PatientActivity.this, "Error registering.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemClickListener (new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent;

                intent = new Intent(view.getContext(), PatientInfoActivity.class);
                Object current = listView.getItemAtPosition(position);
                int currentId = ((PatientEntity)current).getPatientId ();
                Bundle bundle = new Bundle();
                bundle.putInt ( "id",currentId  );
                intent.putExtras (  bundle  );
                startActivity(intent);
            }

        });
    }

    public void patientRegister(View view) {
        //UI variables
        firstName = findViewById(R.id.firstNameEtt);
        lastName = findViewById(R.id.lastNameEtt);
        department = findViewById(R.id.departmentEtt);
        room = findViewById(R.id.roomEtt);


        //Intent value
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String nurseIdIntent = extras.getString("nurseId");
            patientEntity.setNurseId(Integer.parseInt(nurseIdIntent));
        }

        //
        patientEntity.setFirstname(firstName.getText().toString().trim());
        patientEntity.setLastname(lastName.getText().toString().trim());
        patientEntity.setDepartment(department.getText().toString().trim());
        patientEntity.setRoom(room.getText().toString().trim());
        patientViewModel.insert(patientEntity);
        //
        firstName.setText("");
        lastName.setText("");
        department.setText("");
        room.setText("");
    }
}