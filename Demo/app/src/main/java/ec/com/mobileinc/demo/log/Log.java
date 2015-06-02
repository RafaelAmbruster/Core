/*
 * Copyright (c) 2015. Property of Rafael Ambruster
 */

package ec.com.mobileinc.demo.log;

public interface Log {

    void error(String paramString1, String paramString2);

    void info(String paramString1, String paramString2);

    void warning(String paramString1, String paramString2);

    void wl(boolean paramBoolean);
}

