package com.jermaine.dagger2;


import android.app.Application;

import com.jermaine.dagger2.di.AppComponent;
import com.jermaine.dagger2.di.AppModule;
import com.jermaine.dagger2.di.DaggerAppComponent;

public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }
}
