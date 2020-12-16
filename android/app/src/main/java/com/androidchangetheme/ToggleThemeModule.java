package com.androidchangetheme;


import android.app.Activity;
import android.content.res.Configuration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;

import java.util.Map;
import java.util.HashMap;

public class ToggleThemeModule extends ReactContextBaseJavaModule {
    ToggleThemeModule(ReactApplicationContext context) {
        super(context);
    }

    @NonNull
    @Override
    public String getName() {
        return "ToggleThemeModule";
    }

    @ReactMethod
    public void toggleTheme() {
        System.out.println("toggleTheme");

        Configuration configuration = getCurrentActivity().getResources().getConfiguration();
        int currentNightMode = configuration.uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                UiThreadUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    }
                });

                break;
            case Configuration.UI_MODE_NIGHT_YES:
                UiThreadUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    }
                });

                break;
        }

    }
}