package com.example.yaz_1_1.Respository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.yaz_1_1.DAO.StudentDao;
import com.example.yaz_1_1.Entities.Student;
import com.example.yaz_1_1.RoomDB.StudentRoomDB;

import java.util.List;

public class StudentRepository {
    private StudentDao studentDao;
    private LiveData<List<Student>> liveDataStudent;


    public  StudentRepository(Application application)
    {
        StudentRoomDB db = StudentRoomDB.getInstance(application);
        studentDao = db.getStudentDao();
        liveDataStudent =  studentDao.getAllStudents();
    }


    public LiveData<List<Student>> getStudentById(int id)
    {
        return studentDao.getStudentById(id);
    }


    public  LiveData<List<Student>> getStudentByName(String name)
    {
        return studentDao.getStudentByName(name);
    }

    public  void insert(Student student)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->
        {
            studentDao.insert(student);
        });
    }

    public void delete(Student student)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->
        {
            studentDao.delete(student);
        });
    }

    public  void deleteAll()
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->
        {
            studentDao.deleteAll();
        });
    }

    public void update(Student student)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->
        {
            studentDao.update(student);
        });
    }
}
