package com.google.android.gms.internal;

import java.io.IOException;

public final class zzun$zzc
  extends zzapc
{
  private static volatile zzc[] aof;
  public zzun.zzf aog;
  public zzun.zzd aoh;
  public Boolean aoi;
  public String aoj;
  
  public zzun$zzc()
  {
    zzbwe();
  }
  
  public static zzc[] zzbwd()
  {
    if (aof == null) {}
    synchronized (zzapa.bij)
    {
      if (aof == null) {
        aof = new zzc[0];
      }
      return aof;
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
        if (!(paramObject instanceof zzc)) {
          return false;
        }
        paramObject = (zzc)paramObject;
        if (aog == null)
        {
          if (aog != null) {
            return false;
          }
        }
        else if (!aog.equals(aog)) {
          return false;
        }
        if (aoh == null)
        {
          if (aoh != null) {
            return false;
          }
        }
        else if (!aoh.equals(aoh)) {
          return false;
        }
        if (aoi == null)
        {
          if (aoi != null) {
            return false;
          }
        }
        else if (!aoi.equals(aoi)) {
          return false;
        }
        if (aoj != null) {
          break;
        }
      } while (aoj == null);
      return false;
    } while (aoj.equals(aoj));
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i;
    int j;
    label33:
    int k;
    if (aog == null)
    {
      i = 0;
      if (aoh != null) {
        break label88;
      }
      j = 0;
      if (aoi != null) {
        break label99;
      }
      k = 0;
      label42:
      if (aoj != null) {
        break label110;
      }
    }
    for (;;)
    {
      return (k + (j + (i + (n + 527) * 31) * 31) * 31) * 31 + m;
      i = aog.hashCode();
      break;
      label88:
      j = aoh.hashCode();
      break label33;
      label99:
      k = aoi.hashCode();
      break label42;
      label110:
      m = aoj.hashCode();
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (aog != null) {
      paramzzaov.zza(1, aog);
    }
    if (aoh != null) {
      paramzzaov.zza(2, aoh);
    }
    if (aoi != null) {
      paramzzaov.zzj(3, aoi.booleanValue());
    }
    if (aoj != null) {
      paramzzaov.zzr(4, aoj);
    }
    super.zza(paramzzaov);
  }
  
  public zzc zzbf(zzaou paramzzaou)
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
      case 10: 
        if (aog == null) {
          aog = new zzun.zzf();
        }
        paramzzaou.zza(aog);
        break;
      case 18: 
        if (aoh == null) {
          aoh = new zzun.zzd();
        }
        paramzzaou.zza(aoh);
        break;
      case 24: 
        aoi = Boolean.valueOf(paramzzaou.P());
        break;
      case 34: 
        aoj = paramzzaou.readString();
      }
    }
  }
  
  public zzc zzbwe()
  {
    aog = null;
    aoh = null;
    aoi = null;
    aoj = null;
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int j = super.zzy();
    int i = j;
    if (aog != null) {
      i = j + zzaov.zzc(1, aog);
    }
    j = i;
    if (aoh != null) {
      j = i + zzaov.zzc(2, aoh);
    }
    i = j;
    if (aoi != null) {
      i = j + zzaov.zzk(3, aoi.booleanValue());
    }
    j = i;
    if (aoj != null) {
      j = i + zzaov.zzs(4, aoj);
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzun.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */