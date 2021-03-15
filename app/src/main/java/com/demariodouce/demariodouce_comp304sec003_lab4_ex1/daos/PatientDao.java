package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.PatientEntity;

import java.util.List;

@Dao
public interface PatientDao {

    @Query("SELECT * FROM PatientEntity")
    LiveData<List<PatientEntity>> getAllPatients();

    @Insert
    void insert(PatientEntity patientEntity);

    @Update
    void updatePatient(PatientEntity patientEntity);

    @Delete
    void deletePatient(PatientEntity patientEntity);

    @Query("select * from PatientEntity where patientId = :id")
    LiveData<PatientEntity> loadPatient(int id);
}
