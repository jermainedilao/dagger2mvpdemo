package com.jermaine.dagger2.view;


import com.jermaine.dagger2.api.response.ApiResponse;

import java.util.List;

public interface MainPresenterContract {
    interface MainPresenter {
        void setView(MainView mainView);
    }

    interface MainView {
        void initializeRecyclerView();

        void bindRepos(List<ApiResponse> repos);

        void showToast(String text);

        void showProgressDialog();

        void dismissProgressDialog();
    }
}
