package com.google.android.gms.internal;

import java.io.IOException;

public final class zzup$zzg
  extends zzapc
{
  private static volatile zzg[] aps;
  public Float anS;
  public Double anT;
  public Long aoO;
  public Long apt;
  public String name;
  public String zr;
  
  public zzup$zzg()
  {
    zzbwz();
  }
  
  public static zzg[] zzbwy()
  {
    if (aps == null) {}
    synchronized (zzapa.bij)
    {
      if (aps == null) {
        aps = new zzg[0];
      }
      return aps;
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
        if (!(paramObject instanceof zzg)) {
          return false;
        }
        paramObject = (zzg)paramObject;
        if (apt == null)
        {
          if (apt != null) {
            return false;
          }
        }
        else if (!apt.equals(apt)) {
          return false;
        }
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
    int i1 = 0;
    int i2 = getClass().getName().hashCode();
    int i;
    int j;
    label33:
    int k;
    label42:
    int m;
    label52:
    int n;
    if (apt == null)
    {
      i = 0;
      if (name != null) {
        break label120;
      }
      j = 0;
      if (zr != null) {
        break label131;
      }
      k = 0;
      if (aoO != null) {
        break label142;
      }
      m = 0;
      if (anS != null) {
        break label154;
      }
      n = 0;
      label62:
      if (anT != null) {
        break label166;
      }
    }
    for (;;)
    {
      return (n + (m + (k + (j + (i + (i2 + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i1;
      i = apt.hashCode();
      break;
      label120:
      j = name.hashCode();
      break label33;
      label131:
      k = zr.hashCode();
      break label42;
      label142:
      m = aoO.hashCode();
      break label52;
      label154:
      n = anS.hashCode();
      break label62;
      label166:
      i1 = anT.hashCode();
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (apt != null) {
      paramzzaov.zzb(1, apt.longValue());
    }
    if (name != null) {
      paramzzaov.zzr(2, name);
    }
    if (zr != null) {
      paramzzaov.zzr(3, zr);
    }
    if (aoO != null) {
      paramzzaov.zzb(4, aoO.longValue());
    }
    if (anS != null) {
      paramzzaov.zzc(5, anS.floatValue());
    }
    if (anT != null) {
      paramzzaov.zza(6, anT.doubleValue());
    }
    super.zza(paramzzaov);
  }
  
  public zzg zzbs(zzaou paramzzaou)
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
        apt = Long.valueOf(paramzzaou.M());
        break;
      case 18: 
        name = paramzzaou.readString();
        break;
      case 26: 
        zr = paramzzaou.readString();
        break;
      case 32: 
        aoO = Long.valueOf(paramzzaou.M());
        break;
      case 45: 
        anS = Float.valueOf(paramzzaou.readFloat());
        break;
      case 49: 
        anT = Double.valueOf(paramzzaou.readDouble());
      }
    }
  }
  
  public zzg zzbwz()
  {
    apt = null;
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
    if (apt != null) {
      i = j + zzaov.zze(1, apt.longValue());
    }
    j = i;
    if (name != null) {
      j = i + zzaov.zzs(2, name);
    }
    i = j;
    if (zr != null) {
      i = j + zzaov.zzs(3, zr);
    }
    j = i;
    if (aoO != null) {
      j = i + zzaov.zze(4, aoO.longValue());
    }
    i = j;
    if (anS != null) {
      i = j + zzaov.zzd(5, anS.floatValue());
    }
    j = i;
    if (anT != null) {
      j = i + zzaov.zzb(6, anT.doubleValue());
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzup.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */