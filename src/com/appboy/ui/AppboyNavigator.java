package com.appboy.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import com.appboy.Constants;
import com.appboy.IAppboyNavigator;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.actions.ActivityAction;
import com.appboy.ui.actions.WebAction;
import com.appboy.ui.activities.AppboyFeedActivity;

public class AppboyNavigator
  implements IAppboyNavigator
{
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyNavigator.class.getName() });
  
  public void gotoNewsFeed(Context paramContext, Bundle paramBundle)
  {
    paramBundle = new ComponentName(paramContext, AppboyFeedActivity.class);
    try
    {
      paramContext.getPackageManager().getActivityInfo(paramBundle, 1);
      new ActivityAction(new Intent(paramContext, AppboyFeedActivity.class)).execute(paramContext);
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppboyLogger.d(TAG, "The AppboyFeedActivity is not registered in the manifest. Ignoring request to display the news feed.");
    }
  }
  
  public void gotoURI(Context paramContext, Uri paramUri, Bundle paramBundle)
  {
    if (paramUri == null)
    {
      AppboyLogger.e(TAG, "IAppboyNavigator cannot open URI because the URI is null.");
      return;
    }
    new WebAction(paramUri.toString()).execute(paramContext);
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.AppboyNavigator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */