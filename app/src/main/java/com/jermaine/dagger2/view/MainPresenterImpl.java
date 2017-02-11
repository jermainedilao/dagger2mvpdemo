package com.jermaine.dagger2.view;


import com.jermaine.dagger2.api.response.ApiResponse;
import com.jermaine.dagger2.di.AppComponent;
import com.jermaine.dagger2.repository.OnFetchReposCallback;
import com.jermaine.dagger2.repository.RetrofitRepositoryImpl;

import java.util.List;

import javax.inject.Inject;

public class MainPresenterImpl implements MainPresenterContract.MainPresenter {

    @Inject
    RetrofitRepositoryImpl mRetrofitRepository;

    private MainPresenterContract.MainView mMainView;

    public MainPresenterImpl(AppComponent appComponent) {
        appComponent.inject(this);
    }

    @Override
    public void setView(final MainPresenterContract.MainView mainView) {
        mMainView = mainView;

        mMainView.initializeRecyclerView();

        mMainView.showProgressDialog();
        mRetrofitRepository.getRepos(new OnFetchReposCallback() {
            @Override
            public void onFetchReposCallback(List<ApiResponse> apiResponses) {
                if (apiResponses == null) {
                    mMainView.showToast("Failed to fetch repos.");
                } else {
                    mMainView.bindRepos(apiResponses);
                }
                mMainView.dismissProgressDialog();
            }
        });
    }
}
