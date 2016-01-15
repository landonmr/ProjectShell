package com.FiveXlenterprises.retrofit.service;

import com.FiveXlenterprises.models.Photo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface UserService {

    @GET("/user/photos/")
    void getPhotos(Callback<List<Photo>> callback);
}
