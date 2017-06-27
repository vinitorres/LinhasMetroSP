package com.example.logonrm.linhasmetrosp;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by logonrm on 26/06/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
