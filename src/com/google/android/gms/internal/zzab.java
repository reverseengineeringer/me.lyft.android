package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;

public class zzab
  extends zzk<String>
{
  private final zzm.zzb<String> zzcg;
  
  public zzab(int paramInt, String paramString, zzm.zzb<String> paramzzb, zzm.zza paramzza)
  {
    super(paramInt, paramString, paramzza);
    zzcg = paramzzb;
  }
  
  protected zzm<String> zza(zzi paramzzi)
  {
    try
    {
      String str1 = new String(data, zzx.zza(zzz));
      return zzm.zza(str1, zzx.zzb(paramzzi));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str2 = new String(data);
      }
    }
  }
  
  protected void zzi(String paramString)
  {
    zzcg.zzb(paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzab
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */