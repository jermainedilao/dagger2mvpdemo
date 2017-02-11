package com.jermaine.dagger2.repository;


import com.jermaine.dagger2.api.response.ApiResponse;

import java.util.List;

public interface OnFetchReposCallback {
    void onFetchReposCallback(List<ApiResponse> apiResponses);
}
