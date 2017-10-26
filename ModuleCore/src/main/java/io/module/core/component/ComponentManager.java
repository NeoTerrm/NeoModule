package io.module.core.component;

import java.util.concurrent.ConcurrentHashMap;

import io.module.core.interfaces.IComponent;

/**
 * @author kiva
 */

public class ComponentManager {
    private static final ConcurrentHashMap<Class<? extends IComponent>, IComponent> COMPONENTS;

    static {
        COMPONENTS = new ConcurrentHashMap<>(4);
    }
}
