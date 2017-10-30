package io.module;

import android.app.Application;

import io.module.core.NeoModule;

/**
 * @author kiva
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NeoModule.init(this);
    }
}
