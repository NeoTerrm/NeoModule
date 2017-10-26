package io.module.core.component.layout.attribute;

import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

import io.module.core.component.layout.interfaces.ViewAttributeRunnable;

/**
 * @author kiva
 */

class TagApply implements ViewAttributeRunnable {
    @Override
    public void apply(View view, String value, ViewGroup parent, Map<String, String> attrs) {
        throw new IllegalStateException("You cannot set tag in this situation, because we have other purpose.");
    }
}
