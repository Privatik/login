package com.example.login.room.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.login.room.dao.UserDao;
import com.example.login.room.entity.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();
}
