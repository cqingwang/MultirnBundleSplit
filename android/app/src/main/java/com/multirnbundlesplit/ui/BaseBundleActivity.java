package com.multirnbundlesplit.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.multirnbundlesplit.react.views.reactview.ReactNativeView;

public abstract class BaseBundleActivity extends Activity implements DefaultHardwareBackBtnHandler {
    private ReactNativeView mReactRootView;

    public static Context mContext;

    public String TAG = MainActivity.class.getSimpleName();

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }
    @Override
    public void onBackPressed() {
        ReactInstanceManager manager = getReactInstanceManager();
        if (manager != null) {
            manager.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    public ReactInstanceManager getReactInstanceManager(){
        return getReactNativeHost().getReactInstanceManager();
    }

    @Override
    public void onDestroy() {
        ReactInstanceManager manager = getReactInstanceManager();
        if (manager != null) {
            manager.onHostDestroy();
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ReactInstanceManager manager = getReactInstanceManager();
        if (manager != null) {
            manager.onHostPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ReactInstanceManager manager = getReactInstanceManager();
        if (manager != null) {
            manager.onHostResume(this, this);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ReactInstanceManager manager = getReactInstanceManager();
        if (manager != null) {
            manager.onActivityResult(this,requestCode,resultCode,data);
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        ReactInstanceManager manager = getReactInstanceManager();
        if (keyCode == KeyEvent.KEYCODE_MENU && manager != null) {
            manager.showDevOptionsDialog();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }


    public ReactNativeHost getReactNativeHost() {
        return ((ReactApplication) getApplication()).getReactNativeHost();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);  //statusbar 状态栏透明
            }
        }

        mReactRootView = ReactNativeView.getInstance(this,getReactInstanceManager(),getReactNativeHost());
        mReactRootView.setComponentNameAndInit("main");
        setContentView(mReactRootView);
    }

}
