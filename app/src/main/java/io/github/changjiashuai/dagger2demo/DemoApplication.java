package io.github.changjiashuai.dagger2demo;

import android.app.Application;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/2/20 17:04.
 */
public class DemoApplication extends Application {
    private static DemoGraph mDemoGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        mDemoGraph = DemoComponent.Initializer.init(this);
    }

    public static DemoGraph component(){
        return mDemoGraph;
    }
}
