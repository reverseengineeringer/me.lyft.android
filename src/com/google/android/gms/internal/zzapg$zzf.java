package com.google.android.gms.internal;

import java.io.IOException;

public final class zzapg$zzf
  extends zzaow<zzf>
  implements Cloneable
{
  public int bja;
  
  public zzapg$zzf()
  {
    aA();
  }
  
  public zzf aA()
  {
    bja = -1;
    bib = null;
    bik = -1;
    return this;
  }
  
  public zzf aB()
  {
    try
    {
      zzf localzzf = (zzf)super.ac();
      return localzzf;
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
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof zzf));
        paramObject = (zzf)paramObject;
        bool1 = bool2;
      } while (bja != bja);
      if ((bib != null) && (!bib.isEmpty())) {
        break label76;
      }
      if (bib == null) {
        break;
      }
      bool1 = bool2;
    } while (!bib.isEmpty());
    return true;
    label76:
    return bib.equals(bib);
  }
  
  public int hashCode()
  {
    int j = getClass().getName().hashCode();
    int k = bja;
    if ((bib == null) || (bib.isEmpty())) {}
    for (int i = 0;; i = bib.hashCode()) {
      return i + ((j + 527) * 31 + k) * 31;
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (bja != -1) {
      paramzzaov.zzae(1, bja);
    }
    super.zza(paramzzaov);
  }
  
  public zzf zzcl(zzaou paramzzaou)
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
        i = paramzzaou.N();
        switch (i)
        {
        default: 
          break;
        case -1: 
        case 0: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
          bja = i;
        }
        break;
      }
    }
  }
  
  protected int zzy()
  {
    int j = super.zzy();
    int i = j;
    if (bja != -1) {
      i = j + zzaov.zzag(1, bja);
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzapg.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */