package com.demariodouce.demariodouce_comp304sec003_lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Opens the NurseLoginActivity.
    public void openNurseLogin(View view) {
        Intent intent = new Intent(this, NurseLoginActivity.class);
        startActivity(intent);
    }

    //Opens the Nurse Register Activity.
    public void openNurseRegister(View view) {
        Intent intent = new Intent(this, NurseRegisterActivity.class);
        startActivity(intent);
    }
}