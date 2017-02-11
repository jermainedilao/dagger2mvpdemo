package com.jermaine.dagger2.repository;


import com.jermaine.dagger2.api.ApiService;
import com.jermaine.dagger2.api.response.ApiResponse;
import com.jermaine.dagger2.di.AppComponent;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitRepositoryImpl implements RetrofitRepository {

    @Inject
    Retrofit mRetrofit;

    public RetrofitRepositoryImpl(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    public void getRepos(final OnFetchReposCallback onFetchReposCallback) {
        ApiService apiService = mRetrofit.create(ApiService.class);

        Call<List<ApiResponse>> call = apiService.getRepos();
        call.enqueue(new Callback<List<ApiResponse>>() {
            @Override
            public void onResponse(Call<List<ApiResponse>> call, Response<List<ApiResponse>> response) {
                onFetchReposCallback.onFetchReposCallback(response.body());
            }

            @Override
            public void onFailure(Call<List<ApiResponse>> call, Throwable t) {
                onFetchReposCallback.onFetchReposCallback(null);
            }
        });
    }
}
