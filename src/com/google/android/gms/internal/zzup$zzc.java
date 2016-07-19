package com.google.android.gms.internal;

import java.io.IOException;

public final class zzup$zzc
  extends zzapc
{
  private static volatile zzc[] aoN;
  public Float anS;
  public Double anT;
  public Long aoO;
  public String name;
  public String zr;
  
  public zzup$zzc()
  {
    zzbwt();
  }
  
  public static zzc[] zzbws()
  {
    if (aoN == null) {}
    synchronized (zzapa.bij)
    {
      if (aoN == null) {
        aoN = new zzc[0];
      }
      return aoN;
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
        if (name == null)
        {
          if (name != null) {
            return false;
          }
        }
        else if (!name.equals(name)) {
          return false;
        }
        if (zr == null)
        {
          if (zr != null) {
            return false;
          }
        }
        else if (!zr.equals(zr)) {
          return false;
        }
        if (aoO == null)
        {
          if (aoO != null) {
            return false;
          }
        }
        else if (!aoO.equals(aoO)) {
          return false;
        }
        if (anS == null)
        {
          if (anS != null) {
            return false;
          }
        }
        else if (!anS.equals(anS)) {
          return false;
        }
        if (anT != null) {
          break;
        }
      } while (anT == null);
      return false;
    } while (anT.equals(anT));
    return false;
  }
  
  public int hashCode()
  {
    int n = 0;
    int i1 = getClass().getName().hashCode();
    int i;
    int j;
    label33:
    int k;
    label42:
    int m;
    if (name == null)
    {
      i = 0;
      if (zr != null) {
        break label104;
      }
      j = 0;
      if (aoO != null) {
        break label115;
      }
      k = 0;
      if (anS != null) {
        break label126;
      }
      m = 0;
      label52:
      if (anT != null) {
        break label138;
      }
    }
    for (;;)
    {
      return (m + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31) * 31 + n;
      i = name.hashCode();
      break;
      label104:
      j = zr.hashCode();
      break label33;
      label115:
      k = aoO.hashCode();
      break label42;
      label126:
      m = anS.hashCode();
      break label52;
      label138:
      n = anT.hashCode();
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (name != null) {
      paramzzaov.zzr(1, name);
    }
    if (zr != null) {
      paramzzaov.zzr(2, zr);
    }
    if (aoO != null) {
      paramzzaov.zzb(3, aoO.longValue());
    }
    if (anS != null) {
      paramzzaov.zzc(4, anS.floatValue());
    }
    if (anT != null) {
      paramzzaov.zza(5, anT.doubleValue());
    }
    super.zza(paramzzaov);
  }
  
  public zzc zzbo(zzaou paramzzaou)
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
        name = paramzzaou.readString();
        break;
      case 18: 
        zr = paramzzaou.readString();
        break;
      case 24: 
        aoO = Long.valueOf(paramzzaou.M());
        break;
      case 37: 
        anS = Float.valueOf(paramzzaou.readFloat());
        break;
      case 41: 
        anT = Double.valueOf(paramzzaou.readDouble());
      }
    }
  }
  
  public zzc zzbwt()
  {
    name = null;
    zr = null;
    aoO = null;
    anS = null;
    anT = null;
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int j = super.zzy();
    int i = j;
    if (name != null) {
      i = j + zzaov.zzs(1, name);
    }
    j = i;
    if (zr != null) {
      j = i + zzaov.zzs(2, zr);
    }
    i = j;
    if (aoO != null) {
      i = j + zzaov.zze(3, aoO.longValue());
    }
    j = i;
    if (anS != null) {
      j = i + zzaov.zzd(4, anS.floatValue());
    }
    i = j;
    if (anT != null) {
      i = j + zzaov.zzb(5, anT.doubleValue());
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzup.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */