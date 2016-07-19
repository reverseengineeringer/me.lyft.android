package com.google.android.gms.internal;

import java.io.IOException;

public final class zzae$zzf
  extends zzaow<zzf>
{
  public byte[] zzet = null;
  public byte[][] zzey = zzapf.bis;
  public Integer zzez = null;
  public Integer zzfa = null;
  
  public zzae$zzf()
  {
    bik = -1;
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if ((zzey != null) && (zzey.length > 0))
    {
      int i = 0;
      while (i < zzey.length)
      {
        byte[] arrayOfByte = zzey[i];
        if (arrayOfByte != null) {
          paramzzaov.zza(1, arrayOfByte);
        }
        i += 1;
      }
    }
    if (zzet != null) {
      paramzzaov.zza(2, zzet);
    }
    if (zzez != null) {
      paramzzaov.zzae(3, zzez.intValue());
    }
    if (zzfa != null) {
      paramzzaov.zzae(4, zzfa.intValue());
    }
    super.zza(paramzzaov);
  }
  
  public zzf zzi(zzaou paramzzaou)
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
      case 10: 
        int j = zzapf.zzc(paramzzaou, 10);
        if (zzey == null) {}
        byte[][] arrayOfByte;
        for (i = 0;; i = zzey.length)
        {
          arrayOfByte = new byte[j + i][];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzey, 0, arrayOfByte, 0, i);
            j = i;
          }
          while (j < arrayOfByte.length - 1)
          {
            arrayOfByte[j] = paramzzaou.readBytes();
            paramzzaou.J();
            j += 1;
          }
        }
        arrayOfByte[j] = paramzzaou.readBytes();
        zzey = arrayOfByte;
        break;
      case 18: 
        zzet = paramzzaou.readBytes();
        break;
      case 24: 
        i = paramzzaou.N();
        switch (i)
        {
        default: 
          break;
        case 0: 
        case 1: 
          zzez = Integer.valueOf(i);
        }
        break;
      case 32: 
        i = paramzzaou.N();
        switch (i)
        {
        default: 
          break;
        case 0: 
        case 1: 
          zzfa = Integer.valueOf(i);
        }
        break;
      }
    }
  }
  
  protected int zzy()
  {
    int i = 0;
    int i1 = super.zzy();
    int k;
    if ((zzey != null) && (zzey.length > 0))
    {
      j = 0;
      int m;
      for (k = 0; i < zzey.length; k = m)
      {
        byte[] arrayOfByte = zzey[i];
        int n = j;
        m = k;
        if (arrayOfByte != null)
        {
          m = k + 1;
          n = j + zzaov.zzbc(arrayOfByte);
        }
        i += 1;
        j = n;
      }
    }
    for (int j = i1 + j + k * 1;; j = i1)
    {
      i = j;
      if (zzet != null) {
        i = j + zzaov.zzb(2, zzet);
      }
      j = i;
      if (zzez != null) {
        j = i + zzaov.zzag(3, zzez.intValue());
      }
      i = j;
      if (zzfa != null) {
        i = j + zzaov.zzag(4, zzfa.intValue());
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzae.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */