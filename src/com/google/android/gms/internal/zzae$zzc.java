package com.google.android.gms.internal;

import java.io.IOException;

public final class zzae$zzc
  extends zzaow<zzc>
{
  public byte[] zzer = null;
  public byte[] zzes = null;
  
  public zzae$zzc()
  {
    bik = -1;
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (zzer != null) {
      paramzzaov.zza(1, zzer);
    }
    if (zzes != null) {
      paramzzaov.zza(2, zzes);
    }
    super.zza(paramzzaov);
  }
  
  public zzc zzf(zzaou paramzzaou)
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
      case 10: 
        zzer = paramzzaou.readBytes();
        break;
      case 18: 
        zzes = paramzzaou.readBytes();
      }
    }
  }
  
  protected int zzy()
  {
    int j = super.zzy();
    int i = j;
    if (zzer != null) {
      i = j + zzaov.zzb(1, zzer);
    }
    j = i;
    if (zzes != null) {
      j = i + zzaov.zzb(2, zzes);
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzae.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */