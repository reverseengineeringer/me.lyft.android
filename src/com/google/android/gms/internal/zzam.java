package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.clearcut.zzb.zza;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class zzam
{
  protected static volatile zzb zzaez = null;
  private static volatile Random zzafb = null;
  private static final Object zzafc = new Object();
  private zzax zzaey;
  protected boolean zzafa = false;
  
  public zzam(zzax paramzzax)
  {
    zzaey = paramzzax;
    zzdc.initialize(paramzzax.getContext());
    zzafa = ((Boolean)zzdc.zzbbg.get()).booleanValue();
    if ((zzafa) && (zzaez == null)) {
      synchronized (zzafc)
      {
        if (zzaez == null) {
          zzaez = new zzb(paramzzax.getContext(), "ADSHIELD", null);
        }
        return;
      }
    }
  }
  
  private static Random zzav()
  {
    if (zzafb == null) {}
    synchronized (zzafc)
    {
      if (zzafb == null) {
        zzafb = new Random();
      }
      return zzafb;
    }
  }
  
  public void zza(int paramInt1, int paramInt2, long paramLong)
    throws IOException
  {
    try
    {
      if ((zzafa) && (zzaez != null) && (zzaey.zzck()))
      {
        Object localObject = new zzad.zza();
        zzck = zzaey.getContext().getPackageName();
        zzcl = Long.valueOf(paramLong);
        localObject = zzaez.zzl(zzapc.zzf((zzapc)localObject));
        ((zzb.zza)localObject).zzex(paramInt2);
        ((zzb.zza)localObject).zzew(paramInt1);
        ((zzb.zza)localObject).zze(zzaey.zzci());
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public int zzau()
  {
    try
    {
      int i = ThreadLocalRandom.current().nextInt();
      return i;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      return zzav().nextInt();
    }
    catch (RuntimeException localRuntimeException) {}
    return zzav().nextInt();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzam
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */