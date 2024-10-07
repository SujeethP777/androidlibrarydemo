package com.example.networkmodule;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class RetrofitClient {
    private static Context context = null;

    public static void setContext(Context context) {
        RetrofitClient.context = context;
    }

    private static String getBaseUrl(Context context) {
        if (context == null) {
            return "no-host";
        }

        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(
                    context.getPackageName(),
                    PackageManager.GET_META_DATA
            );
            Bundle bundle = applicationInfo.metaData;
            return bundle != null ? bundle.getString("com.androhub.retrofit.baseurl", "no-host") : "no-host";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "no-host";
        }
    }
}

