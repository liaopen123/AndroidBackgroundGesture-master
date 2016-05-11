package com.example.liaopenghui.androidbackgroundgesture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Pony on 2016/5/11.
 */
public class BaseActivity extends Activity {


    @Override
    protected void onResume() {
        super.onResume();
        if(MyApplication.showGuestrue){
            Intent intent =  new Intent(BaseActivity.this,GestureActivity.class);
            startActivity(intent);
            MyApplication.showGuestrue =false;
        }
    }
}
