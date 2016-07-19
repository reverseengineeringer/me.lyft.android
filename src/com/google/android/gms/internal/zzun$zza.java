package com.google.android.gms.internal;

import java.io.IOException;

public final class zzun$zza
  extends zzapc
{
  private static volatile zza[] anV;
  public Integer anW;
  public zzun.zze[] anX;
  public zzun.zzb[] anY;
  
  public zzun$zza()
  {
    zzbwa();
  }
  
  public static zza[] zzbvz()
  {
    if (anV == null) {}
    synchronized (zzapa.bij)
    {
      if (anV == null) {
        anV = new zza[0];
      }
      return anV;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zza)) {
        return false;
      }
      paramObject = (zza)paramObject;
      if (anW == null)
      {
        if (anW != null) {
          return false;
        }
      }
      else if (!anW.equals(anW)) {
        return false;
      }
      if (!zzapa.equals(anX, anX)) {
        return false;
      }
    } while (zzapa.equals(anY, anY));
    return false;
  }
  
  public int hashCode()
  {
    int j = getClass().getName().hashCode();
    if (anW == null) {}
    for (int i = 0;; i = anW.hashCode()) {
      return ((i + (j + 527) * 31) * 31 + zzapa.hashCode(anX)) * 31 + zzapa.hashCode(anY);
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    int j = 0;
    if (anW != null) {
      paramzzaov.zzae(1, anW.intValue());
    }
    int i;
    Object localObject;
    if ((anX != null) && (anX.length > 0))
    {
      i = 0;
      while (i < anX.length)
      {
        localObject = anX[i];
        if (localObject != null) {
          paramzzaov.zza(2, (zzapc)localObject);
        }
        i += 1;
      }
    }
    if ((anY != null) && (anY.length > 0))
    {
      i = j;
      while (i < anY.length)
      {
        localObject = anY[i];
        if (localObject != null) {
          paramzzaov.zza(3, (zzapc)localObject);
        }
        i += 1;
      }
    }
    super.zza(paramzzaov);
  }
  
  public zza zzbd(zzaou paramzzaou)
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
        anW = Integer.valueOf(paramzzaou.N());
        break;
      case 18: 
        j = zzapf.zzc(paramzzaou, 18);
        if (anX == null) {}
        for (i = 0;; i = anX.length)
        {
          localObject = new zzun.zze[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(anX, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzun.zze();
            paramzzaou.zza(localObject[j]);
            paramzzaou.J();
            j += 1;
          }
        }
        localObject[j] = new zzun.zze();
        paramzzaou.zza(localObject[j]);
        anX = ((zzun.zze[])localObject);
        break;
      case 26: 
        j = zzapf.zzc(paramzzaou, 26);
        if (anY == null) {}
        for (i = 0;; i = anY.length)
        {
          localObject = new zzun.zzb[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(anY, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzun.zzb();
            paramzzaou.zza(localObject[j]);
            paramzzaou.J();
            j += 1;
          }
        }
        localObject[j] = new zzun.zzb();
        paramzzaou.zza(localObject[j]);
        anY = ((zzun.zzb[])localObject);
      }
    }
  }
  
  public zza zzbwa()
  {
    anW = null;
    anX = zzun.zze.zzbwg();
    anY = zzun.zzb.zzbwb();
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int m = 0;
    int i = super.zzy();
    int j = i;
    if (anW != null) {
      j = i + zzaov.zzag(1, anW.intValue());
    }
    i = j;
    Object localObject;
    if (anX != null)
    {
      i = j;
      if (anX.length > 0)
      {
        i = j;
        j = 0;
        while (j < anX.length)
        {
          localObject = anX[j];
          k = i;
          if (localObject != null) {
            k = i + zzaov.zzc(2, (zzapc)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    int k = i;
    if (anY != null)
    {
      k = i;
      if (anY.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= anY.length) {
            break;
          }
          localObject = anY[j];
          k = i;
          if (localObject != null) {
            k = i + zzaov.zzc(3, (zzapc)localObject);
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
 * Qualified Name:     com.google.android.gms.internal.zzun.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */