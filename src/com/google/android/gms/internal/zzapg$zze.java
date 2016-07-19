package com.google.android.gms.internal;

import java.io.IOException;

public final class zzapg$zze
  extends zzaow<zze>
  implements Cloneable
{
  private static volatile zze[] biZ;
  public String value;
  public String zzcb;
  
  public zzapg$zze()
  {
    ay();
  }
  
  public static zze[] ax()
  {
    if (biZ == null) {}
    synchronized (zzapa.bij)
    {
      if (biZ == null) {
        biZ = new zze[0];
      }
      return biZ;
    }
  }
  
  public zze ay()
  {
    zzcb = "";
    value = "";
    bib = null;
    bik = -1;
    return this;
  }
  
  public zze az()
  {
    try
    {
      zze localzze = (zze)super.ac();
      return localzze;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    label41:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof zze));
        paramObject = (zze)paramObject;
        if (zzcb != null) {
          break;
        }
        bool1 = bool2;
      } while (zzcb != null);
      if (value != null) {
        break label111;
      }
      bool1 = bool2;
    } while (value != null);
    for (;;)
    {
      if ((bib == null) || (bib.isEmpty()))
      {
        if (bib != null)
        {
          bool1 = bool2;
          if (!bib.isEmpty()) {
            break;
          }
        }
        return true;
        if (zzcb.equals(zzcb)) {
          break label41;
        }
        return false;
        label111:
        if (!value.equals(value)) {
          return false;
        }
      }
    }
    return bib.equals(bib);
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i;
    int j;
    if (zzcb == null)
    {
      i = 0;
      if (value != null) {
        break label89;
      }
      j = 0;
      label33:
      k = m;
      if (bib != null) {
        if (!bib.isEmpty()) {
          break label100;
        }
      }
    }
    label89:
    label100:
    for (int k = m;; k = bib.hashCode())
    {
      return (j + (i + (n + 527) * 31) * 31) * 31 + k;
      i = zzcb.hashCode();
      break;
      j = value.hashCode();
      break label33;
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (!zzcb.equals("")) {
      paramzzaov.zzr(1, zzcb);
    }
    if (!value.equals("")) {
      paramzzaov.zzr(2, value);
    }
    super.zza(paramzzaov);
  }
  
  public zze zzck(zzaou paramzzaou)
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
        zzcb = paramzzaou.readString();
        break;
      case 18: 
        value = paramzzaou.readString();
      }
    }
  }
  
  protected int zzy()
  {
    int j = super.zzy();
    int i = j;
    if (!zzcb.equals("")) {
      i = j + zzaov.zzs(1, zzcb);
    }
    j = i;
    if (!value.equals("")) {
      j = i + zzaov.zzs(2, value);
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzapg.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */