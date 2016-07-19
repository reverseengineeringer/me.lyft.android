package com.google.android.gms.internal;

import java.io.IOException;

public final class zzun$zzb
  extends zzapc
{
  private static volatile zzb[] anZ;
  public Integer aoa;
  public String aob;
  public zzun.zzc[] aoc;
  public Boolean aod;
  public zzun.zzd aoe;
  
  public zzun$zzb()
  {
    zzbwc();
  }
  
  public static zzb[] zzbwb()
  {
    if (anZ == null) {}
    synchronized (zzapa.bij)
    {
      if (anZ == null) {
        anZ = new zzb[0];
      }
      return anZ;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      do
      {
        return true;
        if (!(paramObject instanceof zzb)) {
          return false;
        }
        paramObject = (zzb)paramObject;
        if (aoa == null)
        {
          if (aoa != null) {
            return false;
          }
        }
        else if (!aoa.equals(aoa)) {
          return false;
        }
        if (aob == null)
        {
          if (aob != null) {
            return false;
          }
        }
        else if (!aob.equals(aob)) {
          return false;
        }
        if (!zzapa.equals(aoc, aoc)) {
          return false;
        }
        if (aod == null)
        {
          if (aod != null) {
            return false;
          }
        }
        else if (!aod.equals(aod)) {
          return false;
        }
        if (aoe != null) {
          break;
        }
      } while (aoe == null);
      return false;
    } while (aoe.equals(aoe));
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i;
    int j;
    label33:
    int i1;
    int k;
    if (aoa == null)
    {
      i = 0;
      if (aob != null) {
        break label103;
      }
      j = 0;
      i1 = zzapa.hashCode(aoc);
      if (aod != null) {
        break label114;
      }
      k = 0;
      label51:
      if (aoe != null) {
        break label125;
      }
    }
    for (;;)
    {
      return (k + ((j + (i + (n + 527) * 31) * 31) * 31 + i1) * 31) * 31 + m;
      i = aoa.hashCode();
      break;
      label103:
      j = aob.hashCode();
      break label33;
      label114:
      k = aod.hashCode();
      break label51;
      label125:
      m = aoe.hashCode();
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (aoa != null) {
      paramzzaov.zzae(1, aoa.intValue());
    }
    if (aob != null) {
      paramzzaov.zzr(2, aob);
    }
    if ((aoc != null) && (aoc.length > 0))
    {
      int i = 0;
      while (i < aoc.length)
      {
        zzun.zzc localzzc = aoc[i];
        if (localzzc != null) {
          paramzzaov.zza(3, localzzc);
        }
        i += 1;
      }
    }
    if (aod != null) {
      paramzzaov.zzj(4, aod.booleanValue());
    }
    if (aoe != null) {
      paramzzaov.zza(5, aoe);
    }
    super.zza(paramzzaov);
  }
  
  public zzb zzbe(zzaou paramzzaou)
    throws IOException
  {
    for (;;)
    {
      int i = paramzzaou.J();
      switch (i)
      {
      default: 
        if (zzapf.zzb(paramzzaou, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        aoa = Integer.valueOf(paramzzaou.N());
        break;
      case 18: 
        aob = paramzzaou.readString();
        break;
      case 26: 
        int j = zzapf.zzc(paramzzaou, 26);
        if (aoc == null) {}
        zzun.zzc[] arrayOfzzc;
        for (i = 0;; i = aoc.length)
        {
          arrayOfzzc = new zzun.zzc[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(aoc, 0, arrayOfzzc, 0, i);
            j = i;
          }
          while (j < arrayOfzzc.length - 1)
          {
            arrayOfzzc[j] = new zzun.zzc();
            paramzzaou.zza(arrayOfzzc[j]);
            paramzzaou.J();
            j += 1;
          }
        }
        arrayOfzzc[j] = new zzun.zzc();
        paramzzaou.zza(arrayOfzzc[j]);
        aoc = arrayOfzzc;
        break;
      case 32: 
        aod = Boolean.valueOf(paramzzaou.P());
        break;
      case 42: 
        if (aoe == null) {
          aoe = new zzun.zzd();
        }
        paramzzaou.zza(aoe);
      }
    }
  }
  
  public zzb zzbwc()
  {
    aoa = null;
    aob = null;
    aoc = zzun.zzc.zzbwd();
    aod = null;
    aoe = null;
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int i = super.zzy();
    int j = i;
    if (aoa != null) {
      j = i + zzaov.zzag(1, aoa.intValue());
    }
    i = j;
    if (aob != null) {
      i = j + zzaov.zzs(2, aob);
    }
    j = i;
    if (aoc != null)
    {
      j = i;
      if (aoc.length > 0)
      {
        j = 0;
        while (j < aoc.length)
        {
          zzun.zzc localzzc = aoc[j];
          int k = i;
          if (localzzc != null) {
            k = i + zzaov.zzc(3, localzzc);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (aod != null) {
      i = j + zzaov.zzk(4, aod.booleanValue());
    }
    j = i;
    if (aoe != null) {
      j = i + zzaov.zzc(5, aoe);
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzun.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */