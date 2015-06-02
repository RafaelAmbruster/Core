/*
 * Copyright (c) 2015. Property of Rafael Ambruster
 */

package ec.com.mobileinc.demo;

import android.app.Application;

public class DemoApplication extends Application {

    private static DemoApplication instance;


    public DemoApplication() {
        instance = this;
    }

    public static DemoApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();


    }


}
