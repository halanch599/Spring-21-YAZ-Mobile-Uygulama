package com.example.yaz_1_1.Respository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.yaz_1_1.DAO.DepartmentDao;
import com.example.yaz_1_1.Entities.Department;
import com.example.yaz_1_1.RoomDB.StudentRoomDB;

import java.util.List;

public class DepartmentRespository {

    private DepartmentDao departmentDao;
    private LiveData<List<Department>> liveDataDepartments;

    public DepartmentRespository(Application application){
        StudentRoomDB db =  StudentRoomDB.getInstance(application);
        departmentDao = db.getDepartmentDao();
        liveDataDepartments = departmentDao.getAllDepartments();
    }

    public LiveData<List<Department>> getAllDepartments()
    {
        return liveDataDepartments;
    }

    public LiveData<List<Department>> getDepartmentById(int id)
    {
      return   departmentDao.getDepartmentById(id);
    }

    public  LiveData<List<Department>> getDepartmentByName(String name)
    {
        return  getDepartmentByName(name);
    }

    public  void insert(Department department)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            departmentDao.insert(department);
        });

    }

    public void delete(Department department)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            departmentDao.delete(department);
        });
    }

    public  void deleteAll()
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            departmentDao.deleteAll();
        });
    }

    public void update(Department department)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            departmentDao.update(department);
        });

    }
}
