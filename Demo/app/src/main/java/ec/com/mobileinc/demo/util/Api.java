/*
 * Copyright (c) 2015. Property of Rafael Ambruster
 */

package ec.com.mobileinc.demo.util;

import android.annotation.SuppressLint;
import android.os.Build;

@SuppressLint("all")
public class Api {

    /**
     * Checks if build version is Gingerbread MR1
     *
     * @return true if build version is >= API 10
     */

    public static boolean hasGingerbreadMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1;
    }

    /**
     * Checks if build version is Honeycomb
     *
     * @return true if build version is >= API 11
     */
    public static boolean hasHoneycomb() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    /**
     * Checks if build version is Honeycomb MR1
     *
     * @return true if build version is >= API 12
     */
    public static boolean hasHoneycombMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
    }

    /**
     * Checks if build version is Ice Cream Sandwitch
     *
     * @return true if build version is >= API 14
     */
    public static boolean hasIceCreamSandwitch() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    }

    /**
     * Checks if build version is Jelly Bean
     *
     * @return true if build version is >= API 16
     */
    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    /**
     * Checks if build version is KitKat
     *
     * @return true if build version is >= API 19
     */
    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

}
