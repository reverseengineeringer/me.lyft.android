package com.google.android.gms.internal;

import java.io.IOException;

public final class zzuo$zzb
  extends zzapc
{
  public String ajz;
  public Integer aoA;
  public zzuo.zzc[] aoB;
  public zzuo.zza[] aoC;
  public zzun.zza[] aoD;
  public Long aoz;
  
  public zzuo$zzb()
  {
    zzbwl();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzb)) {
        return false;
      }
      paramObject = (zzb)paramObject;
      if (aoz == null)
      {
        if (aoz != null) {
          return false;
        }
      }
      else if (!aoz.equals(aoz)) {
        return false;
      }
      if (ajz == null)
      {
        if (ajz != null) {
          return false;
        }
      }
      else if (!ajz.equals(ajz)) {
        return false;
      }
      if (aoA == null)
      {
        if (aoA != null) {
          return false;
        }
      }
      else if (!aoA.equals(aoA)) {
        return false;
      }
      if (!zzapa.equals(aoB, aoB)) {
        return false;
      }
      if (!zzapa.equals(aoC, aoC)) {
        return false;
      }
    } while (zzapa.equals(aoD, aoD));
    return false;
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int i;
    int j;
    if (aoz == null)
    {
      i = 0;
      if (ajz != null) {
        break label105;
      }
      j = 0;
      label32:
      if (aoA != null) {
        break label116;
      }
    }
    for (;;)
    {
      return ((((j + (i + (m + 527) * 31) * 31) * 31 + k) * 31 + zzapa.hashCode(aoB)) * 31 + zzapa.hashCode(aoC)) * 31 + zzapa.hashCode(aoD);
      i = aoz.hashCode();
      break;
      label105:
      j = ajz.hashCode();
      break label32;
      label116:
      k = aoA.hashCode();
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    int j = 0;
    if (aoz != null) {
      paramzzaov.zzb(1, aoz.longValue());
    }
    if (ajz != null) {
      paramzzaov.zzr(2, ajz);
    }
    if (aoA != null) {
      paramzzaov.zzae(3, aoA.intValue());
    }
    int i;
    Object localObject;
    if ((aoB != null) && (aoB.length > 0))
    {
      i = 0;
      while (i < aoB.length)
      {
        localObject = aoB[i];
        if (localObject != null) {
          paramzzaov.zza(4, (zzapc)localObject);
        }
        i += 1;
      }
    }
    if ((aoC != null) && (aoC.length > 0))
    {
      i = 0;
      while (i < aoC.length)
      {
        localObject = aoC[i];
        if (localObject != null) {
          paramzzaov.zza(5, (zzapc)localObject);
        }
        i += 1;
      }
    }
    if ((aoD != null) && (aoD.length > 0))
    {
      i = j;
      while (i < aoD.length)
      {
        localObject = aoD[i];
        if (localObject != null) {
          paramzzaov.zza(6, (zzapc)localObject);
        }
        i += 1;
      }
    }
    super.zza(paramzzaov);
  }
  
  public zzb zzbk(zzaou paramzzaou)
    throws IOException
  {
    for (;;)
    {
      int i = paramzzaou.J();
      int j;
      Object localObject;
      switch (i)
      {
      default: 
        if (zzapf.zzb(paramzzaou, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        aoz = Long.valueOf(paramzzaou.M());
        break;
      case 18: 
        ajz = paramzzaou.readString();
        break;
      case 24: 
        aoA = Integer.valueOf(paramzzaou.N());
        break;
      case 34: 
        j = zzapf.zzc(paramzzaou, 34);
        if (aoB == null) {}
        for (i = 0;; i = aoB.length)
        {
          localObject = new zzuo.zzc[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(aoB, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzuo.zzc();
            paramzzaou.zza(localObject[j]);
            paramzzaou.J();
            j += 1;
          }
        }
        localObject[j] = new zzuo.zzc();
        paramzzaou.zza(localObject[j]);
        aoB = ((zzuo.zzc[])localObject);
        break;
      case 42: 
        j = zzapf.zzc(paramzzaou, 42);
        if (aoC == null) {}
        for (i = 0;; i = aoC.length)
        {
          localObject = new zzuo.zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(aoC, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzuo.zza();
            paramzzaou.zza(localObject[j]);
            paramzzaou.J();
            j += 1;
          }
        }
        localObject[j] = new zzuo.zza();
        paramzzaou.zza(localObject[j]);
        aoC = ((zzuo.zza[])localObject);
        break;
      case 50: 
        j = zzapf.zzc(paramzzaou, 50);
        if (aoD == null) {}
        for (i = 0;; i = aoD.length)
        {
          localObject = new zzun.zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(aoD, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzun.zza();
            paramzzaou.zza(localObject[j]);
            paramzzaou.J();
            j += 1;
          }
        }
        localObject[j] = new zzun.zza();
        paramzzaou.zza(localObject[j]);
        aoD = ((zzun.zza[])localObject);
      }
    }
  }
  
  public zzb zzbwl()
  {
    aoz = null;
    ajz = null;
    aoA = null;
    aoB = zzuo.zzc.zzbwm();
    aoC = zzuo.zza.zzbwj();
    aoD = zzun.zza.zzbvz();
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int m = 0;
    int j = super.zzy();
    int i = j;
    if (aoz != null) {
      i = j + zzaov.zze(1, aoz.longValue());
    }
    j = i;
    if (ajz != null) {
      j = i + zzaov.zzs(2, ajz);
    }
    i = j;
    if (aoA != null) {
      i = j + zzaov.zzag(3, aoA.intValue());
    }
    j = i;
    Object localObject;
    if (aoB != null)
    {
      j = i;
      if (aoB.length > 0)
      {
        j = 0;
        while (j < aoB.length)
        {
          localObject = aoB[j];
          k = i;
          if (localObject != null) {
            k = i + zzaov.zzc(4, (zzapc)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (aoC != null)
    {
      i = j;
      if (aoC.length > 0)
      {
        i = j;
        j = 0;
        while (j < aoC.length)
        {
          localObject = aoC[j];
          k = i;
          if (localObject != null) {
            k = i + zzaov.zzc(5, (zzapc)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    int k = i;
    if (aoD != null)
    {
      k = i;
      if (aoD.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= aoD.length) {
            break;
          }
          localObject = aoD[j];
          k = i;
          if (localObject != null) {
            k = i + zzaov.zzc(6, (zzapc)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzuo.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */