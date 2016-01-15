package com.FiveXlenterprises.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.joda.time.DateTime;

public class SharedPrefsManager {
    private static final String TAG = SharedPrefsManager.class.getSimpleName();
    private static final String PREFS_FILE = "5XL";
    static final public String USERNAME = "prf_username";
    static final public String LAST_EVENT_LOG_AND_TIME_SYNC = "prf_last_evt_time_sync";

    public static final String READER_TYPE = "prf_reader_type";

    private SharedPreferences.Editor mEditor;
    private static SharedPrefsManager mSharedPrefsManager;
    private Context mAppContext;

    private SharedPreferences mPrefs;

    private SharedPrefsManager(Context appContext) {
        mAppContext = appContext;
        mPrefs = mAppContext.getSharedPreferences(PREFS_FILE,
                Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();
    }

    public static SharedPrefsManager getInstance(Context c) {
        if (mSharedPrefsManager == null) {
            mSharedPrefsManager = new SharedPrefsManager(c.getApplicationContext());
        }

        return mSharedPrefsManager;
    }

    public String getLastSyncTime() {
        return mPrefs.getString(LAST_EVENT_LOG_AND_TIME_SYNC, "");
    }

    public void setLastSyncTime(DateTime dt) {
        try {
            mEditor.putString(LAST_EVENT_LOG_AND_TIME_SYNC, dt.toString()).apply();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public String getUsername() {
        return mPrefs.getString(USERNAME, "");
    }

    public void setUsername(String username) {
        try {
            mEditor.putString(USERNAME, username).apply();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void resetUserPrefs() {

    }

    public void clearAllPrefs() {
        resetUserPrefs();
        mAppContext.getSharedPreferences(PREFS_FILE, 0).edit().clear().commit();
    }
}