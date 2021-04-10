package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    /*Create Insert Query*/
    @Insert
    public void insertStudent(Student student);

    @Delete
    public void deleteStudent(Student student);

    @Query("select * from studentinfo")
    public List<Student> readData();

    @Update
    public void updateStudent(Student student);
}
