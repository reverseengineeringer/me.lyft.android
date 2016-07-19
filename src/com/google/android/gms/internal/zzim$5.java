package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import java.util.List;

class zzim$5
  implements zzlb.zza<List<zzc>, zza>
{
  zzim$5(zzim paramzzim, String paramString, Integer paramInteger1, Integer paramInteger2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public zza zzj(List<zzc> paramList)
  {
    if (paramList != null) {
      for (;;)
      {
        try
        {
          if (paramList.isEmpty()) {
            break;
          }
          String str = zzbzu;
          List localList = zzim.zzi(paramList);
          Integer localInteger1 = zzbzv;
          Integer localInteger2 = zzbzw;
          if (zzbzx > 0)
          {
            paramList = Integer.valueOf(zzbzx);
            paramList = new zza(str, localList, localInteger1, localInteger2, paramList, zzbzy + zzbzz, zzcaa);
          }
        }
        catch (RemoteException paramList)
        {
          zzkh.zzb("Could not get attribution icon", paramList);
          return null;
        }
        paramList = null;
      }
    }
    paramList = null;
    return paramList;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzim.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */