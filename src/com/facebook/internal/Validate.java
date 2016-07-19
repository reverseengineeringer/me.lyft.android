package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import com.facebook.CustomTabActivity;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class Validate
{
  private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
  private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
  private static final String CUSTOM_TAB_REDIRECT_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
  private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
  private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
  private static final String TAG = Validate.class.getName();
  
  public static void checkCustomTabRedirectActivity(Context paramContext)
  {
    checkCustomTabRedirectActivity(paramContext, true);
  }
  
  public static void checkCustomTabRedirectActivity(Context paramContext, boolean paramBoolean)
  {
    if (!hasCustomTabRedirectActivity(paramContext))
    {
      if (paramBoolean) {
        throw new IllegalStateException("FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
      }
      Log.w(TAG, "FacebookActivity is declared incorrectly in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
    }
  }
  
  public static void containsNoNullOrEmpty(Collection<String> paramCollection, String paramString)
  {
    notNull(paramCollection, paramString);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      if (str == null) {
        throw new NullPointerException("Container '" + paramString + "' cannot contain null values");
      }
      if (str.length() == 0) {
        throw new IllegalArgumentException("Container '" + paramString + "' cannot contain empty values");
      }
    }
  }
  
  public static <T> void containsNoNulls(Collection<T> paramCollection, String paramString)
  {
    notNull(paramCollection, paramString);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (paramCollection.next() == null) {
        throw new NullPointerException("Container '" + paramString + "' cannot contain null values");
      }
    }
  }
  
  public static String hasAppID()
  {
    String str = FacebookSdk.getApplicationId();
    if (str == null) {
      throw new IllegalStateException("No App ID found, please set the App ID.");
    }
    return str;
  }
  
  public static String hasClientToken()
  {
    String str = FacebookSdk.getClientToken();
    if (str == null) {
      throw new IllegalStateException("No Client Token found, please set the Client Token.");
    }
    return str;
  }
  
  public static void hasContentProvider(Context paramContext)
  {
    notNull(paramContext, "context");
    String str = hasAppID();
    paramContext = paramContext.getPackageManager();
    if (paramContext != null)
    {
      str = "com.facebook.app.FacebookContentProvider" + str;
      if (paramContext.resolveContentProvider(str, 0) == null) {
        throw new IllegalStateException(String.format("A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.", new Object[] { str }));
      }
    }
  }
  
  public static boolean hasCustomTabRedirectActivity(Context paramContext)
  {
    notNull(paramContext, "context");
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = null;
    if (localPackageManager != null)
    {
      paramContext = new Intent();
      paramContext.setAction("android.intent.action.VIEW");
      paramContext.addCategory("android.intent.category.DEFAULT");
      paramContext.addCategory("android.intent.category.BROWSABLE");
      paramContext.setData(Uri.parse("fb" + FacebookSdk.getApplicationId() + "://authorize"));
      paramContext = localPackageManager.queryIntentActivities(paramContext, 64);
    }
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      bool1 = bool2;
      while (paramContext.hasNext()) {
        if (nextactivityInfo.name.equals(CustomTabActivity.class.getName())) {
          bool1 = true;
        } else {
          return false;
        }
      }
    }
    return bool1;
  }
  
  public static void hasFacebookActivity(Context paramContext)
  {
    hasFacebookActivity(paramContext, true);
  }
  
  public static void hasFacebookActivity(Context paramContext, boolean paramBoolean)
  {
    notNull(paramContext, "context");
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localPackageManager != null) {
      paramContext = new ComponentName(paramContext, FacebookActivity.class);
    }
    try
    {
      localObject1 = localPackageManager.getActivityInfo(paramContext, 1);
      if (localObject1 == null)
      {
        if (paramBoolean) {
          throw new IllegalStateException("FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
        }
        Log.w(TAG, "FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
      }
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  public static void hasInternetPermissions(Context paramContext)
  {
    hasInternetPermissions(paramContext, true);
  }
  
  public static void hasInternetPermissions(Context paramContext, boolean paramBoolean)
  {
    notNull(paramContext, "context");
    if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == -1)
    {
      if (paramBoolean) {
        throw new IllegalStateException("No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
      }
      Log.w(TAG, "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
    }
  }
  
  public static <T> void notEmpty(Collection<T> paramCollection, String paramString)
  {
    if (paramCollection.isEmpty()) {
      throw new IllegalArgumentException("Container '" + paramString + "' cannot be empty");
    }
  }
  
  public static <T> void notEmptyAndContainsNoNulls(Collection<T> paramCollection, String paramString)
  {
    containsNoNulls(paramCollection, paramString);
    notEmpty(paramCollection, paramString);
  }
  
  public static void notNull(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new NullPointerException("Argument '" + paramString + "' cannot be null");
    }
  }
  
  public static void notNullOrEmpty(String paramString1, String paramString2)
  {
    if (Utility.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("Argument '" + paramString2 + "' cannot be null or empty");
    }
  }
  
  public static void oneOf(Object paramObject, String paramString, Object... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null)
      {
        if (!localObject.equals(paramObject)) {}
      }
      else {
        while (paramObject == null) {
          return;
        }
      }
      i += 1;
    }
    throw new IllegalArgumentException("Argument '" + paramString + "' was not one of the allowed values");
  }
  
  public static void runningOnUiThread()
  {
    if (!Looper.getMainLooper().equals(Looper.myLooper())) {
      throw new FacebookException("This method should be called from the UI thread");
    }
  }
  
  public static void sdkInitialized()
  {
    if (!FacebookSdk.isInitialized()) {
      throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.Validate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */