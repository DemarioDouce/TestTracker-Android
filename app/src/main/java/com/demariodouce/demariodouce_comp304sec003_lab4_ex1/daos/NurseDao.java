package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.NurseEntity;

import java.util.List;

// this interface declares database functions
// and does the mapping of SQL queries to functions
@Dao
public interface NurseDao {
    //
    @Insert
    void insert(NurseEntity nurseEntity);
    //Monitoring Query Result Changes with Live Data
    @Query("select * from NurseEntity order by firstName")
    LiveData<List<NurseEntity>> getAllNurses();
    //Login
    @Query("SELECT * FROM NurseEntity where NurseEntity.nurseId= :nurseId and NurseEntity.password= :password")
    LiveData<NurseEntity>  getNurse(int nurseId, String password);
}
