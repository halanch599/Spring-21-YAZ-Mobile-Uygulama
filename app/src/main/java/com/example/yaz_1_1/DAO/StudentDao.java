package com.example.yaz_1_1.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.yaz_1_1.Entities.Student;

import java.util.List;

@Dao
public interface StudentDao {
    @Query("SELECT * FROM Student")
    public LiveData<List<Student>> getAllStudents();

    @Query("SELECT * FROM Student WHERE studentID = :id")
    public LiveData<List<Student>> getStudentById(int id);


    @Query("SELECT * FROM Student WHERE First_Name LIKE :name OR Last_Name LIKE :name ORDER BY First_Name, Last_Name")
    public  LiveData<List<Student>> getStudentByName(String name);

//    @Insert
//    public  void insert(Student student);

    @Insert
    public  void insert(Student... student);

    @Delete
    public void delete(Student student);

    @Query("DELETE FROM Student")
    public  void deleteAll();

    @Update
    public void update(Student... student);

}
