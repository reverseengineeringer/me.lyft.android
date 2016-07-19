package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class zzap
  extends zzaq
{
  private static final String TAG = zzap.class.getSimpleName();
  private AdvertisingIdClient.Info zzafm;
  
  protected zzap(Context paramContext)
  {
    super(paramContext, "");
  }
  
  public static zzap zze(Context paramContext)
  {
    zza(paramContext, true);
    return new zzap(paramContext);
  }
  
  public String zza(String paramString1, String paramString2)
  {
    return zzak.zza(paramString1, paramString2, true);
  }
  
  public void zza(AdvertisingIdClient.Info paramInfo)
  {
    zzafm = paramInfo;
  }
  
  protected void zza(zzax paramzzax, zzae.zza paramzza)
  {
    if (paramzzax.zzcj())
    {
      if (zzafm != null)
      {
        paramzzax = zzafm.getId();
        if (!TextUtils.isEmpty(paramzzax))
        {
          zzeg = zzay.zzo(paramzzax);
          zzeh = Integer.valueOf(5);
          zzei = Boolean.valueOf(zzafm.isLimitAdTrackingEnabled());
        }
        zzafm = null;
      }
      return;
    }
    zza(zzb(paramzzax, paramzza));
  }
  
  protected List<Callable<Void>> zzb(zzax paramzzax, zzae.zza paramzza)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramzzax.zzce() == null) {
      return localArrayList;
    }
    int i = paramzzax.zzau();
    localArrayList.add(new zzbh(paramzzax, zzav.zzbm(), zzav.zzbn(), paramzza, i, 24));
    return localArrayList;
  }
  
  protected zzae.zza zzd(Context paramContext)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */