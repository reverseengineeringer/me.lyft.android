package com.google.android.gms.internal;

import java.util.Map;

class zzkr$3
  extends zzab
{
  zzkr$3(zzkr paramzzkr, int paramInt, String paramString, zzm.zzb paramzzb, zzm.zza paramzza, byte[] paramArrayOfByte, Map paramMap)
  {
    super(paramInt, paramString, paramzzb, paramzza);
  }
  
  public Map<String, String> getHeaders()
    throws zza
  {
    if (zzcmm == null) {
      return super.getHeaders();
    }
    return zzcmm;
  }
  
  public byte[] zzp()
    throws zza
  {
    if (zzcml == null) {
      return super.zzp();
    }
    return zzcml;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkr.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */