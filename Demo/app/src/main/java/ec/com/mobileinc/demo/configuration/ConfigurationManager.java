/*
 * Copyright (c) 2015. Property of Rafael Ambruster
 */

package ec.com.mobileinc.demo.configuration;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.SparseArray;

import java.io.File;
import java.io.IOException;

import ec.com.mobileinc.demo.DemoApplication;

public class ConfigurationManager {

    private static final String FOLDER_NAME = "/"+DemoApplication.TAG+"/";
    private SparseArray<String> paths = new SparseArray<String>();
    private static ConfigurationManager singleton;
    private boolean activeLogs = true;
    private int timeout;

    private ConfigurationManager() {
        this.paths.put(1, Environment.getExternalStorageDirectory()
                .getAbsolutePath() + FOLDER_NAME);
        this.paths.put(2, Environment.getExternalStorageDirectory()
                .getAbsolutePath() + FOLDER_NAME + "photos/");
        this.paths.put(3,
                "/data/data/ec.com.mobileinc.demo/databases/");
        this.paths.put(4, Environment.getExternalStorageDirectory()
                .getAbsolutePath() + FOLDER_NAME + "logs/");
        this.paths.put(5, Environment.getExternalStorageDirectory()
                .getAbsolutePath() + FOLDER_NAME + "temp/");

    }

    public synchronized static ConfigurationManager getInstance() {
        if (singleton == null) {
            singleton = new ConfigurationManager();
        }
        return singleton;
    }


    public String getPath(int paramInt) {
        String str = this.paths.get(paramInt, "");
        if (str.length() > 0) {
            File localFile = new File(str);
            if (!localFile.exists())
                localFile.mkdirs();
        }
        try {
            new File(str + DemoApplication.TAG).createNewFile();
            return str;
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
        return str;
    }

    public void load(Context paramContext) {
        SharedPreferences localSharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(paramContext);
        this.activeLogs = localSharedPreferences
                .getBoolean("activeLogs", false);
        this.timeout = localSharedPreferences.getInt("timeout", 30000);

    }

    public void save(Context paramContext) {
        SharedPreferences.Editor localEditor = PreferenceManager
                .getDefaultSharedPreferences(paramContext).edit();
        localEditor.putBoolean("activeLogs", this.activeLogs);
        localEditor.putInt("timeout", this.timeout);

        localEditor.commit();
    }

    public boolean isActiveLogs() {
        return activeLogs;
    }



}
