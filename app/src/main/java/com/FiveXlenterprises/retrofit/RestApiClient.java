package com.FiveXlenterprises.retrofit;

import android.content.Context;

import com.FiveXlenterprises.retrofit.service.UserService;

import retrofit.RestAdapter;

public class RestApiClient {
    private static final String TAG = RestApiClient.class.getSimpleName();

    private static final String RELEASE_API = " https://api.xyz.com";
    private static final String DEBUG_API = " https://staging-api.xyz.com";
    private static String BASE_URL;

    private boolean mKeyRegistered;
    private UserService mUserService;


    public RestApiClient(Context context) {
    }

    private void setupHttpClient(RestAdapter.Builder builder) {

    }

    private void setupJsonAdapter(RestAdapter.Builder builder) {

    }

    public UserService getUserService() {
        return mUserService;
    }

}
