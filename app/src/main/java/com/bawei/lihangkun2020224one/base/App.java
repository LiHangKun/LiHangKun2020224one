package com.bawei.lihangkun2020224one.base;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
            context=getApplicationContext();
    }
    public static   Context getContext(){
        return context;
    }
}
