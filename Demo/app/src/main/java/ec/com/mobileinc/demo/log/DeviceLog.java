/*
 * Copyright (c) 2015. Property of Rafael Ambruster
 */

package ec.com.mobileinc.demo.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Date;

import ec.com.mobileinc.demo.configuration.ConfigurationManager;
import ec.com.mobileinc.demo.util.CustomDateFormat;

public class DeviceLog
        implements Log {

    private String createHtmlLogEntry(String paramString1, String paramString2, String paramString3) {
        return "<div style=\"background-color:" + paramString1 + "; " + "border-color:#888888; " + "border-width:1px; " + "border-style:solid; " + "padding:5px; " + "margin:5px; " + "color:#383838;\">" + "<b><pre>[" + scapeHtml(paramString2) + "]</pre></b>" + " <pre>" + scapeHtml(paramString3) + "</pre></div>";
    }

    private String scapeHtml(String paramString) {
        return paramString.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }

    private void write(String paramString1, String paramString2, String paramString3, String paramString4) {
        File localFile = new File(paramString2);
        if (localFile.exists())
            try {
                BufferedReader localBufferedReader = new BufferedReader(new FileReader(localFile));
                char[] arrayOfChar = new char[(int) localFile.length()];
                localBufferedReader.read(arrayOfChar);
                localBufferedReader.close();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(arrayOfChar);
                String str = localStringBuilder.toString() + createHtmlLogEntry(paramString1, paramString3, paramString4);
                PrintStream localPrintStream2 = new PrintStream(localFile);
                localPrintStream2.append(str);
                localPrintStream2.flush();
                localPrintStream2.close();
                return;
            } catch (Exception localException2) {
                localException2.printStackTrace();
                return;
            }
        try {
            PrintStream localPrintStream1 = new PrintStream(localFile);
            localPrintStream1.append(createHtmlLogEntry(paramString1, paramString3, paramString4));
            localPrintStream1.flush();
            localPrintStream1.close();
            return;
        } catch (Exception localException1) {
            localException1.printStackTrace();
        }
    }

    public void error(String paramString1, String paramString2) {
        write("#f9d6d6", ConfigurationManager.getInstance().getPath(4) + "e_log.html", paramString1, paramString2);
    }

    public void info(String paramString1, String paramString2) {
        write("#d7f9d6", ConfigurationManager.getInstance().getPath(4) + "i_log.html", paramString1, paramString2);
    }

    public void warning(String paramString1, String paramString2) {
        write("#f8f9d6", ConfigurationManager.getInstance().getPath(4) + "w_log.html", paramString1, paramString2);
    }

    public void wl(boolean paramBoolean) {
        String str = ConfigurationManager.getInstance().getPath(4) + "wl_log.html";
        if (paramBoolean) {
            write("#f8f9d6", str, CustomDateFormat.completeFormat(new Date()), "Activated");
            return;
        }
        write("#d7f9d6", str, CustomDateFormat.completeFormat(new Date()), "Deactivated");
    }
}

