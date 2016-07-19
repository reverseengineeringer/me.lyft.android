package com.google.android.gms.internal;

import java.io.IOException;

public final class zzuo$zzc
  extends zzapc
{
  private static volatile zzc[] aoE;
  public String value;
  public String zzcb;
  
  public zzuo$zzc()
  {
    zzbwn();
  }
  
  public static zzc[] zzbwm()
  {
    if (aoE == null) {}
    synchronized (zzapa.bij)
    {
      if (aoE == null) {
        aoE = new zzc[0];
      }
      return aoE;
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
        if (zzcb == null)
        {
          if (zzcb != null) {
            return false;
          }
        }
        else if (!zzcb.equals(zzcb)) {
          return false;
        }
        if (value != null) {
          break;
        }
      } while (value == null);
      return false;
    } while (value.equals(value));
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int i;
    if (zzcb == null)
    {
      i = 0;
      if (value != null) {
        break label56;
      }
    }
    for (;;)
    {
      return (i + (k + 527) * 31) * 31 + j;
      i = zzcb.hashCode();
      break;
      label56:
      j = value.hashCode();
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (zzcb != null) {
      paramzzaov.zzr(1, zzcb);
    }
    if (value != null) {
      paramzzaov.zzr(2, value);
    }
    super.zza(paramzzaov);
  }
  
  public zzc zzbl(zzaou paramzzaou)
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
        zzcb = paramzzaou.readString();
        break;
      case 18: 
        value = paramzzaou.readString();
      }
    }
  }
  
  public zzc zzbwn()
  {
    zzcb = null;
    value = null;
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int j = super.zzy();
    int i = j;
    if (zzcb != null) {
      i = j + zzaov.zzs(1, zzcb);
    }
    j = i;
    if (value != null) {
      j = i + zzaov.zzs(2, value);
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzuo.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */