package com.example.login.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
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


public class SingUP extends Fragment implements View.OnClickListener{

    private final String TAG = "SingUP";

    private AppDataBase dataBase;

    private Button singUPButton;
    private Button sungUPButton;

    private EditText loginEdit;
    private EditText passwordEdit;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBase = App.getRoomComponent().getAppDataBase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sing_u, container, false);

        singUPButton = view.findViewById(R.id.singup);
        sungUPButton = view.findViewById(R.id.sungup);
        loginEdit = view.findViewById(R.id.login);
        passwordEdit = view.findViewById(R.id.password);

            singUPButton.setOnClickListener(this);
            sungUPButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.sungup) sungUP();
        else if (id == R.id.singup) singUP();
    }

    private void singUP()
    {
        final String login = loginEdit.getText().toString();
        final String password = passwordEdit.getText().toString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final User user = dataBase.userDao().getUSer(login, password);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (user != null) {
                            Log.d(TAG,"not null");
                            NavigationLogin.nextScreen(NavigationEnumFragmentLogin.SCREENWORK);
                        } else {
                            ToastUtil.showText(getContext(),"Такого пользователя нет");
                        }
                    }
                });
            }
        }).start();

    }

    private void sungUP()
    {
        NavigationLogin.nextScreen(NavigationEnumFragmentLogin.SUNGUP);
    }
}
