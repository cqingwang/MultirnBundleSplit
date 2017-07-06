package com.multirnbundlesplit;

import android.app.Application;
import android.content.Context;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.multirnbundlesplit.react.AppReactPackage;
import com.multirnbundlesplit.react.views.reactview.ReactNativeView;
import com.oblador.vectoricons.VectorIconsPackage;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import cn.reactnative.modules.update.UpdatePackage;

public class App extends Application implements ReactApplication {

  public static Context context;

  @Override
  public void onCreate() {
    super.onCreate();
    context = this;
    SoLoader.init(this, /* native exopackage */ false);
  }

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  private ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
              new MainReactPackage(),
              new AppReactPackage(),
              new UpdatePackage(),
              new VectorIconsPackage()
      );
    }

    //模块拆分占时屏蔽热更新
//		@Nullable
//		@Override
//		protected String getJSBundleFile() {
//			return UpdateContext.getBundleUrl(App.this);
//		}

    @Nullable
    @Override
    protected String getBundleAssetName() {
      return ReactNativeView.assetPaths.get("base");
    }
  };
}
