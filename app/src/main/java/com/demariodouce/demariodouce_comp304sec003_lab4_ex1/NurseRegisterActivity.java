package com.demariodouce.demariodouce_comp304sec003_lab4_ex1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.NurseEntity;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.viewmodel.NurseViewModel;

public class NurseRegisterActivity extends AppCompatActivity {

    //Database
    private NurseViewModel nurseViewModel;
    NurseEntity nurseEntity;

    //UI variables
    private EditText firstName;
    private EditText lastName;
    private EditText department;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_register);

        nurseViewModel = ViewModelProviders.of(this).get(NurseViewModel.class);

        nurseEntity = new NurseEntity();
        //
        nurseViewModel.getInsertResult().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer result) {
                if (result == 1) {
                    Toast.makeText(NurseRegisterActivity.this, "Successfully registered.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(NurseRegisterActivity.this, "Error registering.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void nurseRegister(View view) {
        //UI variables
        firstName = findViewById(R.id.firstNameEtt);
        lastName = findViewById(R.id.lastNameEtt);
        department = findViewById(R.id.departmentEtt);
        password = findViewById(R.id.passwordEtt);
        //
        nurseEntity.setFirstName(firstName.getText().toString());
        nurseEntity.setLastName(lastName.getText().toString());
        nurseEntity.setDepartment(department.getText().toString());
        nurseEntity.setPassword(password.getText().toString());
        nurseViewModel.insert(nurseEntity);
    }
}