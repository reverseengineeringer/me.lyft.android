package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.internal.zzd.zzf;
import com.google.android.gms.common.zzc;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class zzqb$zzb
  extends zzqb.zzf
{
  private final Map<Api.zze, zzqb.zza> tI;
  
  public zzqb$zzb(Map<Api.zze, zzqb.zza> paramMap)
  {
    super(paramMap, null);
    Map localMap;
    tI = localMap;
  }
  
  public void zzapi()
  {
    int n = 1;
    int m = 0;
    final Object localObject = tI.keySet().iterator();
    int j = 1;
    int i = 0;
    Api.zze localzze;
    int k;
    if (((Iterator)localObject).hasNext())
    {
      localzze = (Api.zze)((Iterator)localObject).next();
      if (localzze.zzanr())
      {
        if (zzqb.zza.zza((zzqb.zza)tI.get(localzze)) != 0) {
          break label301;
        }
        i = 1;
        k = n;
      }
    }
    for (;;)
    {
      if (k != 0) {
        m = zzqb.zzb(tG).isGooglePlayServicesAvailable(zzqb.zza(tG));
      }
      if ((m != 0) && ((i != 0) || (j != 0)))
      {
        localObject = new ConnectionResult(m, null);
        zzqb.zzd(tG).zza(new zzqf.zza(tG)
        {
          public void zzapi()
          {
            zzqb.zza(tG, localObject);
          }
        });
        label155:
        return;
        k = 0;
        j = i;
        i = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        if (zzqb.zze(tG)) {
          zzqb.zzf(tG).connect();
        }
        localObject = tI.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          localzze = (Api.zze)((Iterator)localObject).next();
          final zzd.zzf localzzf = (zzd.zzf)tI.get(localzze);
          if ((localzze.zzanr()) && (m != 0)) {
            zzqb.zzd(tG).zza(new zzqf.zza(tG)
            {
              public void zzapi()
              {
                localzzf.zzh(new ConnectionResult(16, null));
              }
            });
          } else {
            localzze.zza(localzzf);
          }
        }
        break label155;
        label301:
        i = j;
        j = 1;
      }
      k = i;
      i = 0;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqb.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */