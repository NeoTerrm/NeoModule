package io.module.core.services.layout;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import io.module.core.client.layout.LayoutInflater;
import io.module.core.client.layout.LayoutManagerService;
import io.module.core.client.layout.LayoutSource;

/**
 * @author kiva
 */

public class LayoutManagerServiceImpl implements LayoutManagerService {
    private class InnerInflater implements LayoutInflater {

        @Override
        public View inflateStream(InputStream stream, ViewGroup parent) {
            return NeoLayoutInflater.inflate(context, stream, parent);
        }
    }

    private Context context;
    private InnerInflater inflater;

    public LayoutManagerServiceImpl(Application application) {
        this.context = application.getApplicationContext();
        this.inflater = new InnerInflater();
    }

    @Override
    public LayoutSource inflate(String layoutContent) {
        return inflate(layoutContent, null);
    }

    @Override
    public LayoutSource inflate(File layoutFile) {
        return inflate(layoutFile, null);
    }

    @Override
    public LayoutSource inflate(InputStream inputStream) {
        return inflate(inputStream, null);
    }

    @Override
    public LayoutSource inflate(String layoutContent, ViewGroup parent) {
        return inflate(new ByteArrayInputStream(layoutContent.getBytes()));
    }

    @Override
    public LayoutSource inflate(File layoutFile, ViewGroup parent) {
        try {
            return inflate(new FileInputStream(layoutFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            // We shouldn't return null when something goes wrong,
            // LayoutSource will check if the view is inflated.
            return new LayoutSource();
        }
    }

    @Override
    public LayoutSource inflate(InputStream inputStream, ViewGroup parent) {
        return new LayoutSource(inflater, inputStream, parent);
    }
}
