package com.google.android.gms.internal;

import java.io.IOException;

public final class zzapg$zza
  extends zzaow<zza>
  implements Cloneable
{
  public String[] biu;
  public String[] biv;
  public int[] biw;
  public long[] bix;
  public long[] biy;
  
  public zzapg$zza()
  {
    ap();
  }
  
  public zza ap()
  {
    biu = zzapf.bir;
    biv = zzapf.bir;
    biw = zzapf.bim;
    bix = zzapf.bin;
    biy = zzapf.bin;
    bib = null;
    bik = -1;
    return this;
  }
  
  public zza aq()
  {
    try
    {
      zza localzza = (zza)super.ac();
      if ((biu != null) && (biu.length > 0)) {
        biu = ((String[])biu.clone());
      }
      if ((biv != null) && (biv.length > 0)) {
        biv = ((String[])biv.clone());
      }
      if ((biw != null) && (biw.length > 0)) {
        biw = ((int[])biw.clone());
      }
      if ((bix != null) && (bix.length > 0)) {
        bix = ((long[])bix.clone());
      }
      if ((biy != null) && (biy.length > 0)) {
        biy = ((long[])biy.clone());
      }
      return localzza;
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
                } while (!(paramObject instanceof zza));
                paramObject = (zza)paramObject;
                bool1 = bool2;
              } while (!zzapa.equals(biu, biu));
              bool1 = bool2;
            } while (!zzapa.equals(biv, biv));
            bool1 = bool2;
          } while (!zzapa.equals(biw, biw));
          bool1 = bool2;
        } while (!zzapa.equals(bix, bix));
        bool1 = bool2;
      } while (!zzapa.equals(biy, biy));
      if ((bib != null) && (!bib.isEmpty())) {
        break label143;
      }
      if (bib == null) {
        break;
      }
      bool1 = bool2;
    } while (!bib.isEmpty());
    return true;
    label143:
    return bib.equals(bib);
  }
  
  public int hashCode()
  {
    int j = getClass().getName().hashCode();
    int k = zzapa.hashCode(biu);
    int m = zzapa.hashCode(biv);
    int n = zzapa.hashCode(biw);
    int i1 = zzapa.hashCode(bix);
    int i2 = zzapa.hashCode(biy);
    if ((bib == null) || (bib.isEmpty())) {}
    for (int i = 0;; i = bib.hashCode()) {
      return i + ((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31;
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    int j = 0;
    int i;
    String str;
    if ((biu != null) && (biu.length > 0))
    {
      i = 0;
      while (i < biu.length)
      {
        str = biu[i];
        if (str != null) {
          paramzzaov.zzr(1, str);
        }
        i += 1;
      }
    }
    if ((biv != null) && (biv.length > 0))
    {
      i = 0;
      while (i < biv.length)
      {
        str = biv[i];
        if (str != null) {
          paramzzaov.zzr(2, str);
        }
        i += 1;
      }
    }
    if ((biw != null) && (biw.length > 0))
    {
      i = 0;
      while (i < biw.length)
      {
        paramzzaov.zzae(3, biw[i]);
        i += 1;
      }
    }
    if ((bix != null) && (bix.length > 0))
    {
      i = 0;
      while (i < bix.length)
      {
        paramzzaov.zzb(4, bix[i]);
        i += 1;
      }
    }
    if ((biy != null) && (biy.length > 0))
    {
      i = j;
      while (i < biy.length)
      {
        paramzzaov.zzb(5, biy[i]);
        i += 1;
      }
    }
    super.zza(paramzzaov);
  }
  
  public zza zzcg(zzaou paramzzaou)
    throws IOException
  {
    for (;;)
    {
      int i = paramzzaou.J();
      int j;
      Object localObject;
      int k;
      switch (i)
      {
      default: 
        if (super.zza(paramzzaou, i)) {}
        break;
      case 0: 
        return this;
      case 10: 
        j = zzapf.zzc(paramzzaou, 10);
        if (biu == null) {}
        for (i = 0;; i = biu.length)
        {
          localObject = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(biu, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzaou.readString();
            paramzzaou.J();
            j += 1;
          }
        }
        localObject[j] = paramzzaou.readString();
        biu = ((String[])localObject);
        break;
      case 18: 
        j = zzapf.zzc(paramzzaou, 18);
        if (biv == null) {}
        for (i = 0;; i = biv.length)
        {
          localObject = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(biv, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzaou.readString();
            paramzzaou.J();
            j += 1;
          }
        }
        localObject[j] = paramzzaou.readString();
        biv = ((String[])localObject);
        break;
      case 24: 
        j = zzapf.zzc(paramzzaou, 24);
        if (biw == null) {}
        for (i = 0;; i = biw.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(biw, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzaou.N();
            paramzzaou.J();
            j += 1;
          }
        }
        localObject[j] = paramzzaou.N();
        biw = ((int[])localObject);
        break;
      case 26: 
        k = paramzzaou.zzaei(paramzzaou.S());
        i = paramzzaou.getPosition();
        j = 0;
        while (paramzzaou.X() > 0)
        {
          paramzzaou.N();
          j += 1;
        }
        paramzzaou.zzaek(i);
        if (biw == null) {}
        for (i = 0;; i = biw.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(biw, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramzzaou.N();
            j += 1;
          }
        }
        biw = ((int[])localObject);
        paramzzaou.zzaej(k);
        break;
      case 32: 
        j = zzapf.zzc(paramzzaou, 32);
        if (bix == null) {}
        for (i = 0;; i = bix.length)
        {
          localObject = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(bix, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzaou.M();
            paramzzaou.J();
            j += 1;
          }
        }
        localObject[j] = paramzzaou.M();
        bix = ((long[])localObject);
        break;
      case 34: 
        k = paramzzaou.zzaei(paramzzaou.S());
        i = paramzzaou.getPosition();
        j = 0;
        while (paramzzaou.X() > 0)
        {
          paramzzaou.M();
          j += 1;
        }
        paramzzaou.zzaek(i);
        if (bix == null) {}
        for (i = 0;; i = bix.length)
        {
          localObject = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(bix, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramzzaou.M();
            j += 1;
          }
        }
        bix = ((long[])localObject);
        paramzzaou.zzaej(k);
        break;
      case 40: 
        j = zzapf.zzc(paramzzaou, 40);
        if (biy == null) {}
        for (i = 0;; i = biy.length)
        {
          localObject = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(biy, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzaou.M();
            paramzzaou.J();
            j += 1;
          }
        }
        localObject[j] = paramzzaou.M();
        biy = ((long[])localObject);
        break;
      case 42: 
        k = paramzzaou.zzaei(paramzzaou.S());
        i = paramzzaou.getPosition();
        j = 0;
        while (paramzzaou.X() > 0)
        {
          paramzzaou.M();
          j += 1;
        }
        paramzzaou.zzaek(i);
        if (biy == null) {}
        for (i = 0;; i = biy.length)
        {
          localObject = new long[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(biy, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramzzaou.M();
            j += 1;
          }
        }
        biy = ((long[])localObject);
        paramzzaou.zzaej(k);
      }
    }
  }
  
  protected int zzy()
  {
    int i2 = 0;
    int i1 = super.zzy();
    int j;
    int k;
    String str;
    int n;
    int m;
    if ((biu != null) && (biu.length > 0))
    {
      i = 0;
      j = 0;
      for (k = 0; i < biu.length; k = m)
      {
        str = biu[i];
        n = j;
        m = k;
        if (str != null)
        {
          m = k + 1;
          n = j + zzaov.zztg(str);
        }
        i += 1;
        j = n;
      }
    }
    for (int i = i1 + j + k * 1;; i = i1)
    {
      j = i;
      if (biv != null)
      {
        j = i;
        if (biv.length > 0)
        {
          j = 0;
          k = 0;
          for (m = 0; j < biv.length; m = n)
          {
            str = biv[j];
            i1 = k;
            n = m;
            if (str != null)
            {
              n = m + 1;
              i1 = k + zzaov.zztg(str);
            }
            j += 1;
            k = i1;
          }
          j = i + k + m * 1;
        }
      }
      i = j;
      if (biw != null)
      {
        i = j;
        if (biw.length > 0)
        {
          i = 0;
          k = 0;
          while (i < biw.length)
          {
            k += zzaov.zzaeo(biw[i]);
            i += 1;
          }
          i = j + k + biw.length * 1;
        }
      }
      j = i;
      if (bix != null)
      {
        j = i;
        if (bix.length > 0)
        {
          j = 0;
          k = 0;
          while (j < bix.length)
          {
            k += zzaov.zzcw(bix[j]);
            j += 1;
          }
          j = i + k + bix.length * 1;
        }
      }
      i = j;
      if (biy != null)
      {
        i = j;
        if (biy.length > 0)
        {
          k = 0;
          i = i2;
          while (i < biy.length)
          {
            k += zzaov.zzcw(biy[i]);
            i += 1;
          }
          i = j + k + biy.length * 1;
        }
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzapg.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */