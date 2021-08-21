package com.example.priya.Data;


import android.graphics.Bitmap;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.priya.Model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void registeruser(User user);

    @Query("SELECT * from tbl_Users where username=(:username)  and password=(:password)")
    User login(String username,String password);

    @Query("SELECT * from tbl_Users")
   public List<User> getAlldata();


    @Delete
    void deleteuser(User user);

    @Update
    public void updateuser(User user);

    @Query("select * from tbl_users where id like :idx")
    public User getId(int idx);

    @Query("select * from tbl_Users")
    LiveData<List<User>> findallUsers();

@Query("select `captured image`from tbl_users where id = :id")
    Bitmap getProfileImg(int id);



}
