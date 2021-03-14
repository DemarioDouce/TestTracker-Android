package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.daos.NurseDao;
import com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities.NurseEntity;

//Room database class
@Database(entities = {NurseEntity.class}, version = 1)
public abstract class NurseDatabase extends RoomDatabase {
    //
    private static volatile NurseDatabase INSTANCE;
    private static final String DATABASE_NAME = "NurseDB";
    public abstract NurseDao nurseDao();
    //
    public static synchronized NurseDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            //Create database object
            INSTANCE = Room.databaseBuilder(context,
                    NurseDatabase.class, DATABASE_NAME).build();
        }
        return INSTANCE;
    }
}
