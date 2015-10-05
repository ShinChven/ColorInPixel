package net.atlassc.ShinChven.colorinpixel.util;

import android.util.Log;
import net.atlassc.ShinChven.colorinpixel.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ShinChven on 14/8/29.
 * log 工具，使用此Log 工具可统一开启或者关闭打印log
 */
public class LogUtil {
    // TODO 发布release 时在此关闭log
    public static final boolean DEBUG = BuildConfig.DEBUG;
//    public static final boolean DEBUG = true;
    private static final String DEFAULT_TAG = "LinkWellOrderLog";

    public static void jsonObject(String tag, JSONObject obj) {
        if (DEBUG) {
            try {
                Log.i(tag, obj.toString(4));
            } catch (JSONException e) {
                printStackTrace(e);
            }
        }
    }

    public static void i(String tag, String msg) {
        if (DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void i(String msg) {
        if (DEBUG) {
            Log.i(DEFAULT_TAG, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void d(String msg) {
        if (DEBUG) {
            Log.d(DEFAULT_TAG, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void e(String msg) {
        if (DEBUG) {
            Log.e(DEFAULT_TAG, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (DEBUG) {
            Log.w(tag, msg);
        }
    }

    public static void w(String msg) {
        if (DEBUG) {
            Log.w(DEFAULT_TAG, msg);
        }
    }

    /**
     * 用于打印异常
     *
     * @param e
     */
    public static void printStackTrace(Exception e) {
        if (DEBUG) {
            e.printStackTrace();
        }
    }

    /**
     * 用于打印错误
     *
     * @param e
     */
    public static void printStackTrace(Error e) {
        if (DEBUG) {
            e.printStackTrace();
        }
    }
}
