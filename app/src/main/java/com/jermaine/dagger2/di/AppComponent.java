package com.jermaine.dagger2.di;

import com.jermaine.dagger2.repository.RetrofitRepositoryImpl;
import com.jermaine.dagger2.view.MainPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Retrofit retrofit();

    RetrofitRepositoryImpl retrofitRepositoryImpl();

    void inject(MainPresenterImpl mainPresenter);

    void inject(RetrofitRepositoryImpl retrofitRepository);
}