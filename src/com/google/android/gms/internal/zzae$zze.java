package com.google.android.gms.internal;

import java.io.IOException;

public final class zzae$zze
  extends zzaow<zze>
{
  public Long zzen = null;
  public String zzew = null;
  public byte[] zzex = null;
  
  public zzae$zze()
  {
    bik = -1;
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (zzen != null) {
      paramzzaov.zzb(1, zzen.longValue());
    }
    if (zzew != null) {
      paramzzaov.zzr(3, zzew);
    }
    if (zzex != null) {
      paramzzaov.zza(4, zzex);
    }
    super.zza(paramzzaov);
  }
  
  public zze zzh(zzaou paramzzaou)
    throws IOException
  {
    for (;;)
    {
      int i = paramzzaou.J();
      switch (i)
      {
      default: 
        if (super.zza(paramzzaou, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        zzen = Long.valueOf(paramzzaou.M());
        break;
      case 26: 
        zzew = paramzzaou.readString();
        break;
      case 34: 
        zzex = paramzzaou.readBytes();
      }
    }
  }
  
  protected int zzy()
  {
    int j = super.zzy();
    int i = j;
    if (zzen != null) {
      i = j + zzaov.zze(1, zzen.longValue());
    }
    j = i;
    if (zzew != null) {
      j = i + zzaov.zzs(3, zzew);
    }
    i = j;
    if (zzex != null) {
      i = j + zzaov.zzb(4, zzex);
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzae.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */