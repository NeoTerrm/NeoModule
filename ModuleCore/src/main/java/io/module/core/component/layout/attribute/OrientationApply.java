package io.module.core.component.layout.attribute;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.Map;

import io.module.core.component.layout.interfaces.ViewAttributeRunnable;

/**
 * @author kiva
 */

class OrientationApply implements ViewAttributeRunnable {
    @Override
    public void apply(View view, String value, ViewGroup parent, Map<String, String> attrs) {
        if (view instanceof LinearLayout) {
            ((LinearLayout) view).setOrientation(value.equals("vertical") ? LinearLayout.VERTICAL : LinearLayout.HORIZONTAL);
        }
    }
}
