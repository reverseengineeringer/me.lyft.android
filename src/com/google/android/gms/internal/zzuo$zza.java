package com.google.android.gms.internal;

import java.io.IOException;

public final class zzuo$zza
  extends zzapc
{
  private static volatile zza[] aow;
  public Boolean aox;
  public Boolean aoy;
  public String name;
  
  public zzuo$zza()
  {
    zzbwk();
  }
  
  public static zza[] zzbwj()
  {
    if (aow == null) {}
    synchronized (zzapa.bij)
    {
      if (aow == null) {
        aow = new zza[0];
      }
      return aow;
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
        if (name == null)
        {
          if (name != null) {
            return false;
          }
        }
        else if (!name.equals(name)) {
          return false;
        }
        if (aox == null)
        {
          if (aox != null) {
            return false;
          }
        }
        else if (!aox.equals(aox)) {
          return false;
        }
        if (aoy != null) {
          break;
        }
      } while (aoy == null);
      return false;
    } while (aoy.equals(aoy));
    return false;
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int i;
    int j;
    if (name == null)
    {
      i = 0;
      if (aox != null) {
        break label72;
      }
      j = 0;
      label32:
      if (aoy != null) {
        break label83;
      }
    }
    for (;;)
    {
      return (j + (i + (m + 527) * 31) * 31) * 31 + k;
      i = name.hashCode();
      break;
      label72:
      j = aox.hashCode();
      break label32;
      label83:
      k = aoy.hashCode();
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (name != null) {
      paramzzaov.zzr(1, name);
    }
    if (aox != null) {
      paramzzaov.zzj(2, aox.booleanValue());
    }
    if (aoy != null) {
      paramzzaov.zzj(3, aoy.booleanValue());
    }
    super.zza(paramzzaov);
  }
  
  public zza zzbj(zzaou paramzzaou)
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
      case 16: 
        aox = Boolean.valueOf(paramzzaou.P());
        break;
      case 24: 
        aoy = Boolean.valueOf(paramzzaou.P());
      }
    }
  }
  
  public zza zzbwk()
  {
    name = null;
    aox = null;
    aoy = null;
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
    if (aox != null) {
      j = i + zzaov.zzk(2, aox.booleanValue());
    }
    i = j;
    if (aoy != null) {
      i = j + zzaov.zzk(3, aoy.booleanValue());
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzuo.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */