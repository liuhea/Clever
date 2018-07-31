package com.liuhe.utils;

import android.support.annotation.Nullable;
import android.util.Log;

import com.example.lib_clever.BuildConfig;


/**
 * 打印log工具类
 *
 * @author liuhea
 * @created 16-11-24
 */
public class LogUtils {
    
    private LogUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isDebug = BuildConfig.DEBUG;
    private static final String TAG = "Clever--Log--";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        i(null, msg);
    }

    public static void d(String msg) {
        d(null, msg);
    }

    public static void e(String msg) {
        e(null, msg);
    }

    public static void v(String msg) {
        v(null, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(@Nullable String tag, String msg) {
        if (isDebug) {
            StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[3];
            if (tag == null) {
                Log.i(TAG, rebuildMsg(stackTraceElement, msg));
            } else {
                Log.i(TAG + tag, rebuildMsg(stackTraceElement, msg));
            }
        }
    }

    public static void d(@Nullable String tag, String msg) {
        if (isDebug) {
            StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[3];
            if (tag == null) {
                Log.d(TAG, rebuildMsg(stackTraceElement, msg));
            } else {
                Log.d(TAG + tag, rebuildMsg(stackTraceElement, msg));
            }
        }
    }

    public static void e(@Nullable String tag, String msg) {
        if (isDebug) {
            StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[3];
            if (tag == null) {
                Log.e(TAG, rebuildMsg(stackTraceElement, msg));
            } else {
                Log.e(TAG + tag, rebuildMsg(stackTraceElement, msg));
            }
        }
    }

    public static void v(@Nullable String tag, String msg) {
        if (isDebug) {
            StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[3];
            if (tag == null) {
                Log.v(TAG, rebuildMsg(stackTraceElement, msg));
            } else {
                Log.v(TAG + tag, rebuildMsg(stackTraceElement, msg));
            }
        }
    }

    /*
    * 重新组装log信息,加上类名,行数,方法名
    * */
    private static String rebuildMsg(StackTraceElement element, String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(element.getFileName());
        sb.append("(");
        sb.append(element.getLineNumber());
        sb.append(")");
        sb.append(element.getMethodName());
        sb.append(":");
        sb.append(msg);
        return sb.toString();
    }
}
