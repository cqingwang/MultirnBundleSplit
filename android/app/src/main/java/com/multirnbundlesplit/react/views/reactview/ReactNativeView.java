package com.multirnbundlesplit.react.views.reactview;

import android.content.Context;
import android.os.AsyncTask;


import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.LifecycleState;
import com.multirnbundlesplit.ui.LoadScriptTask;
import com.multirnbundlesplit.ui.Utils;

import java.util.HashMap;
import java.util.Map;

import cn.reactnative.modules.update.UpdateContext;


public class ReactNativeView extends ReactRootView {

    public static Map<String,String> assetPaths=new HashMap<String,String>();
    private ReactInstanceManager manager;
    private ReactNativeHost host;
    static{
        assetPaths.put("base","bundle/base/index.bundle");
        assetPaths.put("main","bundle/main/index.bundle");
        assetPaths.put("active","bundle/active/index.bundle");
    }

    private String componentName;

    public ReactNativeView(Context context) {
        super(context);
    }

    public static ReactNativeView getInstance(Context context, ReactInstanceManager manager, ReactNativeHost host){
        ReactNativeView instance =new ReactNativeView(context);
        instance.manager=manager;
        instance.host=host;
        return instance;
    }

    public void setComponentNameAndInit(String componentName) {
        this.componentName = componentName;
        this.initView();
    }

    public void initView(){
        LifecycleState state = manager.getLifecycleState();
        switch (state) {
            case BEFORE_CREATE:
            case BEFORE_RESUME:
            default:
                if (!manager.hasStartedCreatingInitialContext()) {
                    manager.createReactContextInBackground();
                    manager.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
                        @Override
                        public void onReactContextInitialized(ReactContext reactContext) {
                            loadScriptAsync();
                        }
                    });
                }else{
                    loadScriptAsync();
                }
                break;
            case RESUMED:
                loadScriptAsync();
                break;
        }
        Utils.setJsModuleName(this, componentName);
        Utils.setReactInstanceManager(this,manager);
    }
    private String getAssetPath(String cName){
        return UpdateContext.getBundleUrl(this.getContext(), assetPaths.get(cName));
    }

    private void loadScriptAsync() {
        LoadScriptTask task = new LoadScriptTask(host,this.getContext(),getAssetPath(componentName),this);
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
