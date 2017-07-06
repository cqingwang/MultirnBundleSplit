package com.multirnbundlesplit.react;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.multirnbundlesplit.react.views.reactview.ReactNativeViewManager;
import com.multirnbundlesplit.ui.BaseBundleActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AppReactPackage implements ReactPackage {
    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        BaseBundleActivity activity = (BaseBundleActivity) BaseBundleActivity.mContext;
        return Arrays.<ViewManager>asList(
                new ReactNativeViewManager(activity.getReactInstanceManager(), activity.getReactNativeHost())
        );
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Arrays.<NativeModule>asList(
                //modules
        );
    }
}
