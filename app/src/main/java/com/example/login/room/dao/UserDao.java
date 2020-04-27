package com.example.login.room.dao;

import android.database.Cursor;

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

    @Query("SELECT * FROM user")
    Cursor getTadble();

    @Query("SELECT * FROM user WHERE id = :id")
    Cursor getTadbleItem(long id);

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

}
