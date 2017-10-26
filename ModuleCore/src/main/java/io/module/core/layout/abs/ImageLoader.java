package io.module.core.layout.abs;

import android.widget.ImageView;

public interface ImageLoader {
    void loadImage(ImageView view, String url);

    void loadRoundedImage(ImageView view, String url, int radius);
}