package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.PatientEntity;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.repo.PatientRepository;

import java.util.List;

public class PatientViewModel extends AndroidViewModel {
    // calling repository tasks and
    // sending the results to the Activity
    private PatientRepository patientRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<PatientEntity>> allPatients;

    //
    public PatientViewModel(@NonNull Application application) {
        super(application);
        patientRepository = new PatientRepository(application);
        insertResult = patientRepository.getInsertResult();
        allPatients = patientRepository.getAllPatients();
    }
    //calls repository to insert a patient
    public void insert(PatientEntity patientEntity) {
        patientRepository.insert(patientEntity);
    }

    //gets insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    //returns query results as live data object
    public LiveData<List<PatientEntity>> getAllPatients() {
        return allPatients;
    }

    //find patient by ID
    public  LiveData<PatientEntity>  findById(int id)
    {
        return  patientRepository.loadPatient ( id );
    }
//Delete
public void delete(PatientEntity patientEntity)
{
    patientRepository.delete (patientEntity);
}
    //
    public void update(PatientEntity patient)
    {
        patientRepository.update (patient);
    }
}

