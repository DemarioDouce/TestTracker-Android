package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

// this is a Room entity class to describe
// a database table
@Entity()
public class PatientEntity {
    @PrimaryKey(autoGenerate = true)
    private int patientId;
    private String firstname;
    private String lastname;
    private String department;
    private int nurseId;
    private String room;

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
    //Setters
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format ( "Id:%d\nFirstName:%s\nLastName:%s\nDepartment:%s\nRoom:%s",getPatientId (),getFirstname() ,getLastname (),getDepartment (),getRoom () );
    }
}
