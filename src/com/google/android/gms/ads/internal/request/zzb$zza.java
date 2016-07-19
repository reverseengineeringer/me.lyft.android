package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzir;

@zzir
final class zzb$zza
  extends Exception
{
  private final int zzbym;
  
  public zzb$zza(String paramString, int paramInt)
  {
    super(paramString);
    zzbym = paramInt;
  }
  
  public int getErrorCode()
  {
    return zzbym;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzb.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */