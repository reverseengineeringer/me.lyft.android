package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public final class zzvy
  implements Api.ApiOptions.Optional
{
  public static final zzvy aul = new zza().zzbzp();
  private final boolean aum;
  private final boolean aun;
  private final Long auo;
  private final Long aup;
  private final boolean dT;
  private final boolean dV;
  private final String dW;
  private final String dX;
  
  private zzvy(boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, String paramString2, boolean paramBoolean4, Long paramLong1, Long paramLong2)
  {
    aum = paramBoolean1;
    dT = paramBoolean2;
    dW = paramString1;
    dV = paramBoolean3;
    aun = paramBoolean4;
    dX = paramString2;
    auo = paramLong1;
    aup = paramLong2;
  }
  
  public boolean zzafr()
  {
    return dT;
  }
  
  public boolean zzaft()
  {
    return dV;
  }
  
  public String zzafu()
  {
    return dW;
  }
  
  public String zzafv()
  {
    return dX;
  }
  
  public boolean zzbzl()
  {
    return aum;
  }
  
  public boolean zzbzm()
  {
    return aun;
  }
  
  public Long zzbzn()
  {
    return auo;
  }
  
  public Long zzbzo()
  {
    return aup;
  }
  
  public static final class zza
  {
    public zzvy zzbzp()
    {
      return new zzvy(false, false, null, false, null, false, null, null, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzvy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */