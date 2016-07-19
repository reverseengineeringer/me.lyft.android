package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

@zzir
class zzeu$zzd
{
  private final String zzbfm;
  private final String zzbim;
  private final int zzbit;
  private final List<zzeu.zza> zzbiu;
  
  public zzeu$zzd(String paramString1, int paramInt, List<zzeu.zza> paramList, String paramString2)
  {
    zzbim = paramString1;
    zzbit = paramInt;
    if (paramList == null) {}
    for (zzbiu = new ArrayList();; zzbiu = paramList)
    {
      zzbfm = paramString2;
      return;
    }
  }
  
  public String getBody()
  {
    return zzbfm;
  }
  
  public int getResponseCode()
  {
    return zzbit;
  }
  
  public String zzlg()
  {
    return zzbim;
  }
  
  public Iterable<zzeu.zza> zzll()
  {
    return zzbiu;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzeu.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */