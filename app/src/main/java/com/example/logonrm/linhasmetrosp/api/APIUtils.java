package com.example.logonrm.linhasmetrosp.api;

import android.util.Log;

/**
 * Created by logonrm on 21/06/2017.
 */

public class APIUtils {

    public static final String URL_BASE_CLIENTE = "http://10.3.1.17:3000";

    public static MetroAPI getAndroidApiService() {

        return RetrofitClient.getClient(URL_BASE_CLIENTE).create(MetroAPI.class);

    }
}
