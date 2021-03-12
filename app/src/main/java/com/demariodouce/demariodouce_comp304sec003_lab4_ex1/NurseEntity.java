package com.demariodouce.demariodouce_comp304sec003_lab4_ex1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "NurseTable")
public class NurseEntity {

    //Variables
    @PrimaryKey(autoGenerate = true)
    private int nurseId;
    private String firstname;
    private String lastname;
    private String department;
    private String password;

    //Constructor
    public NurseEntity( String firstname, String lastname, String department, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.password = password;
    }

    //Setters
    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    //Getters
    public int getNurseId() {
        return nurseId;
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

    public String getPassword() {
        return password;
    }
}
