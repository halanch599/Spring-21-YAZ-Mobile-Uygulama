package com.example.yaz_1_1.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.yaz_1_1.Entities.Student;
import com.example.yaz_1_1.Respository.StudentRepository;
import com.example.yaz_1_1.RoomDB.StudentRoomDB;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {

    private StudentRepository studentRepository;
    private  LiveData<List<Student>> liveDataStudents;


    public StudentViewModel(@NonNull Application application) {
        super(application);

        studentRepository = new StudentRepository(application);
        liveDataStudents =  studentRepository.getAllStudents();

    }

    public LiveData<List<Student>> getAllStudents()
    {
        return liveDataStudents;
    }
    public LiveData<List<Student>> getStudentById(int id)
    {
        return studentRepository.getStudentById(id);
    }


    public  LiveData<List<Student>> getStudentByName(String name)
    {
        return studentRepository.getStudentByName(name);
    }

    public  void insert(Student student)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->
        {
            studentRepository.insert(student);
        });
    }

    public void delete(Student student)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->
        {
            studentRepository.delete(student);
        });
    }

    public  void deleteAll()
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->
        {
            studentRepository.deleteAll();
        });
    }

    public void update(Student student)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->
        {
            studentRepository.update(student);
        });
    }
}
