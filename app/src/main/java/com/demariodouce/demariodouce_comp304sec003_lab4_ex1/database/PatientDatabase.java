package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.daos.PatientDao;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.PatientEntity;

//Room database class
@Database(entities = {PatientEntity.class}, version = 1)
public abstract class PatientDatabase extends RoomDatabase {
    //
    private static volatile PatientDatabase INSTANCE;
    private static final String DATABASE_NAME = "PatientDB";
    public abstract PatientDao patientDao();
    //
    public static synchronized PatientDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            //Create database object
            INSTANCE = Room.databaseBuilder(context,
                    PatientDatabase.class, DATABASE_NAME).build();
        }
        return INSTANCE;
    }
}
