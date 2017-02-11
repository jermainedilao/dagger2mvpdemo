package com.jermaine.dagger2.api;


import com.jermaine.dagger2.api.response.ApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/users/JakeWharton/repos")
    Call<List<ApiResponse>> getRepos();
}