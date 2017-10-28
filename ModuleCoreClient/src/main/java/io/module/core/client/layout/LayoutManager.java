package io.module.core.client.layout;

import java.io.File;
import java.io.InputStream;

/**
 * @author kiva
 */

public interface LayoutManager {
    LayoutSource inflate(String layoutContent);

    LayoutSource inflate(File layoutFile);

    LayoutSource inflate(InputStream inputStream);
}
