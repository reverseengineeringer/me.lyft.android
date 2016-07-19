package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class zzbi
  implements Callable
{
  private final zzax zzaey;
  private final zzae.zza zzaha;
  
  public zzbi(zzax paramzzax, zzae.zza paramzza)
  {
    zzaey = paramzzax;
    zzaha = paramzza;
  }
  
  public Void zzcy()
    throws Exception
  {
    if (zzaey.zzcn() != null) {
      zzaey.zzcn().get();
    }
    zzae.zza localzza2 = zzaey.zzcm();
    if (localzza2 != null) {
      try
      {
        synchronized (zzaha)
        {
          zzapc.zza(zzaha, zzapc.zzf(localzza2));
        }
        return null;
      }
      catch (zzapb localzzapb) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */