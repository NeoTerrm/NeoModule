package io.module.core;

import android.app.Application;

/**
 * @author kiva
 */

public abstract class NeoModule {
    public static void init(Application application) {
    }

    public static NeoModule getCore() {
        return null;
    }
}
