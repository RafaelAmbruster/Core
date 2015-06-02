/*
 * Copyright (c) 2015. Property of Rafael Ambruster
 */

package ec.com.mobileinc.demo.log;

import com.orhanobut.logger.Logger;

import java.util.Date;

import ec.com.mobileinc.demo.util.CustomDateFormat;

public class LogCat
        implements Log {

    public void error(String paramString1, String paramString2) {

        Logger.t(paramString1).e(paramString2);
    }

    public void info(String paramString1, String paramString2) {

        Logger.t(paramString1).d(paramString2);
    }

    public void warning(String paramString1, String paramString2) {

        Logger.t(paramString1).w(paramString2);
    }

    public void wl(boolean paramBoolean) {
        if (paramBoolean) {
            //android.util.Log.w("CPUWakeLock", CustomDateFormat.completeFormat(new Date()) + "  CPUWakeLock activated");

            Logger.t("CPUWakeLock").d(CustomDateFormat.completeFormat(new Date()) + "  CPUWakeLock activated");
            return;
        }
        //android.util.Log.i("CPUWakeLock", CustomDateFormat.completeFormat(new Date()) + "  CPUWakeLock deactivated");

        Logger.t("CPUWakeLock").d(CustomDateFormat.completeFormat(new Date()) + "  CPUWakeLock deactivated");
    }


    public void json_format(String paramString1) {
        Logger.json(paramString1);
    }

    public void xml_format(String paramString1) {
        Logger.xml(paramString1);
    }
}

