package com.example.yaz_1_1.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Department {

    @PrimaryKey(autoGenerate = true)
    int DepartmentID;
    String Name;

    public Department() {
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int departmentID) {
        DepartmentID = departmentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
