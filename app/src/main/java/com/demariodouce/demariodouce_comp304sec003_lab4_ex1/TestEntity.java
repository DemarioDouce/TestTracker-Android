package com.demariodouce.demariodouce_comp304sec003_lab4_ex1;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "TestTable", foreignKeys = {
        @ForeignKey(entity = NurseEntity.class,
                parentColumns = "nurseId",
                childColumns = "nurseId"),
        @ForeignKey(entity = PatientEntity.class,
        parentColumns = "patientId",
        childColumns = "patientId")})
public class TestEntity {

    //Variables
    @PrimaryKey(autoGenerate = true)
    private  int testId;
    private  int patientId;
    private  int nurseId;
    private String BPL;
    private  String BPH;
    private String temperature;

    //Constructor
    public TestEntity( String BPL, String BPH, String temperature) {
        this.BPL = BPL;
        this.BPH = BPH;
        this.temperature = temperature;
    }

    //Setters
    public void setTestId(int testId) {
        this.testId = testId;
    }

    //Getters
    public int getTestId() {
        return testId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getNurseId() {
        return nurseId;
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
}
