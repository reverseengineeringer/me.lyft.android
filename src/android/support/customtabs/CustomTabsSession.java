package android.support.customtabs;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;

public final class CustomTabsSession
{
  private final ICustomTabsCallback mCallback;
  private final ComponentName mComponentName;
  private final ICustomTabsService mService;
  
  CustomTabsSession(ICustomTabsService paramICustomTabsService, ICustomTabsCallback paramICustomTabsCallback, ComponentName paramComponentName)
  {
    mService = paramICustomTabsService;
    mCallback = paramICustomTabsCallback;
    mComponentName = paramComponentName;
  }
  
  IBinder getBinder()
  {
    return mCallback.asBinder();
  }
  
  ComponentName getComponentName()
  {
    return mComponentName;
  }
  
  public boolean mayLaunchUrl(Uri paramUri, Bundle paramBundle, List<Bundle> paramList)
  {
    try
    {
      boolean bool = mService.mayLaunchUrl(mCallback, paramUri, paramBundle, paramList);
      return bool;
    }
    catch (RemoteException paramUri) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.customtabs.CustomTabsSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */