package com.google.android.gms.internal;

import java.util.Map;

@zzir
public class zzew
  implements zzet
{
  private final zzex zzbiv;
  
  public zzew(zzex paramzzex)
  {
    zzbiv = paramzzex;
  }
  
  public void zza(zzll paramzzll, Map<String, String> paramMap)
  {
    boolean bool1 = "1".equals(paramMap.get("transparentBackground"));
    boolean bool2 = "1".equals(paramMap.get("blur"));
    try
    {
      if (paramMap.get("blurRadius") != null)
      {
        f = Float.parseFloat((String)paramMap.get("blurRadius"));
        zzbiv.zzg(bool1);
        zzbiv.zza(bool2, f);
        return;
      }
    }
    catch (NumberFormatException paramzzll)
    {
      for (;;)
      {
        zzkh.zzb("Fail to parse float", paramzzll);
        float f = 0.0F;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzew
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */