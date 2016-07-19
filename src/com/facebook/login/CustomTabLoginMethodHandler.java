package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookSdk;
import com.facebook.internal.CustomTab;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import com.facebook.internal.Validate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomTabLoginMethodHandler
  extends WebLoginMethodHandler
{
  private static final String CHROME_PACKAGE = "com.android.chrome";
  private static final String[] CHROME_PACKAGES = { "com.android.chrome", "com.chrome.beta", "com.chrome.dev" };
  public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new Parcelable.Creator()
  {
    public CustomTabLoginMethodHandler createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CustomTabLoginMethodHandler(paramAnonymousParcel);
    }
    
    public CustomTabLoginMethodHandler[] newArray(int paramAnonymousInt)
    {
      return new CustomTabLoginMethodHandler[paramAnonymousInt];
    }
  };
  private static final String CUSTOM_TABS_SERVICE_ACTION = "android.support.customtabs.action.CustomTabsService";
  private static final String OAUTH_DIALOG = "oauth";
  private String currentPackage;
  private CustomTab customTab;
  
  CustomTabLoginMethodHandler(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  CustomTabLoginMethodHandler(LoginClient paramLoginClient)
  {
    super(paramLoginClient);
  }
  
  private String getChromePackage()
  {
    if (currentPackage != null) {
      return currentPackage;
    }
    Object localObject1 = loginClient.getActivity();
    Object localObject2 = new Intent("android.support.customtabs.action.CustomTabsService");
    localObject2 = ((Context)localObject1).getPackageManager().queryIntentServices((Intent)localObject2, 0);
    if (localObject2 != null)
    {
      localObject1 = new HashSet(Arrays.asList(CHROME_PACKAGES));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ServiceInfo localServiceInfo = nextserviceInfo;
        if ((localServiceInfo != null) && (((Set)localObject1).contains(packageName)))
        {
          currentPackage = packageName;
          return currentPackage;
        }
      }
    }
    return null;
  }
  
  private boolean isCustomTabsAllowed()
  {
    return (isCustomTabsEnabled()) && (getChromePackage() != null) && (Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext()));
  }
  
  private boolean isCustomTabsEnabled()
  {
    Utility.FetchedAppSettings localFetchedAppSettings = Utility.getAppSettingsWithoutQuery(Utility.getMetadataApplicationId(loginClient.getActivity()));
    return (localFetchedAppSettings != null) && (localFetchedAppSettings.getCustomTabsEnabled());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  String getNameForLogging()
  {
    return "custom_tab";
  }
  
  protected String getSSODevice()
  {
    return "chrome_custom_tab";
  }
  
  AccessTokenSource getTokenSource()
  {
    return AccessTokenSource.CHROME_CUSTOM_TAB;
  }
  
  protected void putChallengeParam(JSONObject paramJSONObject)
    throws JSONException
  {
    if ((loginClient.getFragment() instanceof LoginFragment)) {
      paramJSONObject.put("7_challenge", ((LoginFragment)loginClient.getFragment()).getChallengeParam());
    }
  }
  
  boolean tryAuthorize(LoginClient.Request paramRequest)
  {
    if (!isCustomTabsAllowed()) {
      return false;
    }
    paramRequest = addExtraParameters(getParameters(paramRequest), paramRequest);
    FragmentActivity localFragmentActivity = loginClient.getActivity();
    customTab = new CustomTab("oauth", paramRequest);
    customTab.openCustomTab(localFragmentActivity, getChromePackage());
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.CustomTabLoginMethodHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */