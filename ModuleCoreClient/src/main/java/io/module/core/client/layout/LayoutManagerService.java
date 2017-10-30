package io.module.core.client.layout;

import android.view.ViewGroup;

import java.io.File;
import java.io.InputStream;

/**
 * @author kiva
 */

public interface LayoutManagerService {
    LayoutSource inflate(String layoutContent);

    LayoutSource inflate(File layoutFile);

    LayoutSource inflate(InputStream inputStream);

    LayoutSource inflate(String layoutContent, ViewGroup parent);

    LayoutSource inflate(File layoutFile, ViewGroup parent);

    LayoutSource inflate(InputStream inputStream, ViewGroup parent);
}
