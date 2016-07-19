package com.google.android.gms.internal;

import java.io.IOException;

public final class zzup$zza
  extends zzapc
{
  private static volatile zza[] aoF;
  public Integer anW;
  public zzup.zzf aoG;
  public zzup.zzf aoH;
  public Boolean aoI;
  
  public zzup$zza()
  {
    zzbwp();
  }
  
  public static zza[] zzbwo()
  {
    if (aoF == null) {}
    synchronized (zzapa.bij)
    {
      if (aoF == null) {
        aoF = new zza[0];
      }
      return aoF;
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
        if (!(paramObject instanceof zza)) {
          return false;
        }
        paramObject = (zza)paramObject;
        if (anW == null)
        {
          if (anW != null) {
            return false;
          }
        }
        else if (!anW.equals(anW)) {
          return false;
        }
        if (aoG == null)
        {
          if (aoG != null) {
            return false;
          }
        }
        else if (!aoG.equals(aoG)) {
          return false;
        }
        if (aoH == null)
        {
          if (aoH != null) {
            return false;
          }
        }
        else if (!aoH.equals(aoH)) {
          return false;
        }
        if (aoI != null) {
          break;
        }
      } while (aoI == null);
      return false;
    } while (aoI.equals(aoI));
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
    if (anW == null)
    {
      i = 0;
      if (aoG != null) {
        break label88;
      }
      j = 0;
      if (aoH != null) {
        break label99;
      }
      k = 0;
      label42:
      if (aoI != null) {
        break label110;
      }
    }
    for (;;)
    {
      return (k + (j + (i + (n + 527) * 31) * 31) * 31) * 31 + m;
      i = anW.hashCode();
      break;
      label88:
      j = aoG.hashCode();
      break label33;
      label99:
      k = aoH.hashCode();
      break label42;
      label110:
      m = aoI.hashCode();
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (anW != null) {
      paramzzaov.zzae(1, anW.intValue());
    }
    if (aoG != null) {
      paramzzaov.zza(2, aoG);
    }
    if (aoH != null) {
      paramzzaov.zza(3, aoH);
    }
    if (aoI != null) {
      paramzzaov.zzj(4, aoI.booleanValue());
    }
    super.zza(paramzzaov);
  }
  
  public zza zzbm(zzaou paramzzaou)
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
        anW = Integer.valueOf(paramzzaou.N());
        break;
      case 18: 
        if (aoG == null) {
          aoG = new zzup.zzf();
        }
        paramzzaou.zza(aoG);
        break;
      case 26: 
        if (aoH == null) {
          aoH = new zzup.zzf();
        }
        paramzzaou.zza(aoH);
        break;
      case 32: 
        aoI = Boolean.valueOf(paramzzaou.P());
      }
    }
  }
  
  public zza zzbwp()
  {
    anW = null;
    aoG = null;
    aoH = null;
    aoI = null;
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int j = super.zzy();
    int i = j;
    if (anW != null) {
      i = j + zzaov.zzag(1, anW.intValue());
    }
    j = i;
    if (aoG != null) {
      j = i + zzaov.zzc(2, aoG);
    }
    i = j;
    if (aoH != null) {
      i = j + zzaov.zzc(3, aoH);
    }
    j = i;
    if (aoI != null) {
      j = i + zzaov.zzk(4, aoI.booleanValue());
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzup.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */