package io.module.core.init;

import android.app.Application;

import io.module.core.client.ComponentManager;
import io.module.core.client.layout.LayoutManager;
import io.module.core.component.layout.LayoutManagerImpl;

/**
 * @author kiva
 */

public class NeoModuleInitializer {
    /**
     * Register required components here.
     * @param application Android Application instance.
     */
    public static final void init(Application application) {
        ComponentManager componentManager = ComponentManager.get();
        componentManager.registerComponent(LayoutManager.class, new LayoutManagerImpl(application));
    }
}
