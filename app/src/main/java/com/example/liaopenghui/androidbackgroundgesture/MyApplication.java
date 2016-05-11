package com.example.liaopenghui.androidbackgroundgesture;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by liaopenghui on 16/5/11.
 */
public class MyApplication  extends Application{

    private static final String TAG = "MyApplication";
    private int activityCount = 0;
    public boolean isBackgroud = false;
    public static boolean showGuestrue = false;
    private Timer timer;

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.e(TAG,activity.getLocalClassName().toString()+"onActivityStarted");
                activityCount++;
                if(null!=timer){
                    timer.cancel();
                    timer=null;
                }

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.e(TAG,activity.getLocalClassName().toString()+"onActivityStopped");
                activityCount--;
                if(activityCount==0){
                    Toast.makeText(MyApplication.this, "我在后台啦~~~~~", Toast.LENGTH_SHORT).show();
                     timer = new Timer();
                    TimerTask task = new TimerTask() {

                        @Override
                        public void run() {
                            showGuestrue = true;
                            Log.e(TAG,"要跳手势了");
                        }
                    };
                    timer.schedule(task,6000);
                }
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
