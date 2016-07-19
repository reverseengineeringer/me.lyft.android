package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public class zzkq$zzb
{
  private final List<String> zzcmd = new ArrayList();
  private final List<Double> zzcme = new ArrayList();
  private final List<Double> zzcmf = new ArrayList();
  
  public zzb zza(String paramString, double paramDouble1, double paramDouble2)
  {
    int i = 0;
    for (;;)
    {
      double d1;
      double d2;
      if (i < zzcmd.size())
      {
        d1 = ((Double)zzcmf.get(i)).doubleValue();
        d2 = ((Double)zzcme.get(i)).doubleValue();
        if (paramDouble1 >= d1) {
          break label107;
        }
      }
      label107:
      while ((d1 == paramDouble1) && (paramDouble2 < d2))
      {
        zzcmd.add(i, paramString);
        zzcmf.add(i, Double.valueOf(paramDouble1));
        zzcme.add(i, Double.valueOf(paramDouble2));
        return this;
      }
      i += 1;
    }
  }
  
  public zzkq zztp()
  {
    return new zzkq(this, null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkq.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */