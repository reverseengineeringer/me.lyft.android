package com.google.android.gms.internal;

import java.io.IOException;

public final class zzae$zzd
  extends zzaow<zzd>
{
  public byte[] data = null;
  public byte[] zzet = null;
  public byte[] zzeu = null;
  public byte[] zzev = null;
  
  public zzae$zzd()
  {
    bik = -1;
  }
  
  public static zzd zzd(byte[] paramArrayOfByte)
    throws zzapb
  {
    return (zzd)zzapc.zza(new zzd(), paramArrayOfByte);
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (data != null) {
      paramzzaov.zza(1, data);
    }
    if (zzet != null) {
      paramzzaov.zza(2, zzet);
    }
    if (zzeu != null) {
      paramzzaov.zza(3, zzeu);
    }
    if (zzev != null) {
      paramzzaov.zza(4, zzev);
    }
    super.zza(paramzzaov);
  }
  
  public zzd zzg(zzaou paramzzaou)
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
        data = paramzzaou.readBytes();
        break;
      case 18: 
        zzet = paramzzaou.readBytes();
        break;
      case 26: 
        zzeu = paramzzaou.readBytes();
        break;
      case 34: 
        zzev = paramzzaou.readBytes();
      }
    }
  }
  
  protected int zzy()
  {
    int j = super.zzy();
    int i = j;
    if (data != null) {
      i = j + zzaov.zzb(1, data);
    }
    j = i;
    if (zzet != null) {
      j = i + zzaov.zzb(2, zzet);
    }
    i = j;
    if (zzeu != null) {
      i = j + zzaov.zzb(3, zzeu);
    }
    j = i;
    if (zzev != null) {
      j = i + zzaov.zzb(4, zzev);
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzae.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */