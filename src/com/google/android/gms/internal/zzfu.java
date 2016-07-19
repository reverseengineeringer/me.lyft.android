package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Future;

@zzir
public class zzfu
{
  private zzft zza(Context paramContext, VersionInfoParcel paramVersionInfoParcel, final zza<zzft> paramzza, zzas paramzzas)
  {
    paramContext = new zzfv(paramContext, paramVersionInfoParcel, paramzzas);
    zzblo = paramContext;
    paramContext.zza(new zzft.zza()
    {
      public void zzmb()
      {
        paramzza.zzi((zzft)paramzzazzblo);
      }
    });
    return paramContext;
  }
  
  public Future<zzft> zza(final Context paramContext, final VersionInfoParcel paramVersionInfoParcel, final String paramString, final zzas paramzzas)
  {
    final zza localzza = new zza(null);
    zzkl.zzclg.post(new Runnable()
    {
      public void run()
      {
        zzfu.zza(zzfu.this, paramContext, paramVersionInfoParcel, localzza, paramzzas).zzbi(paramString);
      }
    });
    return localzza;
  }
  
  private static class zza<JavascriptEngine>
    extends zzkz<JavascriptEngine>
  {
    JavascriptEngine zzblo;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */