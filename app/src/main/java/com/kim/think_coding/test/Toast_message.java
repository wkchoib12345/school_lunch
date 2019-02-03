package com.kim.think_coding.test;

import android.content.Context;
import android.widget.Toast;

public class Toast_message {
    public Toast_message(String toast, Context mContext){
        Toast.makeText(mContext, toast, Toast.LENGTH_LONG).show();
    }
}