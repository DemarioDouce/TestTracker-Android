package com.demariodouce.demariodouce_comp304sec003_lab4_ex1;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "PatientTable", foreignKeys = {
        @ForeignKey(entity = NurseEntity.class,
                parentColumns = "nurseId",
                childColumns = "nurseId")})

public class PatientEntity {

    //Variables
    @PrimaryKey (autoGenerate = true)
    private  int patientId;
    private  String firstname;
    private  String lastname;
    private  String department;
    private  int nurseId;
    private  String room;

    //Constructor
    public PatientEntity(String firstname, String lastname, String department, String room) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.room = room;
    }

    //Setters
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    //Getters
    public int getPatientId() {
        return patientId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDepartment() {
        return department;
    }

    public int getNurseId() {
        return nurseId;
    }

    public String getRoom() {
        return room;
    }
}
