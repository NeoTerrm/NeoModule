package io.module.core.model;


import io.module.core.interfaces.IModuleLifecycleCallback;

/**
 * @author kiva
 */

public class Module implements IModuleLifecycleCallback {
    private ModuleInfo moduleInfo;

    public Module(ModuleInfo moduleInfo) {
        this.moduleInfo = moduleInfo;
    }

    public ModuleInfo getModuleInfo() {
        return moduleInfo;
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onDestroy() {
    }
}
