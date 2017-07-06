package com.multirnbundlesplit.ui;

import android.content.Context;
import android.os.AsyncTask;

import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.CatalystInstance;

/**
 * Created by chan on 7/6/17.
 */

public class LoadScriptTask extends AsyncTask<Void, Void, Void> {
    private ReactNativeHost host;
    private Context context;
    private String assetPath;
    private ReactRootView view;


    public LoadScriptTask(ReactNativeHost host, Context content, String assetPath, ReactRootView view) {
        this.host = host;
        this.context = content;
        this.assetPath = assetPath;
        this.view = view;
    }

    @Override
    protected Void doInBackground(Void... params) {
        CatalystInstance instance = Utils.getCatalystInstance(host);
        Utils.loadScriptFromAsset(context,
                instance,
                assetPath);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        host.getReactInstanceManager().attachMeasuredRootView(view);
    }
}
