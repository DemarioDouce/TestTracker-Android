package com.demariodouce.demariodouce_comp304sec003_lab4_ex1.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// this is a Room entity class to describe
// a database table
@Entity
public class NurseEntity {

    @PrimaryKey(autoGenerate = true)
    private int nurseId;
    private String firstName;
    private String lastName;
    private String department;
    private String password;

    //Getters
    public int getNurseId() {
        return nurseId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getPassword() {
        return password;
    }

    //Setters
    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
