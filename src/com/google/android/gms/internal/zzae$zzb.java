package com.google.android.gms.internal;

import java.io.IOException;

public final class zzae$zzb
  extends zzaow<zzb>
{
  public Long zzen = null;
  public Integer zzeo = null;
  public Boolean zzep = null;
  public int[] zzeq = zzapf.bim;
  
  public zzae$zzb()
  {
    bik = -1;
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (zzen != null) {
      paramzzaov.zzb(1, zzen.longValue());
    }
    if (zzeo != null) {
      paramzzaov.zzae(2, zzeo.intValue());
    }
    if (zzep != null) {
      paramzzaov.zzj(3, zzep.booleanValue());
    }
    if ((zzeq != null) && (zzeq.length > 0))
    {
      int i = 0;
      while (i < zzeq.length)
      {
        paramzzaov.zzae(4, zzeq[i]);
        i += 1;
      }
    }
    super.zza(paramzzaov);
  }
  
  public zzb zze(zzaou paramzzaou)
    throws IOException
  {
    for (;;)
    {
      int i = paramzzaou.J();
      int j;
      int[] arrayOfInt;
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
      case 16: 
        zzeo = Integer.valueOf(paramzzaou.N());
        break;
      case 24: 
        zzep = Boolean.valueOf(paramzzaou.P());
        break;
      case 32: 
        j = zzapf.zzc(paramzzaou, 32);
        if (zzeq == null) {}
        for (i = 0;; i = zzeq.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzeq, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length - 1)
          {
            arrayOfInt[j] = paramzzaou.N();
            paramzzaou.J();
            j += 1;
          }
        }
        arrayOfInt[j] = paramzzaou.N();
        zzeq = arrayOfInt;
        break;
      case 34: 
        int k = paramzzaou.zzaei(paramzzaou.S());
        i = paramzzaou.getPosition();
        j = 0;
        while (paramzzaou.X() > 0)
        {
          paramzzaou.N();
          j += 1;
        }
        paramzzaou.zzaek(i);
        if (zzeq == null) {}
        for (i = 0;; i = zzeq.length)
        {
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzeq, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramzzaou.N();
            j += 1;
          }
        }
        zzeq = arrayOfInt;
        paramzzaou.zzaej(k);
      }
    }
  }
  
  protected int zzy()
  {
    int m = 0;
    int j = super.zzy();
    int i = j;
    if (zzen != null) {
      i = j + zzaov.zze(1, zzen.longValue());
    }
    j = i;
    if (zzeo != null) {
      j = i + zzaov.zzag(2, zzeo.intValue());
    }
    i = j;
    if (zzep != null) {
      i = j + zzaov.zzk(3, zzep.booleanValue());
    }
    j = i;
    if (zzeq != null)
    {
      j = i;
      if (zzeq.length > 0)
      {
        int k = 0;
        j = m;
        while (j < zzeq.length)
        {
          k += zzaov.zzaeo(zzeq[j]);
          j += 1;
        }
        j = i + k + zzeq.length * 1;
      }
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzae.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */