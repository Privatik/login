package com.example.login.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.login.R;
import com.example.login.di.component.RoomComponent;
import com.example.login.di.module.ContextModule;
import com.example.login.presenter.navigation.NavigationLogin;
import com.example.login.room.database.AppDataBase;
import com.example.login.view.fragment.SingUP;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivitu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null)
        {
                NavigationLogin.setActivity(this);
                NavigationLogin.firstStart();
        }
    }
}
