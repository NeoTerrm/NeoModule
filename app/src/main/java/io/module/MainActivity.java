package io.module;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

import io.module.core.client.ServiceManager;
import io.module.core.client.layout.LayoutManagerService;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ServiceManager serviceManager = ServiceManager.get();
        LayoutManagerService lms = serviceManager.getService(LayoutManagerService.class);

        try {
            View view = lms.inflate(getAssets().open("hello.xml")).getView();
            setContentView(view);

        } catch (IOException e) {
            e.printStackTrace();
            setContentView(R.layout.activity_main);
        }
    }
}

