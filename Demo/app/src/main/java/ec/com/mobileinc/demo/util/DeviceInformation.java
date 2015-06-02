/*
 * Copyright (c) 2015. Property of Rafael Ambruster
 */

package ec.com.mobileinc.demo.util;


import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import ec.com.mobileinc.demo.log.LogManager;


public class DeviceInformation {


    //"phone"
    public String getImei(Context paramContext) {
        try {
            String str = ((TelephonyManager) paramContext
                    .getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();

            return str;
        } catch (Exception localException) {
            LogManager.getInstance().error(getClass().getCanonicalName(),
                    localException.getMessage());
        }
        return "";
    }

    public String getLineNumber(Context paramContext) {
        try {
            String str = ((TelephonyManager) paramContext
                    .getSystemService(Context.TELEPHONY_SERVICE)).getLine1Number();
            return str;
        } catch (Exception localException) {
            LogManager.getInstance().error(getClass().getCanonicalName(),
                    localException.getMessage());
        }
        return "";
    }

    public String getSdkVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public String getSimSerialNumber(Context paramContext) {
        try {
            String str = ((TelephonyManager) paramContext
                    .getSystemService(Context.TELEPHONY_SERVICE)).getSimSerialNumber();
            return str;
        } catch (Exception localException) {
            LogManager.getInstance().error(getClass().getCanonicalName(),
                    localException.getMessage());
        }
        return "";
    }

    public String getMacAddress(Context context) {

        try {
            WifiManager wimanager = (WifiManager) context
                    .getSystemService(Context.WIFI_SERVICE);
            String str = wimanager.getConnectionInfo().getMacAddress();

            return str;
        } catch (Exception localException) {
            LogManager.getInstance().error(getClass().getCanonicalName(),
                    localException.getMessage());
        }
        return "";

    }

}
