package com.example.login.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.login.R;
import com.example.login.presenter.navigation.NavigationEnumFragmentLogin;
import com.example.login.presenter.navigation.NavigationLogin;


public class ScreenWork extends Fragment implements View.OnClickListener{

    private Button back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_screen_work, container, false);
        back = v.findViewById(R.id.back);
        back.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back) NavigationLogin.nextScreen(NavigationEnumFragmentLogin.SINGUP);
    }
}
