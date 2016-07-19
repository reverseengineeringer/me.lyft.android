package com.google.android.gms.internal;

import java.io.IOException;

public final class zzapg$zzb
  extends zzaow<zzb>
  implements Cloneable
{
  public String biA;
  public int biz;
  public String version;
  
  public zzapg$zzb()
  {
    ar();
  }
  
  public zzb ar()
  {
    biz = 0;
    biA = "";
    version = "";
    bib = null;
    bik = -1;
    return this;
  }
  
  public zzb as()
  {
    try
    {
      zzb localzzb = (zzb)super.ac();
      return localzzb;
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
    label54:
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof zzb));
          paramObject = (zzb)paramObject;
          bool1 = bool2;
        } while (biz != biz);
        if (biA != null) {
          break;
        }
        bool1 = bool2;
      } while (biA != null);
      if (version != null) {
        break label124;
      }
      bool1 = bool2;
    } while (version != null);
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
        if (biA.equals(biA)) {
          break label54;
        }
        return false;
        label124:
        if (!version.equals(version)) {
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
    int i1 = biz;
    int i;
    int j;
    if (biA == null)
    {
      i = 0;
      if (version != null) {
        break label101;
      }
      j = 0;
      label39:
      k = m;
      if (bib != null) {
        if (!bib.isEmpty()) {
          break label112;
        }
      }
    }
    label101:
    label112:
    for (int k = m;; k = bib.hashCode())
    {
      return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
      i = biA.hashCode();
      break;
      j = version.hashCode();
      break label39;
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (biz != 0) {
      paramzzaov.zzae(1, biz);
    }
    if (!biA.equals("")) {
      paramzzaov.zzr(2, biA);
    }
    if (!version.equals("")) {
      paramzzaov.zzr(3, version);
    }
    super.zza(paramzzaov);
  }
  
  public zzb zzch(zzaou paramzzaou)
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
      case 8: 
        biz = paramzzaou.N();
        break;
      case 18: 
        biA = paramzzaou.readString();
        break;
      case 26: 
        version = paramzzaou.readString();
      }
    }
  }
  
  protected int zzy()
  {
    int j = super.zzy();
    int i = j;
    if (biz != 0) {
      i = j + zzaov.zzag(1, biz);
    }
    j = i;
    if (!biA.equals("")) {
      j = i + zzaov.zzs(2, biA);
    }
    i = j;
    if (!version.equals("")) {
      i = j + zzaov.zzs(3, version);
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzapg.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */