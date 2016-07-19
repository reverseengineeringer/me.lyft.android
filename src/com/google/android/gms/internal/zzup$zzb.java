package com.google.android.gms.internal;

import java.io.IOException;

public final class zzup$zzb
  extends zzapc
{
  private static volatile zzb[] aoJ;
  public zzup.zzc[] aoK;
  public Long aoL;
  public Long aoM;
  public Integer count;
  public String name;
  
  public zzup$zzb()
  {
    zzbwr();
  }
  
  public static zzb[] zzbwq()
  {
    if (aoJ == null) {}
    synchronized (zzapa.bij)
    {
      if (aoJ == null) {
        aoJ = new zzb[0];
      }
      return aoJ;
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
        if (!(paramObject instanceof zzb)) {
          return false;
        }
        paramObject = (zzb)paramObject;
        if (!zzapa.equals(aoK, aoK)) {
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
        if (aoL == null)
        {
          if (aoL != null) {
            return false;
          }
        }
        else if (!aoL.equals(aoL)) {
          return false;
        }
        if (aoM == null)
        {
          if (aoM != null) {
            return false;
          }
        }
        else if (!aoM.equals(aoM)) {
          return false;
        }
        if (count != null) {
          break;
        }
      } while (count == null);
      return false;
    } while (count.equals(count));
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = zzapa.hashCode(aoK);
    int i;
    int j;
    label42:
    int k;
    if (name == null)
    {
      i = 0;
      if (aoL != null) {
        break label103;
      }
      j = 0;
      if (aoM != null) {
        break label114;
      }
      k = 0;
      label51:
      if (count != null) {
        break label125;
      }
    }
    for (;;)
    {
      return (k + (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31) * 31 + m;
      i = name.hashCode();
      break;
      label103:
      j = aoL.hashCode();
      break label42;
      label114:
      k = aoM.hashCode();
      break label51;
      label125:
      m = count.hashCode();
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if ((aoK != null) && (aoK.length > 0))
    {
      int i = 0;
      while (i < aoK.length)
      {
        zzup.zzc localzzc = aoK[i];
        if (localzzc != null) {
          paramzzaov.zza(1, localzzc);
        }
        i += 1;
      }
    }
    if (name != null) {
      paramzzaov.zzr(2, name);
    }
    if (aoL != null) {
      paramzzaov.zzb(3, aoL.longValue());
    }
    if (aoM != null) {
      paramzzaov.zzb(4, aoM.longValue());
    }
    if (count != null) {
      paramzzaov.zzae(5, count.intValue());
    }
    super.zza(paramzzaov);
  }
  
  public zzb zzbn(zzaou paramzzaou)
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
        int j = zzapf.zzc(paramzzaou, 10);
        if (aoK == null) {}
        zzup.zzc[] arrayOfzzc;
        for (i = 0;; i = aoK.length)
        {
          arrayOfzzc = new zzup.zzc[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(aoK, 0, arrayOfzzc, 0, i);
            j = i;
          }
          while (j < arrayOfzzc.length - 1)
          {
            arrayOfzzc[j] = new zzup.zzc();
            paramzzaou.zza(arrayOfzzc[j]);
            paramzzaou.J();
            j += 1;
          }
        }
        arrayOfzzc[j] = new zzup.zzc();
        paramzzaou.zza(arrayOfzzc[j]);
        aoK = arrayOfzzc;
        break;
      case 18: 
        name = paramzzaou.readString();
        break;
      case 24: 
        aoL = Long.valueOf(paramzzaou.M());
        break;
      case 32: 
        aoM = Long.valueOf(paramzzaou.M());
        break;
      case 40: 
        count = Integer.valueOf(paramzzaou.N());
      }
    }
  }
  
  public zzb zzbwr()
  {
    aoK = zzup.zzc.zzbws();
    name = null;
    aoL = null;
    aoM = null;
    count = null;
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int i = super.zzy();
    int j = i;
    if (aoK != null)
    {
      j = i;
      if (aoK.length > 0)
      {
        int k = 0;
        for (;;)
        {
          j = i;
          if (k >= aoK.length) {
            break;
          }
          zzup.zzc localzzc = aoK[k];
          j = i;
          if (localzzc != null) {
            j = i + zzaov.zzc(1, localzzc);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (name != null) {
      i = j + zzaov.zzs(2, name);
    }
    j = i;
    if (aoL != null) {
      j = i + zzaov.zze(3, aoL.longValue());
    }
    i = j;
    if (aoM != null) {
      i = j + zzaov.zze(4, aoM.longValue());
    }
    j = i;
    if (count != null) {
      j = i + zzaov.zzag(5, count.intValue());
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzup.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */