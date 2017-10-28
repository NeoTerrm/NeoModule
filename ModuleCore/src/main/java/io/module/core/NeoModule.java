package io.module.core;

import android.app.Application;

import io.module.core.init.NeoModuleInitializer;

/**
 * @author kiva
 */

public abstract class NeoModule {
    public static void init(Application application) {
        NeoModuleInitializer.init(application);
    }

    public static NeoModule getCore() {
        return null;
    }
}
