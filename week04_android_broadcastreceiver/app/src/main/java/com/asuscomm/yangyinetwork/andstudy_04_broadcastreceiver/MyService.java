package com.asuscomm.yangyinetwork.andstudy_04_broadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    private int idx = 0;
    private boolean cri = true;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String a = "1";
        switch (a){
            case "":
                break;
            default:
                //Log.i("jyp",intent);
                makeCry();
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void makeCry() {
        String msg;
        while (cri) {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (idx==0)
                msg = "안녕하세요 우쥬님";
            else {
                msg = idx + "";
            }
            Log.i("jyp", "jyp");
              Toast.makeText(MyService.this, msg, Toast.LENGTH_SHORT).show();

            idx++;
            if (idx == 30)
                cri = false;
        }
    }
}
