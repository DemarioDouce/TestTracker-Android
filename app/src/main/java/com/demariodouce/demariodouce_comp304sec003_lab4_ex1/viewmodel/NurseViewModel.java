package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.NurseEntity;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.repo.NurseRepository;

import java.util.List;

public class NurseViewModel extends AndroidViewModel {
    // calling repository tasks and
    // sending the results to the Activity
    private NurseRepository nurseRepository;
    private LiveData<Integer> insertResult;
    private LiveData<List<NurseEntity>> allNurses;

    //
    public NurseViewModel(@NonNull Application application) {
        super(application);
        nurseRepository = new NurseRepository(application);
        insertResult = nurseRepository.getInsertResult();
        allNurses = nurseRepository.getAllNurses();
    }
    //
    public LiveData<NurseEntity> checkValidLogin(int userId, String password)
    {
        return nurseRepository.isValidAccount(userId, password);
    }

    //calls repository to insert a nurse
    public void insert(NurseEntity nurseEntity) {
        nurseRepository.insert(nurseEntity);
    }

    //gets insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    //returns query results as live data object
    LiveData<List<NurseEntity>> getAllNurses() {
        return allNurses;
    }
}
