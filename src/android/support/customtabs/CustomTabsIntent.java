package android.support.customtabs;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.BundleCompat;
import java.util.ArrayList;

public final class CustomTabsIntent
{
  public final Intent intent;
  public final Bundle startAnimationBundle;
  
  private CustomTabsIntent(Intent paramIntent, Bundle paramBundle)
  {
    intent = paramIntent;
    startAnimationBundle = paramBundle;
  }
  
  public void launchUrl(Activity paramActivity, Uri paramUri)
  {
    intent.setData(paramUri);
    ActivityCompat.startActivity(paramActivity, intent, startAnimationBundle);
  }
  
  public static final class Builder
  {
    private ArrayList<Bundle> mActionButtons = null;
    private final Intent mIntent = new Intent("android.intent.action.VIEW");
    private ArrayList<Bundle> mMenuItems = null;
    private Bundle mStartAnimationBundle = null;
    
    public Builder()
    {
      this(null);
    }
    
    public Builder(CustomTabsSession paramCustomTabsSession)
    {
      if (paramCustomTabsSession != null) {
        mIntent.setPackage(paramCustomTabsSession.getComponentName().getPackageName());
      }
      Bundle localBundle = new Bundle();
      if (paramCustomTabsSession == null) {}
      for (paramCustomTabsSession = (CustomTabsSession)localObject;; paramCustomTabsSession = paramCustomTabsSession.getBinder())
      {
        BundleCompat.putBinder(localBundle, "android.support.customtabs.extra.SESSION", paramCustomTabsSession);
        mIntent.putExtras(localBundle);
        return;
      }
    }
    
    public CustomTabsIntent build()
    {
      if (mMenuItems != null) {
        mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", mMenuItems);
      }
      if (mActionButtons != null) {
        mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", mActionButtons);
      }
      return new CustomTabsIntent(mIntent, mStartAnimationBundle, null);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.customtabs.CustomTabsIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */