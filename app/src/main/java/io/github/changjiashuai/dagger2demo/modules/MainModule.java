package io.github.changjiashuai.dagger2demo.modules;

import android.app.Application;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.changjiashuai.dagger2demo.DemoApplication;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/2/20 17:02.
 * Main Module 提供Application resources.
 */
@Module
public class MainModule {
    private final DemoApplication mApp;

    public MainModule(DemoApplication application){
        mApp = application;
    }

    @Provides
    @Singleton
    protected Application provideApplication(){
        return mApp;
    }

    @Provides
    @Singleton
    protected Resources provideResources(){
        return mApp.getResources();
    }
}
