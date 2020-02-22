package com.example.login.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.presenter.navigation.NavigationEnumFragmentLogin;
import com.example.login.presenter.navigation.NavigationLogin;
import com.example.login.room.app.App;
import com.example.login.room.database.AppDataBase;
import com.example.login.room.entity.User;
import com.example.login.util.ToastUtil;


public class SungUP extends Fragment implements View.OnClickListener{

    private AppDataBase dataBase;

    private Button singUpButton;
    private Button backButton;

    private EditText loginEdit;
    private EditText passwordEdit;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        dataBase = App.getRoomComponent().getAppDataBase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sung_u, container, false);

        singUpButton = v.findViewById(R.id.enter);
        backButton = v.findViewById(R.id.back);
        loginEdit = v.findViewById(R.id.login);
        passwordEdit = v.findViewById(R.id.password);

        singUpButton.setOnClickListener(this);
        backButton.setOnClickListener(this);


        return v;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.back) NavigationLogin.nextScreen(NavigationEnumFragmentLogin.SINGUP);
        if (id == R.id.enter) singUP();
    }

    private void singUP()
    {
        final String login = loginEdit.getText().toString();
        final String password = passwordEdit.getText().toString();


        new Thread(new Runnable() {
            @Override
            public void run() {
                final User user = new User();
                user.setLogin(login);
                user.setPassword(password);
                dataBase.userDao().insert(user);
            }
        }).start();


        ToastUtil.showText(getContext(),"Пользоваеть создан");
        NavigationLogin.nextScreen(NavigationEnumFragmentLogin.SINGUP);
    }
}
