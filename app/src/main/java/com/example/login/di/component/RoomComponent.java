package com.example.login.di.component;

import com.example.login.di.module.RoomModule;
import com.example.login.room.database.AppDataBase;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = RoomModule.class)
@Singleton
public interface RoomComponent {
    AppDataBase getAppDataBase();
}
