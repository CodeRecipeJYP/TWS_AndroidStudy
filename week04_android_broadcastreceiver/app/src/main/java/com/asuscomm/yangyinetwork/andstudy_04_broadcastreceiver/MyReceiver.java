package com.asuscomm.yangyinetwork.andstudy_04_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // throw new UnsupportedOperationException("Not yet implemented"); <- 오류 만드는 코드임
        if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            openService(context);
        }
//        switch (intent.getAction()){
//            case Intent.ACTION_BOOT_COMPLETED:
//                openService(context);
//                break;
//        }
    }

    private void openMainactivity(Context context){
        Intent intent1 = new Intent(context, MainActivity.class);
        context.startActivity(intent1);
    }

    private void openService(Context context){
        Intent intent1 = new Intent(context, MyService.class);
        context.startService(intent1);
    }
}
