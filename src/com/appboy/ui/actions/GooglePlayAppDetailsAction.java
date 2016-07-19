package com.appboy.ui.actions;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.appboy.Constants;
import com.appboy.enums.AppStore;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.AppboyWebViewActivity;

public final class GooglePlayAppDetailsAction
  implements IAction
{
  private static final String AMAZON_STORE_APP_BASE = "amzn://apps/android?asin=";
  private static final String AMAZON_STORE_WEB_BASE = "http://www.amazon.com/gp/mas/dl/android?asin=";
  private static final String PLAY_STORE_APP_BASE = "market://details?id=";
  private static final String PLAY_STORE_WEB_BASE = "https://play.google.com/store/apps/details?id=";
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, GooglePlayAppDetailsAction.class.getName() });
  private final AppStore mAppStore;
  private String mKindleId;
  private final String mPackageName;
  private boolean mUseAppboyWebView;
  
  public GooglePlayAppDetailsAction(String paramString, boolean paramBoolean, AppStore paramAppStore)
  {
    mPackageName = paramString;
    mUseAppboyWebView = paramBoolean;
    mAppStore = paramAppStore;
  }
  
  public GooglePlayAppDetailsAction(String paramString1, boolean paramBoolean, AppStore paramAppStore, String paramString2)
  {
    mPackageName = paramString1;
    mUseAppboyWebView = paramBoolean;
    mAppStore = paramAppStore;
    mKindleId = paramString2;
  }
  
  public void execute(Context paramContext)
  {
    if (mAppStore != AppStore.KINDLE_STORE) {}
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.google.android.gsf", 0);
      if (mUseAppboyWebView) {
        if (mAppStore == AppStore.KINDLE_STORE)
        {
          String str1 = "http://www.amazon.com/gp/mas/dl/android?asin=" + mKindleId;
          paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str1), paramContext, AppboyWebViewActivity.class));
          return;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        AppboyLogger.i(TAG, "Google Play Store not found, launching Play Store with WebView");
        mUseAppboyWebView = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AppboyLogger.e(TAG, String.format("Unexpected exception while checking for %s.", new Object[] { "com.google.android.gsf" }));
        mUseAppboyWebView = true;
        continue;
        str2 = "https://play.google.com/store/apps/details?id=" + mPackageName;
      }
    }
    if (mAppStore == AppStore.KINDLE_STORE) {}
    for (String str2 = "amzn://apps/android?asin=" + mKindleId;; str2 = "market://details?id=" + mPackageName)
    {
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.actions.GooglePlayAppDetailsAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */