package com.asuscomm.yangyinetwork.andstudy_04_broadcastreceiver;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openService(this);
    }

    private void openService(Context context){
        Intent intent1 = new Intent(context, MyService.class);
        context.startService(intent1);
    }
}
