package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.TestEntity;

import java.util.List;

@Dao
public interface TestDao {
    @Query("select * from TestEntity where patientId = :id ")
    public LiveData<List<TestEntity>> alltests(int id);

    @Insert
    public void insertTest(TestEntity testEntity);

    @Query("select * from TestEntity where patientId = :id and testId=:testId")
    LiveData<TestEntity> loadTest(int id, int testId);
}
