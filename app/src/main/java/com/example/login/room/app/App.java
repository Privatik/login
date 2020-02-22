package com.example.login.room.app;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import com.example.login.di.component.DaggerRoomComponent;
import com.example.login.di.component.RoomComponent;
import com.example.login.di.module.ContextModule;
import com.example.login.room.database.AppDataBase;
import com.example.login.view.activity.MainActivity;

public class App extends AppCompatActivity {

    private static RoomComponent roomComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inazial();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void inazial()
    {
         roomComponent = DaggerRoomComponent.builder()
             .contextModule(new ContextModule(this))
                .build();
    }

    public static RoomComponent getRoomComponent() {
        return roomComponent;
    }
}
