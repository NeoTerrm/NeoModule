package io.module.core.runtime;

import io.module.core.model.EventEmitter;
import io.module.core.model.Module;

/**
 * @author kiva
 */

public class ModuleProxy extends EventEmitter {

    public ModuleProxy(Module module) {
        on("create", args -> module.onCreate());

        on("destroy", args -> module.onDestroy());
    }
}
