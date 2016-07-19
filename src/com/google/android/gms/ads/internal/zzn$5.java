package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgs;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzll;
import java.util.Map;

final class zzn$5
  implements zzet
{
  zzn$5(zzgr paramzzgr, zzf.zza paramzza, zzgs paramzzgs) {}
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    paramMap = paramzzll.getView();
    if (paramMap == null) {}
    do
    {
      return;
      try
      {
        if (zzamm == null) {
          continue;
        }
        if (!zzamm.getOverrideClickHandling())
        {
          zzamm.zzk(zze.zzae(paramMap));
          zzamn.onClick();
          return;
        }
      }
      catch (RemoteException paramzzll)
      {
        zzkh.zzd("Unable to call handleClick on mapper", paramzzll);
        return;
      }
      zzn.zzb(paramzzll);
      return;
    } while (zzamo == null);
    if (!zzamo.getOverrideClickHandling())
    {
      zzamo.zzk(zze.zzae(paramMap));
      zzamn.onClick();
      return;
    }
    zzn.zzb(paramzzll);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzn.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */