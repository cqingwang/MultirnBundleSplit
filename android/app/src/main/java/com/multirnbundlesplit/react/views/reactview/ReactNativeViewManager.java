package com.multirnbundlesplit.react.views.reactview;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by chan on 7/5/17.
 */

public class ReactNativeViewManager extends SimpleViewManager<ReactNativeView> {
    private ReactInstanceManager manager;
    private ReactNativeHost host;



    public ReactNativeViewManager(ReactInstanceManager manager, ReactNativeHost host){
        this.manager=manager;
        this.host=host;
    }

    private String VIEW_NAME = "RCTReactNativeView";

    @Override
    public String getName() {
        return VIEW_NAME;
    }

    @Override
    protected ReactNativeView createViewInstance(ThemedReactContext reactContext) {
        ReactNativeView view = ReactNativeView.getInstance(reactContext,manager,host);
        return view;
    }

    @ReactProp(name = "componentName")
    public void setComponentName(ReactNativeView view, String componentName) {
        view.setComponentNameAndInit(componentName);
    }
}
