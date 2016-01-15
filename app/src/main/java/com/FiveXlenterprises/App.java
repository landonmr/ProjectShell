package com.FiveXlenterprises;

import android.app.Application;

import com.FiveXlenterprises.manager.SharedPrefsManager;
import com.FiveXlenterprises.manager.TypefaceManager;
import com.FiveXlenterprises.retrofit.RestApiClient;

public class App extends Application {

    private static App mInstance;
    private static RestApiClient api;


    public static SharedPrefsManager getPreferencesManager() {
        return SharedPrefsManager.getInstance(mInstance);
    }

    public static App getInstance() {
        return mInstance;
    }

    public static RestApiClient getRestApiClient() {
        return api;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        api = new RestApiClient(this);

        // analytics init

        initFonts();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    private void initFonts() {
        TypefaceManager manager = TypefaceManager.getInstance(this);
    }
}
