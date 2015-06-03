/*
 * Copyright (c) 2015. Property of Rafael Ambruster
 */

package ec.com.mobileinc.demo;

import android.app.Application;
import com.orhanobut.logger.Logger;

public class DemoApplication extends Application {

    private static DemoApplication instance;
    public static String TAG = "Demo";

    public DemoApplication() {
        instance = this;
    }

    public static DemoApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("Demo Application").hideThreadInfo().setMethodCount(3).setMethodOffset(2);


    }


}
