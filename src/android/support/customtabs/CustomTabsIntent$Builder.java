package android.support.customtabs;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import java.util.ArrayList;

public final class CustomTabsIntent$Builder
{
  private ArrayList<Bundle> mActionButtons = null;
  private final Intent mIntent = new Intent("android.intent.action.VIEW");
  private ArrayList<Bundle> mMenuItems = null;
  private Bundle mStartAnimationBundle = null;
  
  public CustomTabsIntent$Builder()
  {
    this(null);
  }
  
  public CustomTabsIntent$Builder(CustomTabsSession paramCustomTabsSession)
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

/* Location:
 * Qualified Name:     android.support.customtabs.CustomTabsIntent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */