package com.example.login.di.module;

import android.content.Context;

import androidx.room.Room;

import com.example.login.room.database.AppDataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class RoomModule {

    @Provides
    public AppDataBase appDataBase(Context context)
    {
        return Room.databaseBuilder(context,AppDataBase.class,"database").build();
    }
}
