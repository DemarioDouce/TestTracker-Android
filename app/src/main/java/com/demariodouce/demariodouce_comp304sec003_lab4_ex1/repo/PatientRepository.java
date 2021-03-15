package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.repo;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.daos.PatientDao;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.database.PatientDatabase;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.PatientEntity;

import java.util.List;

public class PatientRepository {

    private final PatientDao patientDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private LiveData<List<PatientEntity>> patientList;
    //
    public PatientRepository(Context context) {
        //create a database object
        PatientDatabase db = PatientDatabase.getInstance(context);
        //create an interface object
        patientDao = db.patientDao();
        //call interface method
        patientList = patientDao.getAllPatients();
    }
    // returns query results as LiveData object
    public LiveData<List<PatientEntity>> getAllPatients() {
        return patientList;
    }
    //inserts a patient asynchronously
    public void insert(PatientEntity patientEntity) {
        insertAsync(patientEntity);
    }
    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final PatientEntity patientEntity) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    patientDao.insert(patientEntity);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }
}
