package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.repo;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.daos.NurseDao;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.database.NurseDatabase;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.NurseEntity;

import java.util.List;

public class NurseRepository {
    private final NurseDao nurseDao;
    private MutableLiveData<Integer> insertResult = new MutableLiveData<>();
    private LiveData<List<NurseEntity>> nurseList;
    //
    public NurseRepository(Context context) {
        //create a database object
        NurseDatabase db = NurseDatabase.getInstance(context);
        //create an interface object
        nurseDao = db.nurseDao();
        //call interface method
        nurseList = nurseDao.getAllNurses();
    }
    // returns query results as LiveData object
    public LiveData<List<NurseEntity>> getAllNurses() {
        return nurseList;
    }
    //inserts a person asynchronously
    public void insert(NurseEntity nurseEntity) {
        insertAsync(nurseEntity);
    }
    // returns insert results as LiveData object
    public LiveData<Integer> getInsertResult() {
        return insertResult;
    }

    private void insertAsync(final NurseEntity nurseEntity) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    nurseDao.insert(nurseEntity);
                    insertResult.postValue(1);
                } catch (Exception e) {
                    insertResult.postValue(0);
                }
            }
        }).start();
    }
}
