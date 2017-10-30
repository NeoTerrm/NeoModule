package io.module.core.init;

import android.app.Application;

import io.module.core.client.ServiceManager;
import io.module.core.client.error.ErrorManagerService;
import io.module.core.client.layout.LayoutManagerService;
import io.module.core.services.error.ErrorManagerServiceImpl;
import io.module.core.services.layout.LayoutManagerServiceImpl;

/**
 * @author kiva
 */

public class NeoModuleInitializer {
    /**
     * Register required components here.
     * @param application Android Application instance.
     */
    public static final void init(Application application) {
        ServiceManager serviceManager = ServiceManager.get();

        serviceManager.registerService(LayoutManagerService.class, new LayoutManagerServiceImpl(application));
        serviceManager.registerService(ErrorManagerService.class, new ErrorManagerServiceImpl());
    }
}
