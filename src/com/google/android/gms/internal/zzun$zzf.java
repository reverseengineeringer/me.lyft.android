package com.google.android.gms.internal;

import java.io.IOException;

public final class zzun$zzf
  extends zzapc
{
  public Integer aos;
  public String aot;
  public Boolean aou;
  public String[] aov;
  
  public zzun$zzf()
  {
    zzbwi();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzf)) {
        return false;
      }
      paramObject = (zzf)paramObject;
      if (aos == null)
      {
        if (aos != null) {
          return false;
        }
      }
      else if (!aos.equals(aos)) {
        return false;
      }
      if (aot == null)
      {
        if (aot != null) {
          return false;
        }
      }
      else if (!aot.equals(aot)) {
        return false;
      }
      if (aou == null)
      {
        if (aou != null) {
          return false;
        }
      }
      else if (!aou.equals(aou)) {
        return false;
      }
    } while (zzapa.equals(aov, aov));
    return false;
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int i;
    int j;
    if (aos == null)
    {
      i = 0;
      if (aot != null) {
        break label83;
      }
      j = 0;
      label32:
      if (aou != null) {
        break label94;
      }
    }
    for (;;)
    {
      return ((j + (i + (m + 527) * 31) * 31) * 31 + k) * 31 + zzapa.hashCode(aov);
      i = aos.intValue();
      break;
      label83:
      j = aot.hashCode();
      break label32;
      label94:
      k = aou.hashCode();
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (aos != null) {
      paramzzaov.zzae(1, aos.intValue());
    }
    if (aot != null) {
      paramzzaov.zzr(2, aot);
    }
    if (aou != null) {
      paramzzaov.zzj(3, aou.booleanValue());
    }
    if ((aov != null) && (aov.length > 0))
    {
      int i = 0;
      while (i < aov.length)
      {
        String str = aov[i];
        if (str != null) {
          paramzzaov.zzr(4, str);
        }
        i += 1;
      }
    }
    super.zza(paramzzaov);
  }
  
  public zzf zzbi(zzaou paramzzaou)
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
        i = paramzzaou.N();
        switch (i)
        {
        default: 
          break;
        case 0: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
          aos = Integer.valueOf(i);
        }
        break;
      case 18: 
        aot = paramzzaou.readString();
        break;
      case 24: 
        aou = Boolean.valueOf(paramzzaou.P());
        break;
      case 34: 
        int j = zzapf.zzc(paramzzaou, 34);
        if (aov == null) {}
        String[] arrayOfString;
        for (i = 0;; i = aov.length)
        {
          arrayOfString = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(aov, 0, arrayOfString, 0, i);
            j = i;
          }
          while (j < arrayOfString.length - 1)
          {
            arrayOfString[j] = paramzzaou.readString();
            paramzzaou.J();
            j += 1;
          }
        }
        arrayOfString[j] = paramzzaou.readString();
        aov = arrayOfString;
      }
    }
  }
  
  public zzf zzbwi()
  {
    aot = null;
    aou = null;
    aov = zzapf.bir;
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int n = 0;
    int j = super.zzy();
    int i = j;
    if (aos != null) {
      i = j + zzaov.zzag(1, aos.intValue());
    }
    j = i;
    if (aot != null) {
      j = i + zzaov.zzs(2, aot);
    }
    i = j;
    if (aou != null) {
      i = j + zzaov.zzk(3, aou.booleanValue());
    }
    j = i;
    if (aov != null)
    {
      j = i;
      if (aov.length > 0)
      {
        int k = 0;
        int m = 0;
        j = n;
        while (j < aov.length)
        {
          String str = aov[j];
          int i1 = k;
          n = m;
          if (str != null)
          {
            n = m + 1;
            i1 = k + zzaov.zztg(str);
          }
          j += 1;
          k = i1;
          m = n;
        }
        j = i + k + m * 1;
      }
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzun.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */