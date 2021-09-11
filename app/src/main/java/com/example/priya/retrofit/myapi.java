package com.example.priya.retrofit;

import com.example.priya.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myapi {
@GET("posts")
        Call<List<Model>> getmodel();
}
