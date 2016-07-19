package com.facebook.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;

public class CustomTab
{
  private Uri uri;
  
  public CustomTab(String paramString, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    uri = Utility.buildUri(ServerProtocol.getDialogAuthority(), ServerProtocol.getAPIVersion() + "/" + "dialog/" + paramString, localBundle);
  }
  
  public void openCustomTab(Activity paramActivity, String paramString)
  {
    CustomTabsIntent localCustomTabsIntent = new CustomTabsIntent.Builder().build();
    intent.setPackage(paramString);
    localCustomTabsIntent.launchUrl(paramActivity, uri);
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.CustomTab
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */