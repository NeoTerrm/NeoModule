package io.module.core.component.layout;

import java.util.Map;

import io.module.core.component.layout.attribute.AttributeApply;
import io.module.core.component.layout.interfaces.ImageLoader;
import io.module.core.component.layout.interfaces.ViewAttributeRunnable;


/**
 * @author kiva
 */

public class NeoLayoutConfig {
    public final int noLayoutRule = -999;
    public final String[] viewCorners = {"TopLeft", "TopRight", "BottomRight", "BottomLeft"};

    public Map<String, ViewAttributeRunnable> viewRunnables;
    public ImageLoader imageLoader = null;

    NeoLayoutConfig() {
    }

    void createViewRunnablesIfNeeded() {
        if (viewRunnables != null) {
            return;
        }
        viewRunnables = AttributeApply.createDefaultAttributeApply(imageLoader);
    }
}
