/*
 * Copyright (c) 2015. Property of Rafael Ambruster
 */

package ec.com.mobileinc.demo.log;

import ec.com.mobileinc.demo.configuration.ConfigurationManager;

public class LogManager {
    private static LogManager singleton;
    private Log log = new DeviceLog();

    public synchronized static LogManager getInstance() {
        if (singleton == null) {
            singleton = new LogManager();
        }
        return singleton;
    }

    public void error(String paramString1, String paramString2) {
        if (ConfigurationManager.getInstance().isActiveLogs())
            this.log.error(paramString1, paramString2);
    }

    public void info(String paramString1, String paramString2) {
        if (ConfigurationManager.getInstance().isActiveLogs())
            this.log.info(paramString1, paramString2);
    }

    public void warning(String paramString1, String paramString2) {
        if (ConfigurationManager.getInstance().isActiveLogs())
            this.log.warning(paramString1, paramString2);
    }

    public void wl(boolean paramBoolean) {
        if (ConfigurationManager.getInstance().isActiveLogs())
            this.log.wl(paramBoolean);
    }
}
