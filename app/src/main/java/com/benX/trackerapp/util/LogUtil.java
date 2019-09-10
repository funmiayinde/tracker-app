package com.benX.trackerapp.util;

import android.util.Log;

/**
 * Created by funmiayinde on 2019-09-09.
 */
public class LogUtil {

    private static final String TAG = LogUtil.class.getSimpleName();

    public static void w(String msg) {
        Log.e(TAG, msg);
    }

    public static void w(String tag, String msg) {
        Log.e(tag, msg);
    }
}
