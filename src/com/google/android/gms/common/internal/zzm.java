package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzm
{
  private static zzm yA;
  private static final Object yz = new Object();
  
  public static zzm zzce(Context paramContext)
  {
    synchronized (yz)
    {
      if (yA == null) {
        yA = new zzn(paramContext.getApplicationContext());
      }
      return yA;
    }
  }
  
  public abstract boolean zza(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3);
  
  public abstract void zzb(String paramString1, String paramString2, ServiceConnection paramServiceConnection, String paramString3);
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */