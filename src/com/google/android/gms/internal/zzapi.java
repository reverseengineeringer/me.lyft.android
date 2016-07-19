package com.google.android.gms.internal;

import android.content.ComponentName;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

public class zzapi
  extends CustomTabsServiceConnection
{
  private WeakReference<zzapj> bjc;
  
  public zzapi(zzapj paramzzapj)
  {
    bjc = new WeakReference(paramzzapj);
  }
  
  public void onCustomTabsServiceConnected(ComponentName paramComponentName, CustomTabsClient paramCustomTabsClient)
  {
    paramComponentName = (zzapj)bjc.get();
    if (paramComponentName != null) {
      paramComponentName.zza(paramCustomTabsClient);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = (zzapj)bjc.get();
    if (paramComponentName != null) {
      paramComponentName.zzkm();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzapi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */