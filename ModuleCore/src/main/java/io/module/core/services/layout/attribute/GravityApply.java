package io.module.core.services.layout.attribute;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Map;

import io.module.core.services.layout.interfaces.ViewAttributeRunnable;

/**
 * @author kiva
 */

class GravityApply implements ViewAttributeRunnable {
    @Override
    public void apply(View view, String value, ViewGroup parent, Map<String, String> attrs) {
        int gravity = AttributeParser.parseGravity(value);
        if (view instanceof TextView) {
            ((TextView) view).setGravity(gravity);
        } else if (view instanceof LinearLayout) {
            ((LinearLayout) view).setGravity(gravity);
        } else if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).setGravity(gravity);
        }
    }
}
