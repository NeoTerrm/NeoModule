package io.module.core.services.layout.attribute;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.Map;

import io.module.core.services.layout.interfaces.ViewAttributeRunnable;

/**
 * @author kiva
 */

class HintApply implements ViewAttributeRunnable {
    @Override
    public void apply(View view, String value, ViewGroup parent, Map<String, String> attrs) {
        if (view instanceof EditText) {
            ((EditText) view).setHint(value);
        }
    }
}
