package com.asuscomm.yangyinetwork.andstudy_04_broadcastreceiver;

import android.app.Application;

/**
 * Created by jaeyoung on 2017. 2. 26..
 */

public class BroadCastAndService extends Application {
    public static boolean serviceOn;
    @Override
    public void onCreate() {
        super.onCreate();
        // 하나라도 켜지면
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        // 모두 꺼지면
    }
}
