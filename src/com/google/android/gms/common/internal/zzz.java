package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzrt;
import com.google.android.gms.internal.zzru;

public class zzz
{
  private static String yS;
  private static int yT;
  private static Object zzamp = new Object();
  private static boolean zzbyy;
  
  public static String zzcf(Context paramContext)
  {
    zzch(paramContext);
    return yS;
  }
  
  public static int zzcg(Context paramContext)
  {
    zzch(paramContext);
    return yT;
  }
  
  private static void zzch(Context paramContext)
  {
    String str;
    synchronized (zzamp)
    {
      if (zzbyy) {
        return;
      }
      zzbyy = true;
      str = paramContext.getPackageName();
      paramContext = zzru.zzcq(paramContext);
    }
    try
    {
      paramContext = getApplicationInfo128metaData;
      if (paramContext == null)
      {
        return;
        paramContext = finally;
        throw paramContext;
      }
      yS = paramContext.getString("com.google.app.id");
      yT = paramContext.getInt("com.google.android.gms.version");
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        Log.wtf("MetadataValueReader", "This should never happen.", paramContext);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */