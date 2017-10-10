package com.example.cnki6187.loginUtil;

import android.os.Message;
import android.util.Log;

import android.os.Handler;

/**
 * Created by cnki6187 on 2017/10/9.
 */

public class LoginThread implements Runnable {

    static final int WILL_SUC=1;
    static final int WILL_FAIL=0;
    Handler mainHandler;
    int sucOrFail;
    public LoginThread(Handler handler,int sof)
    {
        mainHandler=handler;
        sucOrFail=sof;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Message msg=mainHandler.obtainMessage();
        if(sucOrFail==WILL_SUC)
            msg.what=WILL_SUC;
        else
            msg.what=WILL_FAIL;
        mainHandler.sendMessage(msg);
    }
}
