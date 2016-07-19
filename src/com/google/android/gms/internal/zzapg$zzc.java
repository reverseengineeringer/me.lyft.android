package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzapg$zzc
  extends zzaow<zzc>
  implements Cloneable
{
  public byte[] biB;
  public String biC;
  public byte[][] biD;
  public boolean biE;
  
  public zzapg$zzc()
  {
    at();
  }
  
  public zzc at()
  {
    biB = zzapf.bit;
    biC = "";
    biD = zzapf.bis;
    biE = false;
    bib = null;
    bik = -1;
    return this;
  }
  
  public zzc au()
  {
    try
    {
      zzc localzzc = (zzc)super.ac();
      if ((biD != null) && (biD.length > 0)) {
        biD = ((byte[][])biD.clone());
      }
      return localzzc;
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
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof zzc));
        paramObject = (zzc)paramObject;
        bool1 = bool2;
      } while (!Arrays.equals(biB, biB));
      if (biC != null) {
        break;
      }
      bool1 = bool2;
    } while (biC != null);
    while (biC.equals(biC))
    {
      bool1 = bool2;
      if (!zzapa.zza(biD, biD)) {
        break;
      }
      bool1 = bool2;
      if (biE != biE) {
        break;
      }
      if ((bib != null) && (!bib.isEmpty())) {
        break label140;
      }
      if (bib != null)
      {
        bool1 = bool2;
        if (!bib.isEmpty()) {
          break;
        }
      }
      return true;
    }
    return false;
    label140:
    return bib.equals(bib);
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = getClass().getName().hashCode();
    int i1 = Arrays.hashCode(biB);
    int i;
    int i2;
    int j;
    if (biC == null)
    {
      i = 0;
      i2 = zzapa.zzb(biD);
      if (!biE) {
        break label121;
      }
      j = 1231;
      label53:
      k = m;
      if (bib != null) {
        if (!bib.isEmpty()) {
          break label128;
        }
      }
    }
    label121:
    label128:
    for (int k = m;; k = bib.hashCode())
    {
      return (j + ((i + ((n + 527) * 31 + i1) * 31) * 31 + i2) * 31) * 31 + k;
      i = biC.hashCode();
      break;
      j = 1237;
      break label53;
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if (!Arrays.equals(biB, zzapf.bit)) {
      paramzzaov.zza(1, biB);
    }
    if ((biD != null) && (biD.length > 0))
    {
      int i = 0;
      while (i < biD.length)
      {
        byte[] arrayOfByte = biD[i];
        if (arrayOfByte != null) {
          paramzzaov.zza(2, arrayOfByte);
        }
        i += 1;
      }
    }
    if (biE) {
      paramzzaov.zzj(3, biE);
    }
    if (!biC.equals("")) {
      paramzzaov.zzr(4, biC);
    }
    super.zza(paramzzaov);
  }
  
  public zzc zzci(zzaou paramzzaou)
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
        biB = paramzzaou.readBytes();
        break;
      case 18: 
        int j = zzapf.zzc(paramzzaou, 18);
        if (biD == null) {}
        byte[][] arrayOfByte;
        for (i = 0;; i = biD.length)
        {
          arrayOfByte = new byte[j + i][];
          j = i;
          if (i != 0)
          {
            System.arraycopy(biD, 0, arrayOfByte, 0, i);
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
        biD = arrayOfByte;
        break;
      case 24: 
        biE = paramzzaou.P();
        break;
      case 34: 
        biC = paramzzaou.readString();
      }
    }
  }
  
  protected int zzy()
  {
    int n = 0;
    int j = super.zzy();
    int i = j;
    if (!Arrays.equals(biB, zzapf.bit)) {
      i = j + zzaov.zzb(1, biB);
    }
    j = i;
    if (biD != null)
    {
      j = i;
      if (biD.length > 0)
      {
        int k = 0;
        int m = 0;
        j = n;
        while (j < biD.length)
        {
          byte[] arrayOfByte = biD[j];
          int i1 = k;
          n = m;
          if (arrayOfByte != null)
          {
            n = m + 1;
            i1 = k + zzaov.zzbc(arrayOfByte);
          }
          j += 1;
          k = i1;
          m = n;
        }
        j = i + k + m * 1;
      }
    }
    i = j;
    if (biE) {
      i = j + zzaov.zzk(3, biE);
    }
    j = i;
    if (!biC.equals("")) {
      j = i + zzaov.zzs(4, biC);
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzapg.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */