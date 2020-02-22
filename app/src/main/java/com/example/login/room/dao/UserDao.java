package com.example.login.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.login.room.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user WHERE login = :login AND password = :password")
    User getUSer(String login, String password);

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

}
