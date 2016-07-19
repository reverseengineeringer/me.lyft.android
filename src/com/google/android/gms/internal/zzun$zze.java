package com.google.android.gms.internal;

import java.io.IOException;

public final class zzun$zze
  extends zzapc
{
  private static volatile zze[] aop;
  public Integer aoa;
  public String aoq;
  public zzun.zzc aor;
  
  public zzun$zze()
  {
    zzbwh();
  }
  
  public static zze[] zzbwg()
  {
    if (aop == null) {}
    synchronized (zzapa.bij)
    {
      if (aop == null) {
        aop = new zze[0];
      }
      return aop;
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
        if (!(paramObject instanceof zze)) {
          return false;
        }
        paramObject = (zze)paramObject;
        if (aoa == null)
        {
          if (aoa != null) {
            return false;
          }
        }
        else if (!aoa.equals(aoa)) {
          return false;
        }
        if (aoq == null)
        {
          if (aoq != null) {
            return false;
          }
        }
        else if (!aoq.equals(aoq)) {
          return false;
        }
        if (aor != null) {
          break;
        }
      } while (aor == null);
      return false;
    } while (aor.equals(aor));
    return false;
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int i;
    int j;
    if (aoa == null)
    {
      i = 0;
      if (aoq != null) {
        break label72;
      }
      j = 0;
      label32:
      if (aor != null) {
        break label83;
      }
    }
    for (;;)
    {
      return (j + (i + (m + 527) * 31) * 31) * 31 + k;
      i = aoa.hashCode();
      break;
      label72:
      j = aoq.hashCode();
      break label32;
      label83:
      k = aor.hashCode();
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (aoa != null) {
      paramzzaov.zzae(1, aoa.intValue());
    }
    if (aoq != null) {
      paramzzaov.zzr(2, aoq);
    }
    if (aor != null) {
      paramzzaov.zza(3, aor);
    }
    super.zza(paramzzaov);
  }
  
  public zze zzbh(zzaou paramzzaou)
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
        aoq = paramzzaou.readString();
        break;
      case 26: 
        if (aor == null) {
          aor = new zzun.zzc();
        }
        paramzzaou.zza(aor);
      }
    }
  }
  
  public zze zzbwh()
  {
    aoa = null;
    aoq = null;
    aor = null;
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int j = super.zzy();
    int i = j;
    if (aoa != null) {
      i = j + zzaov.zzag(1, aoa.intValue());
    }
    j = i;
    if (aoq != null) {
      j = i + zzaov.zzs(2, aoq);
    }
    i = j;
    if (aor != null) {
      i = j + zzaov.zzc(3, aor);
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzun.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */