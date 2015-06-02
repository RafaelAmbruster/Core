/*
 * Copyright (c) 2015. Property of Rafael Ambruster
 */

package ec.com.mobileinc.demo.util;

import android.content.Context;
import android.os.PowerManager;

import ec.com.mobileinc.demo.log.LogManager;

public class CPUWakeLock {

	private static Context context;
	private static PowerManager.WakeLock wakeLock;

	public static void activate() {
		if (wakeLock == null)
			wakeLock = ((PowerManager) context.getSystemService(Context.POWER_SERVICE))
					.newWakeLock(1, "CPUWakeLock");
		if (!isHeld()) {
			wakeLock.acquire();
			LogManager.getInstance().wl(true);
		}
	}

	public static Context getContext() {
		return context;
	}

	public static boolean isHeld() {
		return (wakeLock != null) && (wakeLock.isHeld());
	}

	public static void release() {
		if ((wakeLock != null) && (wakeLock.isHeld())) {
			wakeLock.release();
			LogManager.getInstance().wl(false);
		}
	}

	public static void setContext(Context paramContext) {
		context = paramContext;
	}

}
