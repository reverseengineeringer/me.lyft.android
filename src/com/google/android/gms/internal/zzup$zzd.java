package com.google.android.gms.internal;

import java.io.IOException;

public final class zzup$zzd
  extends zzapc
{
  public zzup.zze[] aoP;
  
  public zzup$zzd()
  {
    zzbwu();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzd)) {
        return false;
      }
      paramObject = (zzd)paramObject;
    } while (zzapa.equals(aoP, aoP));
    return false;
  }
  
  public int hashCode()
  {
    return (getClass().getName().hashCode() + 527) * 31 + zzapa.hashCode(aoP);
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if ((aoP != null) && (aoP.length > 0))
    {
      int i = 0;
      while (i < aoP.length)
      {
        zzup.zze localzze = aoP[i];
        if (localzze != null) {
          paramzzaov.zza(1, localzze);
        }
        i += 1;
      }
    }
    super.zza(paramzzaov);
  }
  
  public zzd zzbp(zzaou paramzzaou)
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
        if (aoP == null) {}
        zzup.zze[] arrayOfzze;
        for (i = 0;; i = aoP.length)
        {
          arrayOfzze = new zzup.zze[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(aoP, 0, arrayOfzze, 0, i);
            j = i;
          }
          while (j < arrayOfzze.length - 1)
          {
            arrayOfzze[j] = new zzup.zze();
            paramzzaou.zza(arrayOfzze[j]);
            paramzzaou.J();
            j += 1;
          }
        }
        arrayOfzze[j] = new zzup.zze();
        paramzzaou.zza(arrayOfzze[j]);
        aoP = arrayOfzze;
      }
    }
  }
  
  public zzd zzbwu()
  {
    aoP = zzup.zze.zzbwv();
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int i = super.zzy();
    int k = i;
    if (aoP != null)
    {
      k = i;
      if (aoP.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= aoP.length) {
            break;
          }
          zzup.zze localzze = aoP[j];
          k = i;
          if (localzze != null) {
            k = i + zzaov.zzc(1, localzze);
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
 * Qualified Name:     com.google.android.gms.internal.zzup.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */