package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.zzs;

@zzir
public class zzig
{
  public zzkn zza(Context paramContext, zza paramzza, zzjy.zza paramzza1, zzas paramzzas, zzll paramzzll, zzgn paramzzgn, zza paramzza2, zzdk paramzzdk)
  {
    AdResponseParcel localAdResponseParcel = zzciu;
    if (zzccc)
    {
      paramContext = new zzij(paramContext, paramzza1, paramzzgn, paramzza2, paramzzdk, paramzzll);
      paramzza = String.valueOf(paramContext.getClass().getName());
      if (paramzza.length() == 0) {
        break label275;
      }
    }
    label275:
    for (paramzza = "AdRenderer: ".concat(paramzza);; paramzza = new String("AdRenderer: "))
    {
      zzkh.zzcw(paramzza);
      paramContext.zzpz();
      return paramContext;
      if (zzaus)
      {
        if ((paramzza instanceof zzq))
        {
          paramContext = new zzik(paramContext, (zzq)paramzza, paramzza1, paramzzas, paramzza2);
          break;
        }
        if (paramzza != null) {}
        for (paramContext = paramzza.getClass().getName();; paramContext = "null")
        {
          paramContext = String.valueOf(paramContext);
          throw new IllegalArgumentException(String.valueOf(paramContext).length() + 65 + "Invalid NativeAdManager type. Found: " + paramContext + "; Required: NativeAdManager.");
        }
      }
      if (zzcci)
      {
        paramContext = new zzie(paramContext, paramzza1, paramzzll, paramzza2);
        break;
      }
      if ((((Boolean)zzdc.zzazq.get()).booleanValue()) && (zzs.zzavq()) && (!zzs.isAtLeastL()) && (paramzzll != null) && (zzdozzauq))
      {
        paramContext = new zzii(paramContext, paramzza1, paramzzll, paramzza2);
        break;
      }
      paramContext = new zzih(paramContext, paramzza1, paramzzll, paramzza2);
      break;
    }
  }
  
  public zzkn zza(Context paramContext, zzjy.zza paramzza, zzjj paramzzjj)
  {
    paramzza = new zzjp(paramContext, paramzza, paramzzjj);
    paramContext = String.valueOf(paramzza.getClass().getName());
    if (paramContext.length() != 0) {}
    for (paramContext = "AdRenderer: ".concat(paramContext);; paramContext = new String("AdRenderer: "))
    {
      zzkh.zzcw(paramContext);
      paramzza.zzpz();
      return paramzza;
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zzb(zzjy paramzzjy);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */