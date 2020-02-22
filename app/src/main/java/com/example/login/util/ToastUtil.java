package com.example.login.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    public static void showText(Context context,String text)
    {
        Toast.makeText(context,text,Toast.LENGTH_LONG).show();
    }
}
