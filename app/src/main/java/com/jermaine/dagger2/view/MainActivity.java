package com.jermaine.dagger2.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jermaine.dagger2.App;
import com.jermaine.dagger2.R;
import com.jermaine.dagger2.api.response.ApiResponse;
import com.jermaine.dagger2.di.AppComponent;
import com.jermaine.dagger2.view.adapter.ReposAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainPresenterContract.MainView {

    private MainPresenterImpl mMainPresenter;
    private ReposAdapter mAdapter;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mMainPresenter = new MainPresenterImpl(getAppComponent());
        mMainPresenter.setView(this);
    }

    @Override
    public void initializeRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void bindRepos(List<ApiResponse> repos) {
        if (mAdapter == null) {
            mAdapter = new ReposAdapter(repos);
            mRecyclerView.setAdapter(mAdapter);

            return;
        }
        mAdapter.updateData(repos);
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("Fetching repos...");
        }
        mProgressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    private AppComponent getAppComponent() {
        return ((App) getApplication()).getAppComponent();
    }

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
}
