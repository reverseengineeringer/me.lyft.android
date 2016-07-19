package com.google.android.gms.internal;

import java.io.IOException;

public final class zzun$zzd
  extends zzapc
{
  public Integer aok;
  public Boolean aol;
  public String aom;
  public String aon;
  public String aoo;
  
  public zzun$zzd()
  {
    zzbwf();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      do
      {
        return true;
        if (!(paramObject instanceof zzd)) {
          return false;
        }
        paramObject = (zzd)paramObject;
        if (aok == null)
        {
          if (aok != null) {
            return false;
          }
        }
        else if (!aok.equals(aok)) {
          return false;
        }
        if (aol == null)
        {
          if (aol != null) {
            return false;
          }
        }
        else if (!aol.equals(aol)) {
          return false;
        }
        if (aom == null)
        {
          if (aom != null) {
            return false;
          }
        }
        else if (!aom.equals(aom)) {
          return false;
        }
        if (aon == null)
        {
          if (aon != null) {
            return false;
          }
        }
        else if (!aon.equals(aon)) {
          return false;
        }
        if (aoo != null) {
          break;
        }
      } while (aoo == null);
      return false;
    } while (aoo.equals(aoo));
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
    if (aok == null)
    {
      i = 0;
      if (aol != null) {
        break label104;
      }
      j = 0;
      if (aom != null) {
        break label115;
      }
      k = 0;
      if (aon != null) {
        break label126;
      }
      m = 0;
      label52:
      if (aoo != null) {
        break label138;
      }
    }
    for (;;)
    {
      return (m + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31) * 31 + n;
      i = aok.intValue();
      break;
      label104:
      j = aol.hashCode();
      break label33;
      label115:
      k = aom.hashCode();
      break label42;
      label126:
      m = aon.hashCode();
      break label52;
      label138:
      n = aoo.hashCode();
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (aok != null) {
      paramzzaov.zzae(1, aok.intValue());
    }
    if (aol != null) {
      paramzzaov.zzj(2, aol.booleanValue());
    }
    if (aom != null) {
      paramzzaov.zzr(3, aom);
    }
    if (aon != null) {
      paramzzaov.zzr(4, aon);
    }
    if (aoo != null) {
      paramzzaov.zzr(5, aoo);
    }
    super.zza(paramzzaov);
  }
  
  public zzd zzbg(zzaou paramzzaou)
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
          aok = Integer.valueOf(i);
        }
        break;
      case 16: 
        aol = Boolean.valueOf(paramzzaou.P());
        break;
      case 26: 
        aom = paramzzaou.readString();
        break;
      case 34: 
        aon = paramzzaou.readString();
        break;
      case 42: 
        aoo = paramzzaou.readString();
      }
    }
  }
  
  public zzd zzbwf()
  {
    aol = null;
    aom = null;
    aon = null;
    aoo = null;
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int j = super.zzy();
    int i = j;
    if (aok != null) {
      i = j + zzaov.zzag(1, aok.intValue());
    }
    j = i;
    if (aol != null) {
      j = i + zzaov.zzk(2, aol.booleanValue());
    }
    i = j;
    if (aom != null) {
      i = j + zzaov.zzs(3, aom);
    }
    j = i;
    if (aon != null) {
      j = i + zzaov.zzs(4, aon);
    }
    i = j;
    if (aoo != null) {
      i = j + zzaov.zzs(5, aoo);
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzun.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */