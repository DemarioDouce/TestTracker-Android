package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.daos.PatientDao;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.daos.TestDao;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.PatientEntity;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.TestEntity;

//Room database class
@Database(entities = {TestEntity.class}, version = 1)
public abstract class TestDatabase extends RoomDatabase {
    //
    private static volatile TestDatabase INSTANCE;
    private static final String DATABASE_NAME = "TestDB";
    public abstract TestDao testDao();
    //
    public static synchronized TestDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            //Create database object
            INSTANCE = Room.databaseBuilder(context,
                    TestDatabase.class, DATABASE_NAME).build();
        }
        return INSTANCE;
    }
}