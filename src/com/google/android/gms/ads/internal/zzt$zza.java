package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import android.webkit.WebView;
import com.google.android.gms.internal.zzbw;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzkh;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class zzt$zza
  extends AsyncTask<Void, Void, Void>
{
  private zzt$zza(zzt paramzzt) {}
  
  protected Void zza(Void... paramVarArgs)
  {
    try
    {
      zzt.zza(zzanm, (zzbw)zzt.zze(zzanm).get(((Long)zzdc.zzbdb.get()).longValue(), TimeUnit.MILLISECONDS));
      return null;
    }
    catch (InterruptedException paramVarArgs)
    {
      for (;;)
      {
        zzkh.zzd("Failed to load ad data", paramVarArgs);
      }
    }
    catch (TimeoutException paramVarArgs)
    {
      for (;;)
      {
        zzkh.zzcy("Timed out waiting for ad data");
      }
    }
    catch (ExecutionException paramVarArgs)
    {
      for (;;) {}
    }
  }
  
  protected void zza(Void paramVoid)
  {
    paramVoid = zzanm.zzfe();
    if (zzt.zzf(zzanm) != null) {
      zzt.zzf(zzanm).loadUrl(paramVoid);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzt.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */