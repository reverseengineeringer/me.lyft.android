package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import bolts.AppLinks;

public class SourceApplicationInfo$Factory
{
  public static SourceApplicationInfo create(Activity paramActivity)
  {
    boolean bool2 = false;
    Object localObject = paramActivity.getCallingActivity();
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((ComponentName)localObject).getPackageName();
    } while (((String)localObject).equals(paramActivity.getPackageName()));
    Intent localIntent = paramActivity.getIntent();
    paramActivity = (Activity)localObject;
    boolean bool1 = bool2;
    if (localIntent != null)
    {
      paramActivity = (Activity)localObject;
      bool1 = bool2;
      if (!localIntent.getBooleanExtra("_fbSourceApplicationHasBeenSet", false))
      {
        localIntent.putExtra("_fbSourceApplicationHasBeenSet", true);
        Bundle localBundle = AppLinks.getAppLinkData(localIntent);
        paramActivity = (Activity)localObject;
        bool1 = bool2;
        if (localBundle != null)
        {
          bool2 = true;
          localBundle = localBundle.getBundle("referer_app_link");
          paramActivity = (Activity)localObject;
          bool1 = bool2;
          if (localBundle != null)
          {
            paramActivity = localBundle.getString("package");
            bool1 = bool2;
          }
        }
      }
    }
    localIntent.putExtra("_fbSourceApplicationHasBeenSet", true);
    return new SourceApplicationInfo(paramActivity, bool1, null);
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.internal.SourceApplicationInfo.Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */