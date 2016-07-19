package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;

public class zzaox<M extends zzaow<M>, T>
{
  protected final Class<T> bau;
  protected final boolean bic;
  public final int tag;
  protected final int type;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzaox)) {
        return false;
      }
      paramObject = (zzaox)paramObject;
    } while ((type == type) && (bau == bau) && (tag == tag) && (bic == bic));
    return false;
  }
  
  public int hashCode()
  {
    int j = type;
    int k = bau.hashCode();
    int m = tag;
    if (bic) {}
    for (int i = 1;; i = 0) {
      return i + (((j + 1147) * 31 + k) * 31 + m) * 31;
    }
  }
  
  void zza(Object paramObject, zzaov paramzzaov)
    throws IOException
  {
    if (bic)
    {
      zzc(paramObject, paramzzaov);
      return;
    }
    zzb(paramObject, paramzzaov);
  }
  
  protected void zzb(Object paramObject, zzaov paramzzaov)
  {
    for (;;)
    {
      try
      {
        paramzzaov.zzaes(tag);
        switch (type)
        {
        case 10: 
          i = type;
          throw new IllegalArgumentException(24 + "Unknown type " + i);
        }
      }
      catch (IOException paramObject)
      {
        throw new IllegalStateException((Throwable)paramObject);
      }
      paramObject = (zzapc)paramObject;
      int i = zzapf.zzafa(tag);
      paramzzaov.zzb((zzapc)paramObject);
      paramzzaov.zzai(i, 4);
      return;
      paramzzaov.zzc((zzapc)paramObject);
      return;
    }
  }
  
  protected void zzc(Object paramObject, zzaov paramzzaov)
  {
    int j = Array.getLength(paramObject);
    int i = 0;
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null) {
        zzb(localObject, paramzzaov);
      }
      i += 1;
    }
  }
  
  int zzcr(Object paramObject)
  {
    if (bic) {
      return zzcs(paramObject);
    }
    return zzct(paramObject);
  }
  
  protected int zzcs(Object paramObject)
  {
    int j = 0;
    int m = Array.getLength(paramObject);
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (Array.get(paramObject, i) != null) {
        k = j + zzct(Array.get(paramObject, i));
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  protected int zzct(Object paramObject)
  {
    int i = zzapf.zzafa(tag);
    switch (type)
    {
    default: 
      i = type;
      throw new IllegalArgumentException(24 + "Unknown type " + i);
    case 10: 
      return zzaov.zzb(i, (zzapc)paramObject);
    }
    return zzaov.zzc(i, (zzapc)paramObject);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaox
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */