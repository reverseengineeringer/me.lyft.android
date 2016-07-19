package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjy.zza;
import com.google.android.gms.internal.zzkg;
import java.util.concurrent.Future;

@zzir
public class zza
{
  public zzkg zza(Context paramContext, AdRequestInfoParcel.zza paramzza, zzas paramzzas, zza paramzza1)
  {
    if (zzcav.extras.getBundle("sdk_less_server_data") != null) {}
    for (paramContext = new zzn(paramContext, paramzza, paramzza1);; paramContext = new zzb(paramContext, paramzza, paramzzas, paramzza1))
    {
      paramzza = (Future)paramContext.zzpz();
      return paramContext;
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zza(zzjy.zza paramzza);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */