package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zzqj
  extends BroadcastReceiver
{
  protected Context mContext;
  private final zza uQ;
  
  public zzqj(zza paramzza)
  {
    uQ = paramzza;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getData();
    paramContext = null;
    if (paramIntent != null) {
      paramContext = paramIntent.getSchemeSpecificPart();
    }
    if ("com.google.android.gms".equals(paramContext))
    {
      uQ.zzaor();
      unregister();
    }
  }
  
  public void setContext(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public void unregister()
  {
    try
    {
      if (mContext != null) {
        mContext.unregisterReceiver(this);
      }
      mContext = null;
      return;
    }
    finally {}
  }
  
  public static abstract class zza
  {
    public abstract void zzaor();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */