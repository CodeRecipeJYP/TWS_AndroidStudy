package com.asuscom.yangyinetwork.andstudy_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ConstAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);

        Log.i("JYP","hihi");
    }

    public void onClick2(View view) {
        Log.i("JYP","hi");
    }
}
