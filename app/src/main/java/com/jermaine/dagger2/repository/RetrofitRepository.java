package com.jermaine.dagger2.repository;


public interface RetrofitRepository {
    void getRepos(OnFetchReposCallback onFetchReposCallback);
}
