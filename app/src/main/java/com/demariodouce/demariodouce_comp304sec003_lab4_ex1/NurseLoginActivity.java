package com.demariodouce.demariodouce_comp304sec003_lab4_ex1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.NurseEntity;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.viewmodel.NurseViewModel;

public class NurseLoginActivity extends AppCompatActivity {

    //Database
    private NurseViewModel nurseViewModel;
    NurseEntity nurseEntity;

    //UI variables
    private EditText nurseId;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_login);

        nurseViewModel = ViewModelProviders.of(this).get(NurseViewModel.class);

        nurseEntity = new NurseEntity();
        //

    }

    public void nurseLogin(View view) {
        //UI variables
        nurseId = findViewById(R.id.nurseIdEtt);
        password = findViewById(R.id.passwordEtt);

        nurseViewModel.checkValidLogin(Integer.parseInt(nurseId.getText().toString().trim()), password.getText().toString().trim()).observe(this, new Observer<NurseEntity>() {
            @Override
            public void onChanged(NurseEntity nurseEntity) {
                if (nurseEntity != null) {

                    Toast.makeText(getBaseContext(), "Successfully Logged In.", Toast.LENGTH_LONG).show();
                    Log.i("Successful_Login", "Login was successful");
                } else {
                    Toast.makeText(getBaseContext(), "Invalid Login.", Toast.LENGTH_SHORT).show();
                    Log.i("Unsuccessful_Login", "Login was not successful");
                }

            }
        });

    }
}