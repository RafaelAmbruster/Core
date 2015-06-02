/*
 * Copyright (c) 2015. Property of Rafael Ambruster
 */

package ec.com.mobileinc.demo.log;

import java.util.Date;

import ec.com.mobileinc.demo.util.CustomDateFormat;

public class LogCat
        implements Log {

    public void error(String paramString1, String paramString2) {
        android.util.Log.e(paramString1, paramString2);
    }

    public void info(String paramString1, String paramString2) {
        android.util.Log.i(paramString1, paramString2);
    }

    public void warning(String paramString1, String paramString2) {
        android.util.Log.w(paramString1, paramString2);
    }

    public void wl(boolean paramBoolean) {
        if (paramBoolean) {
            android.util.Log.w("CPUWakeLock", CustomDateFormat.completeFormat(new Date()) + "  CPUWakeLock activated");
            return;
        }
        android.util.Log.i("CPUWakeLock", CustomDateFormat.completeFormat(new Date()) + "  CPUWakeLock deactivated");
    }
}
