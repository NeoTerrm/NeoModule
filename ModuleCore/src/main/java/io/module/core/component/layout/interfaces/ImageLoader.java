package io.module.core.component.layout.interfaces;

import android.widget.ImageView;

public interface ImageLoader {
    void loadImage(ImageView view, String url);

    void loadRoundedImage(ImageView view, String url, int radius);
}