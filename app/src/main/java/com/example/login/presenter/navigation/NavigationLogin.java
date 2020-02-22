package com.example.login.presenter.navigation;

import android.app.Activity;

import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.login.R;
import com.example.login.view.fragment.ScreenWork;
import com.example.login.view.fragment.SingUP;
import com.example.login.view.fragment.SungUP;

public class NavigationLogin {

    private static AppCompatActivity activity;

    private final static Fragment singUP = new SingUP();
    private final static Fragment screenWord = new ScreenWork();
    private final static Fragment sungUP = new SungUP();

    private final static int content = R.id.screnn;


    public static void nextScreen(NavigationEnumFragmentLogin navigationEnumFragmentLogin)
    {
       FragmentTransaction fragment = activity.getSupportFragmentManager().beginTransaction();

        fragment.setCustomAnimations(R.animator.slide_left,R.animator.slide_right);

       switch (navigationEnumFragmentLogin)
       {
           case SINGUP: fragment.replace(content,singUP);;break;
           case SUNGUP: fragment.replace(content,sungUP);;break;
           case SCREENWORK: fragment.replace(content,screenWord);;break;
           default: break;
       }

       fragment.commit();
    }

    public static void firstStart()
    {
        activity.getSupportFragmentManager().beginTransaction()
                .add(content,singUP)
                .commit();
    }

    public static void setActivity(AppCompatActivity activity) {
        NavigationLogin.activity = activity;
    }
}
