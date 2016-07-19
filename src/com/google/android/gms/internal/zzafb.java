package com.google.android.gms.internal;

import java.io.IOException;

public final class zzafb
  extends zzaow<zzafb>
{
  public String[] aMI;
  public int[] aMJ;
  public byte[][] aMK;
  
  public zzafb()
  {
    zzcjy();
  }
  
  public static zzafb zzas(byte[] paramArrayOfByte)
    throws zzapb
  {
    return (zzafb)zzapc.zza(new zzafb(), paramArrayOfByte);
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
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof zzafb));
            paramObject = (zzafb)paramObject;
            bool1 = bool2;
          } while (!zzapa.equals(aMI, aMI));
          bool1 = bool2;
        } while (!zzapa.equals(aMJ, aMJ));
        bool1 = bool2;
      } while (!zzapa.zza(aMK, aMK));
      if ((bib != null) && (!bib.isEmpty())) {
        break label111;
      }
      if (bib == null) {
        break;
      }
      bool1 = bool2;
    } while (!bib.isEmpty());
    return true;
    label111:
    return bib.equals(bib);
  }
  
  public int hashCode()
  {
    int j = getClass().getName().hashCode();
    int k = zzapa.hashCode(aMI);
    int m = zzapa.hashCode(aMJ);
    int n = zzapa.zzb(aMK);
    if ((bib == null) || (bib.isEmpty())) {}
    for (int i = 0;; i = bib.hashCode()) {
      return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    int j = 0;
    int i;
    Object localObject;
    if ((aMI != null) && (aMI.length > 0))
    {
      i = 0;
      while (i < aMI.length)
      {
        localObject = aMI[i];
        if (localObject != null) {
          paramzzaov.zzr(1, (String)localObject);
        }
        i += 1;
      }
    }
    if ((aMJ != null) && (aMJ.length > 0))
    {
      i = 0;
      while (i < aMJ.length)
      {
        paramzzaov.zzae(2, aMJ[i]);
        i += 1;
      }
    }
    if ((aMK != null) && (aMK.length > 0))
    {
      i = j;
      while (i < aMK.length)
      {
        localObject = aMK[i];
        if (localObject != null) {
          paramzzaov.zza(3, (byte[])localObject);
        }
        i += 1;
      }
    }
    super.zza(paramzzaov);
  }
  
  public zzafb zzby(zzaou paramzzaou)
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
        if (super.zza(paramzzaou, i)) {}
        break;
      case 0: 
        return this;
      case 10: 
        j = zzapf.zzc(paramzzaou, 10);
        if (aMI == null) {}
        for (i = 0;; i = aMI.length)
        {
          localObject = new String[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(aMI, 0, localObject, 0, i);
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
        aMI = ((String[])localObject);
        break;
      case 16: 
        j = zzapf.zzc(paramzzaou, 16);
        if (aMJ == null) {}
        for (i = 0;; i = aMJ.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(aMJ, 0, localObject, 0, i);
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
        aMJ = ((int[])localObject);
        break;
      case 18: 
        int k = paramzzaou.zzaei(paramzzaou.S());
        i = paramzzaou.getPosition();
        j = 0;
        while (paramzzaou.X() > 0)
        {
          paramzzaou.N();
          j += 1;
        }
        paramzzaou.zzaek(i);
        if (aMJ == null) {}
        for (i = 0;; i = aMJ.length)
        {
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(aMJ, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramzzaou.N();
            j += 1;
          }
        }
        aMJ = ((int[])localObject);
        paramzzaou.zzaej(k);
        break;
      case 26: 
        j = zzapf.zzc(paramzzaou, 26);
        if (aMK == null) {}
        for (i = 0;; i = aMK.length)
        {
          localObject = new byte[j + i][];
          j = i;
          if (i != 0)
          {
            System.arraycopy(aMK, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = paramzzaou.readBytes();
            paramzzaou.J();
            j += 1;
          }
        }
        localObject[j] = paramzzaou.readBytes();
        aMK = ((byte[][])localObject);
      }
    }
  }
  
  public zzafb zzcjy()
  {
    aMI = zzapf.bir;
    aMJ = zzapf.bim;
    aMK = zzapf.bis;
    bib = null;
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int i1 = 0;
    int i2 = super.zzy();
    int i;
    int k;
    Object localObject;
    int n;
    int m;
    if ((aMI != null) && (aMI.length > 0))
    {
      i = 0;
      j = 0;
      for (k = 0; i < aMI.length; k = m)
      {
        localObject = aMI[i];
        n = j;
        m = k;
        if (localObject != null)
        {
          m = k + 1;
          n = j + zzaov.zztg((String)localObject);
        }
        i += 1;
        j = n;
      }
    }
    for (int j = i2 + j + k * 1;; j = i2)
    {
      i = j;
      if (aMJ != null)
      {
        i = j;
        if (aMJ.length > 0)
        {
          i = 0;
          k = 0;
          while (i < aMJ.length)
          {
            k += zzaov.zzaeo(aMJ[i]);
            i += 1;
          }
          i = j + k + aMJ.length * 1;
        }
      }
      j = i;
      if (aMK != null)
      {
        j = i;
        if (aMK.length > 0)
        {
          k = 0;
          m = 0;
          j = i1;
          while (j < aMK.length)
          {
            localObject = aMK[j];
            i1 = k;
            n = m;
            if (localObject != null)
            {
              n = m + 1;
              i1 = k + zzaov.zzbc((byte[])localObject);
            }
            j += 1;
            k = i1;
            m = n;
          }
          j = i + k + m * 1;
        }
      }
      return j;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzafb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */