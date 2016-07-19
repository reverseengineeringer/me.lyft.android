package com.google.android.gms.internal;

import java.io.IOException;

public final class zzup$zzf
  extends zzapc
{
  public long[] apq;
  public long[] apr;
  
  public zzup$zzf()
  {
    zzbwx();
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
      if (!zzapa.equals(apq, apq)) {
        return false;
      }
    } while (zzapa.equals(apr, apr));
    return false;
  }
  
  public int hashCode()
  {
    return ((getClass().getName().hashCode() + 527) * 31 + zzapa.hashCode(apq)) * 31 + zzapa.hashCode(apr);
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    int j = 0;
    int i;
    if ((apq != null) && (apq.length > 0))
    {
      i = 0;
      while (i < apq.length)
      {
        paramzzaov.zza(1, apq[i]);
        i += 1;
      }
    }
    if ((apr != null) && (apr.length > 0))
    {
      i = j;
      while (i < apr.length)
      {
        paramzzaov.zza(2, apr[i]);
        i += 1;
      }
    }
    super.zza(paramzzaov);
  }
  
  public zzf zzbr(zzaou paramzzaou)
    throws IOException
  {
    for (;;)
    {
      int i = paramzzaou.J();
      int j;
      long[] arrayOfLong;
      int k;
      switch (i)
      {
      default: 
        if (zzapf.zzb(paramzzaou, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        j = zzapf.zzc(paramzzaou, 8);
        if (apq == null) {}
        for (i = 0;; i = apq.length)
        {
          arrayOfLong = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(apq, 0, arrayOfLong, 0, i);
            j = i;
          }
          while (j < arrayOfLong.length - 1)
          {
            arrayOfLong[j] = paramzzaou.L();
            paramzzaou.J();
            j += 1;
          }
        }
        arrayOfLong[j] = paramzzaou.L();
        apq = arrayOfLong;
        break;
      case 10: 
        k = paramzzaou.zzaei(paramzzaou.S());
        i = paramzzaou.getPosition();
        j = 0;
        while (paramzzaou.X() > 0)
        {
          paramzzaou.L();
          j += 1;
        }
        paramzzaou.zzaek(i);
        if (apq == null) {}
        for (i = 0;; i = apq.length)
        {
          arrayOfLong = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(apq, 0, arrayOfLong, 0, i);
            j = i;
          }
          while (j < arrayOfLong.length)
          {
            arrayOfLong[j] = paramzzaou.L();
            j += 1;
          }
        }
        apq = arrayOfLong;
        paramzzaou.zzaej(k);
        break;
      case 16: 
        j = zzapf.zzc(paramzzaou, 16);
        if (apr == null) {}
        for (i = 0;; i = apr.length)
        {
          arrayOfLong = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(apr, 0, arrayOfLong, 0, i);
            j = i;
          }
          while (j < arrayOfLong.length - 1)
          {
            arrayOfLong[j] = paramzzaou.L();
            paramzzaou.J();
            j += 1;
          }
        }
        arrayOfLong[j] = paramzzaou.L();
        apr = arrayOfLong;
        break;
      case 18: 
        k = paramzzaou.zzaei(paramzzaou.S());
        i = paramzzaou.getPosition();
        j = 0;
        while (paramzzaou.X() > 0)
        {
          paramzzaou.L();
          j += 1;
        }
        paramzzaou.zzaek(i);
        if (apr == null) {}
        for (i = 0;; i = apr.length)
        {
          arrayOfLong = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(apr, 0, arrayOfLong, 0, i);
            j = i;
          }
          while (j < arrayOfLong.length)
          {
            arrayOfLong[j] = paramzzaou.L();
            j += 1;
          }
        }
        apr = arrayOfLong;
        paramzzaou.zzaej(k);
      }
    }
  }
  
  public zzf zzbwx()
  {
    apq = zzapf.bin;
    apr = zzapf.bin;
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int m = 0;
    int k = super.zzy();
    int j;
    if ((apq != null) && (apq.length > 0))
    {
      i = 0;
      j = 0;
      while (i < apq.length)
      {
        j += zzaov.zzcv(apq[i]);
        i += 1;
      }
    }
    for (int i = k + j + apq.length * 1;; i = k)
    {
      j = i;
      if (apr != null)
      {
        j = i;
        if (apr.length > 0)
        {
          k = 0;
          j = m;
          while (j < apr.length)
          {
            k += zzaov.zzcv(apr[j]);
            j += 1;
          }
          j = i + k + apr.length * 1;
        }
      }
      return j;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzup.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */