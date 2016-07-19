package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;
import java.io.File;
import java.util.concurrent.Callable;

class zzkm$zzb$1
  implements Callable<Boolean>
{
  zzkm$zzb$1(zzkm.zzb paramzzb, Context paramContext, WebSettings paramWebSettings) {}
  
  public Boolean zzto()
  {
    if (zzaky.getCacheDir() != null)
    {
      zzcln.setAppCachePath(zzaky.getCacheDir().getAbsolutePath());
      zzcln.setAppCacheMaxSize(0L);
      zzcln.setAppCacheEnabled(true);
    }
    zzcln.setDatabasePath(zzaky.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
    zzcln.setDatabaseEnabled(true);
    zzcln.setDomStorageEnabled(true);
    zzcln.setDisplayZoomControls(false);
    zzcln.setBuiltInZoomControls(true);
    zzcln.setSupportZoom(true);
    zzcln.setAllowContentAccess(false);
    return Boolean.valueOf(true);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkm.zzb.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */