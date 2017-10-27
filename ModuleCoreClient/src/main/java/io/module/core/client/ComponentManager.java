package io.module.core.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kiva
 */

public class ComponentManager {
    private Map<Class<?>, Object> SERVICE_CACHE = new ConcurrentHashMap<>();
    private static final boolean THROW_EXCEPTION_ON_NOT_FOUND_SERVICE = true;

    private static class ServiceManagerHolder {
        static final ComponentManager INSTANCE = new ComponentManager();
    }

    public static ComponentManager get() {
        return ServiceManagerHolder.INSTANCE;
    }

    public void registerComponent(Class<?> componentInterface, Object component) {
        if (componentInterface != null && component != null && componentInterface.isInterface()) {
            SERVICE_CACHE.put(componentInterface, component);
        }
    }

    public void unregisterComponent(Class<?> componentInterface) {
        SERVICE_CACHE.remove(componentInterface);
    }

    @SuppressWarnings("unchecked")
    public <T> T getService(Class<?> componentInterface) {
        Object service = null;
        if (componentInterface != null && componentInterface.isInterface()) {
            service = SERVICE_CACHE.get(componentInterface);
        }
        if (THROW_EXCEPTION_ON_NOT_FOUND_SERVICE) {
            if (service == null) {
                throw new RuntimeException("Cannot get component: " + componentInterface);
            }
        }
        return (T) service;
    }
}
