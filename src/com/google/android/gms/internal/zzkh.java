package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzir
public final class zzkh
  extends zzb
{
  public static void v(String paramString)
  {
    if (zztc()) {
      Log.v("Ads", paramString);
    }
  }
  
  public static boolean zztb()
  {
    return ((Boolean)zzdc.zzban.get()).booleanValue();
  }
  
  private static boolean zztc()
  {
    return (zzaz(2)) && (zztb());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */