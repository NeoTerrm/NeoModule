package io.module.core.component.layout;

import android.app.Application;
import android.content.Context;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import io.module.core.client.layout.LayoutManager;
import io.module.core.client.layout.LayoutSource;

/**
 * @author kiva
 */

public class LayoutManagerImpl implements LayoutManager {
    private Context context;

    public LayoutManagerImpl(Application application) {
        this.context = application.getApplicationContext();
    }

    @Override
    public LayoutSource inflate(String layoutContent) {
        return inflate(new ByteArrayInputStream(layoutContent.getBytes()));
    }

    @Override
    public LayoutSource inflate(File layoutFile) {
        // TODO: 2017/10/28 report error
        try {
            return inflate(new FileInputStream(layoutFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LayoutSource inflate(InputStream inputStream) {
        return null;
    }
}
