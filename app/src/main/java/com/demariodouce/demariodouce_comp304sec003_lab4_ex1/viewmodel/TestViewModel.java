package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.TestEntity;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.repo.TestRepository;

import java.util.List;

public class TestViewModel extends AndroidViewModel {

    public TestRepository testRepository;
    public LiveData<List<TestEntity>> allTests;
    public TestViewModel(@NonNull Application application) {
        super ( application );
        testRepository =  new TestRepository(application);

    }


    public  void insert(TestEntity testEntity)
    {
        testRepository.insertTest (testEntity);
    }



   public LiveData<List<TestEntity>> alltests(int id) { return
            testRepository.allTests (id); }
}
