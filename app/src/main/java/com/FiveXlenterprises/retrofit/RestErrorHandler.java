package com.FiveXlenterprises.retrofit;

import android.util.Log;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RestErrorHandler implements ErrorHandler {
    private static final String TAG = RestErrorHandler.class.getSimpleName();

    @Override
    public Throwable handleError(RetrofitError cause) {
        Response response = cause.getResponse();

        if (response != null &&
                (cause.getKind() == RetrofitError.Kind.NETWORK || cause.getKind() == RetrofitError.Kind.HTTP)) {
            if (response.getStatus() == 401) {
                Log.e(TAG, "RetroFit Error Status 401");
            } else if (response.getStatus() == 403) {
                Log.e(TAG, "RetroFit Error Status 403");
            } else {
                Log.e(TAG, "RetroFit Error Status " + response.getStatus());
            }
        } else {
            Log.e(TAG, "RetroFit Error " + cause.getMessage());
        }

        return cause;
    }
}
