package com.example.yaz_1_1.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.yaz_1_1.Entities.Department;
import com.example.yaz_1_1.Entities.Student;

import java.util.List;

@Dao
public interface DepartmentDao {
    @Query("SELECT * FROM Department")
    public LiveData<List<Department>> getAllDepartments();

    @Query("SELECT * FROM Department WHERE DepartmentID = :id")
    public LiveData<List<Department>> getDepartmentById(int id);

    @Query("SELECT * FROM Department WHERE Name LIKE :name  ORDER BY Name")
    public  LiveData<List<Department>> getDepartmentByName(String name);

    @Insert
    public  void insert(Department department);

    @Delete
    public void delete(Department department);

    @Query("DELETE FROM Department")
    public  void deleteAll();

    @Update
    public void update(Department department);
}
