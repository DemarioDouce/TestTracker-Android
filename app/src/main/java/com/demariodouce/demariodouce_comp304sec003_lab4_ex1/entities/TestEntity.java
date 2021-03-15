package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity()
public class TestEntity {

    @PrimaryKey(autoGenerate = true)
    private int testId;
    private int patientId;
    private String BPL;
    private String BPH ;
    private String temperature ;

    //Constructor
    public TestEntity( int patientId, String BPL, String BPH, String temperature)
    {
        this.patientId = patientId;
        this.BPH = BPL;
        this.BPL = BPH;
        this.temperature = temperature;
    }
    //Getters
    public int getTestId() {
        return testId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getBPL() {
        return BPL;
    }

    public String getBPH() {
        return BPH;
    }

    public String getTemperature() {
        return temperature;
    }

    //Setters
    public void setTestId(int testId) {
        this.testId = testId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setBPL(String BPL) {
        this.BPL = BPL;
    }

    public void setBPH(String BPH) {
        this.BPH = BPH;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format ( "TestId:%d\nBPL:%s\nBPH:%s\nTemperature:%s",getTestId (), getBPL (), getBPH (), getTemperature () );
    }
}
