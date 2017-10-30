package io.module.core.client.layout;

import android.view.View;
import android.view.ViewGroup;

import java.io.InputStream;

/**
 * @author kiva
 */

public class LayoutSource {
    private View lazyView;
    private ViewGroup parentView;
    private LayoutInflater layoutInflater;
    private InputStream layoutInputSource;

    public LayoutSource() {
        lazyView = null;
        parentView = null;
        layoutInflater = null;
        layoutInputSource = null;
    }

    public LayoutSource(LayoutInflater layoutInflater, InputStream layoutInputSource, ViewGroup parentView) {
        this.layoutInflater = layoutInflater;
        this.layoutInputSource = layoutInputSource;
        this.parentView = parentView;
    }

    public boolean isViewInflated() {
        return lazyView != null;
    }

    public View getView() {
        if (lazyView == null) {
            synchronized (this) {
                if (lazyView == null) {
                    lazyView = layoutInflater.inflateStream(layoutInputSource, parentView);
                }
            }
        }
        return lazyView;
    }
}
