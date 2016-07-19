package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

@zzir
public class zzdj
{
  private final zzdk zzajn;
  private final Map<String, zzdi> zzbec;
  
  public zzdj(zzdk paramzzdk)
  {
    zzajn = paramzzdk;
    zzbec = new HashMap();
  }
  
  public void zza(String paramString, zzdi paramzzdi)
  {
    zzbec.put(paramString, paramzzdi);
  }
  
  public void zza(String paramString1, String paramString2, long paramLong)
  {
    zzdg.zza(zzajn, (zzdi)zzbec.get(paramString2), paramLong, new String[] { paramString1 });
    zzbec.put(paramString1, zzdg.zza(zzajn, paramLong));
  }
  
  public zzdk zzkf()
  {
    return zzajn;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */