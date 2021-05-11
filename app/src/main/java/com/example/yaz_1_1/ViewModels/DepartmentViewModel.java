package com.example.yaz_1_1.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.yaz_1_1.Entities.Department;
import com.example.yaz_1_1.Respository.DepartmentRespository;
import com.example.yaz_1_1.RoomDB.StudentRoomDB;

import java.util.List;

public class DepartmentViewModel extends AndroidViewModel {

    private DepartmentRespository departmentRespository;
    private LiveData<List<Department>> liveDataDepartments;

    public DepartmentViewModel(@NonNull Application application) {
        super(application);

        departmentRespository = new DepartmentRespository(application);
        liveDataDepartments = departmentRespository.getAllDepartments();
    }

    public LiveData<List<Department>> getAllDepartments()
    {
        return liveDataDepartments;
    }

    public LiveData<List<Department>> getDepartmentById(int id)
    {
        return   departmentRespository.getDepartmentById(id);
    }

    public  LiveData<List<Department>> getDepartmentByName(String name)
    {
        return  getDepartmentByName(name);
    }

    public  void insert(Department department)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            departmentRespository.insert(department);
        });

    }

    public void delete(Department department)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            departmentRespository.delete(department);
        });
    }

    public  void deleteAll()
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            departmentRespository.deleteAll();
        });
    }

    public void update(Department department)
    {
        StudentRoomDB.databaseWriteExecutor.execute(()->{
            departmentRespository.update(department);
        });

    }
}
