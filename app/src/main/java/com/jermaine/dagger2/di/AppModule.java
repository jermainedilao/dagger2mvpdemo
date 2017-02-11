package com.jermaine.dagger2.di;


import android.app.Application;

import com.google.gson.Gson;
import com.jermaine.dagger2.App;
import com.jermaine.dagger2.repository.RetrofitRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Gson providesGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    RetrofitRepositoryImpl provideRetrofitRepository(){
        return new RetrofitRepositoryImpl(((App) mApplication).getAppComponent());
    }
}
