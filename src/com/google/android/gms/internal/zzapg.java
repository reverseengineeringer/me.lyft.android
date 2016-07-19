package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public abstract interface zzapg
{
  public static final class zza
    extends zzaow<zza>
    implements Cloneable
  {
    public String[] biu;
    public String[] biv;
    public int[] biw;
    public long[] bix;
    public long[] biy;
    
    public zza()
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
  
  public static final class zzb
    extends zzaow<zzb>
    implements Cloneable
  {
    public String biA;
    public int biz;
    public String version;
    
    public zzb()
    {
      ar();
    }
    
    public zzb ar()
    {
      biz = 0;
      biA = "";
      version = "";
      bib = null;
      bik = -1;
      return this;
    }
    
    public zzb as()
    {
      try
      {
        zzb localzzb = (zzb)super.ac();
        return localzzb;
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
      label54:
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
            } while (!(paramObject instanceof zzb));
            paramObject = (zzb)paramObject;
            bool1 = bool2;
          } while (biz != biz);
          if (biA != null) {
            break;
          }
          bool1 = bool2;
        } while (biA != null);
        if (version != null) {
          break label124;
        }
        bool1 = bool2;
      } while (version != null);
      for (;;)
      {
        if ((bib == null) || (bib.isEmpty()))
        {
          if (bib != null)
          {
            bool1 = bool2;
            if (!bib.isEmpty()) {
              break;
            }
          }
          return true;
          if (biA.equals(biA)) {
            break label54;
          }
          return false;
          label124:
          if (!version.equals(version)) {
            return false;
          }
        }
      }
      return bib.equals(bib);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = biz;
      int i;
      int j;
      if (biA == null)
      {
        i = 0;
        if (version != null) {
          break label101;
        }
        j = 0;
        label39:
        k = m;
        if (bib != null) {
          if (!bib.isEmpty()) {
            break label112;
          }
        }
      }
      label101:
      label112:
      for (int k = m;; k = bib.hashCode())
      {
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
        i = biA.hashCode();
        break;
        j = version.hashCode();
        break label39;
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      if (biz != 0) {
        paramzzaov.zzae(1, biz);
      }
      if (!biA.equals("")) {
        paramzzaov.zzr(2, biA);
      }
      if (!version.equals("")) {
        paramzzaov.zzr(3, version);
      }
      super.zza(paramzzaov);
    }
    
    public zzb zzch(zzaou paramzzaou)
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
        case 8: 
          biz = paramzzaou.N();
          break;
        case 18: 
          biA = paramzzaou.readString();
          break;
        case 26: 
          version = paramzzaou.readString();
        }
      }
    }
    
    protected int zzy()
    {
      int j = super.zzy();
      int i = j;
      if (biz != 0) {
        i = j + zzaov.zzag(1, biz);
      }
      j = i;
      if (!biA.equals("")) {
        j = i + zzaov.zzs(2, biA);
      }
      i = j;
      if (!version.equals("")) {
        i = j + zzaov.zzs(3, version);
      }
      return i;
    }
  }
  
  public static final class zzc
    extends zzaow<zzc>
    implements Cloneable
  {
    public byte[] biB;
    public String biC;
    public byte[][] biD;
    public boolean biE;
    
    public zzc()
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
  
  public static final class zzd
    extends zzaow<zzd>
    implements Cloneable
  {
    public boolean aTD;
    public long biF;
    public long biG;
    public long biH;
    public int biI;
    public zzapg.zze[] biJ;
    public byte[] biK;
    public zzapg.zzb biL;
    public byte[] biM;
    public String biN;
    public String biO;
    public zzapg.zza biP;
    public String biQ;
    public long biR;
    public zzapg.zzc biS;
    public byte[] biT;
    public String biU;
    public int biV;
    public int[] biW;
    public long biX;
    public zzapg.zzf biY;
    public String tag;
    public int zzahl;
    
    public zzd()
    {
      av();
    }
    
    public zzd av()
    {
      biF = 0L;
      biG = 0L;
      biH = 0L;
      tag = "";
      biI = 0;
      zzahl = 0;
      aTD = false;
      biJ = zzapg.zze.ax();
      biK = zzapf.bit;
      biL = null;
      biM = zzapf.bit;
      biN = "";
      biO = "";
      biP = null;
      biQ = "";
      biR = 180000L;
      biS = null;
      biT = zzapf.bit;
      biU = "";
      biV = 0;
      biW = zzapf.bim;
      biX = 0L;
      biY = null;
      bib = null;
      bik = -1;
      return this;
    }
    
    public zzd aw()
    {
      try
      {
        zzd localzzd = (zzd)super.ac();
        if ((biJ != null) && (biJ.length > 0))
        {
          biJ = new zzapg.zze[biJ.length];
          int i = 0;
          while (i < biJ.length)
          {
            if (biJ[i] != null) {
              biJ[i] = ((zzapg.zze)biJ[i].clone());
            }
            i += 1;
          }
        }
        if (biL == null) {
          break label111;
        }
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError(localCloneNotSupportedException);
      }
      biL = ((zzapg.zzb)biL.clone());
      label111:
      if (biP != null) {
        biP = ((zzapg.zza)biP.clone());
      }
      if (biS != null) {
        biS = ((zzapg.zzc)biS.clone());
      }
      if ((biW != null) && (biW.length > 0)) {
        biW = ((int[])biW.clone());
      }
      if (biY != null) {
        biY = ((zzapg.zzf)biY.clone());
      }
      return localCloneNotSupportedException;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label83:
      label170:
      label202:
      label218:
      label234:
      label250:
      label280:
      label312:
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
                                                do
                                                {
                                                  do
                                                  {
                                                    do
                                                    {
                                                      return bool1;
                                                      bool1 = bool2;
                                                    } while (!(paramObject instanceof zzd));
                                                    paramObject = (zzd)paramObject;
                                                    bool1 = bool2;
                                                  } while (biF != biF);
                                                  bool1 = bool2;
                                                } while (biG != biG);
                                                bool1 = bool2;
                                              } while (biH != biH);
                                              if (tag != null) {
                                                break;
                                              }
                                              bool1 = bool2;
                                            } while (tag != null);
                                            bool1 = bool2;
                                          } while (biI != biI);
                                          bool1 = bool2;
                                        } while (zzahl != zzahl);
                                        bool1 = bool2;
                                      } while (aTD != aTD);
                                      bool1 = bool2;
                                    } while (!zzapa.equals(biJ, biJ));
                                    bool1 = bool2;
                                  } while (!Arrays.equals(biK, biK));
                                  if (biL != null) {
                                    break label425;
                                  }
                                  bool1 = bool2;
                                } while (biL != null);
                                bool1 = bool2;
                              } while (!Arrays.equals(biM, biM));
                              if (biN != null) {
                                break label441;
                              }
                              bool1 = bool2;
                            } while (biN != null);
                            if (biO != null) {
                              break label457;
                            }
                            bool1 = bool2;
                          } while (biO != null);
                          if (biP != null) {
                            break label473;
                          }
                          bool1 = bool2;
                        } while (biP != null);
                        if (biQ != null) {
                          break label489;
                        }
                        bool1 = bool2;
                      } while (biQ != null);
                      bool1 = bool2;
                    } while (biR != biR);
                    if (biS != null) {
                      break label505;
                    }
                    bool1 = bool2;
                  } while (biS != null);
                  bool1 = bool2;
                } while (!Arrays.equals(biT, biT));
                if (biU != null) {
                  break label521;
                }
                bool1 = bool2;
              } while (biU != null);
              bool1 = bool2;
            } while (biV != biV);
            bool1 = bool2;
          } while (!zzapa.equals(biW, biW));
          bool1 = bool2;
        } while (biX != biX);
        if (biY != null) {
          break label537;
        }
        bool1 = bool2;
      } while (biY != null);
      for (;;)
      {
        if ((bib == null) || (bib.isEmpty()))
        {
          if (bib != null)
          {
            bool1 = bool2;
            if (!bib.isEmpty()) {
              break;
            }
          }
          return true;
          if (tag.equals(tag)) {
            break label83;
          }
          return false;
          label425:
          if (biL.equals(biL)) {
            break label170;
          }
          return false;
          label441:
          if (biN.equals(biN)) {
            break label202;
          }
          return false;
          label457:
          if (biO.equals(biO)) {
            break label218;
          }
          return false;
          label473:
          if (biP.equals(biP)) {
            break label234;
          }
          return false;
          label489:
          if (biQ.equals(biQ)) {
            break label250;
          }
          return false;
          label505:
          if (biS.equals(biS)) {
            break label280;
          }
          return false;
          label521:
          if (biU.equals(biU)) {
            break label312;
          }
          return false;
          label537:
          if (!biY.equals(biY)) {
            return false;
          }
        }
      }
      return bib.equals(bib);
    }
    
    public int hashCode()
    {
      int i7 = 0;
      int i8 = getClass().getName().hashCode();
      int i9 = (int)(biF ^ biF >>> 32);
      int i10 = (int)(biG ^ biG >>> 32);
      int i11 = (int)(biH ^ biH >>> 32);
      int i;
      int i12;
      int i13;
      int j;
      label92:
      int i14;
      int i15;
      int k;
      label119:
      int i16;
      int m;
      label138:
      int n;
      label148:
      int i1;
      label158:
      int i2;
      label168:
      int i17;
      int i3;
      label193:
      int i18;
      int i4;
      label212:
      int i19;
      int i20;
      int i21;
      int i5;
      if (tag == null)
      {
        i = 0;
        i12 = biI;
        i13 = zzahl;
        if (!aTD) {
          break label436;
        }
        j = 1231;
        i14 = zzapa.hashCode(biJ);
        i15 = Arrays.hashCode(biK);
        if (biL != null) {
          break label443;
        }
        k = 0;
        i16 = Arrays.hashCode(biM);
        if (biN != null) {
          break label454;
        }
        m = 0;
        if (biO != null) {
          break label466;
        }
        n = 0;
        if (biP != null) {
          break label478;
        }
        i1 = 0;
        if (biQ != null) {
          break label490;
        }
        i2 = 0;
        i17 = (int)(biR ^ biR >>> 32);
        if (biS != null) {
          break label502;
        }
        i3 = 0;
        i18 = Arrays.hashCode(biT);
        if (biU != null) {
          break label514;
        }
        i4 = 0;
        i19 = biV;
        i20 = zzapa.hashCode(biW);
        i21 = (int)(biX ^ biX >>> 32);
        if (biY != null) {
          break label526;
        }
        i5 = 0;
        label252:
        i6 = i7;
        if (bib != null) {
          if (!bib.isEmpty()) {
            break label538;
          }
        }
      }
      label436:
      label443:
      label454:
      label466:
      label478:
      label490:
      label502:
      label514:
      label526:
      label538:
      for (int i6 = i7;; i6 = bib.hashCode())
      {
        return (i5 + ((((i4 + ((i3 + ((i2 + (i1 + (n + (m + ((k + (((j + (((i + ((((i8 + 527) * 31 + i9) * 31 + i10) * 31 + i11) * 31) * 31 + i12) * 31 + i13) * 31) * 31 + i14) * 31 + i15) * 31) * 31 + i16) * 31) * 31) * 31) * 31) * 31 + i17) * 31) * 31 + i18) * 31) * 31 + i19) * 31 + i20) * 31 + i21) * 31) * 31 + i6;
        i = tag.hashCode();
        break;
        j = 1237;
        break label92;
        k = biL.hashCode();
        break label119;
        m = biN.hashCode();
        break label138;
        n = biO.hashCode();
        break label148;
        i1 = biP.hashCode();
        break label158;
        i2 = biQ.hashCode();
        break label168;
        i3 = biS.hashCode();
        break label193;
        i4 = biU.hashCode();
        break label212;
        i5 = biY.hashCode();
        break label252;
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      int j = 0;
      if (biF != 0L) {
        paramzzaov.zzb(1, biF);
      }
      if (!tag.equals("")) {
        paramzzaov.zzr(2, tag);
      }
      int i;
      if ((biJ != null) && (biJ.length > 0))
      {
        i = 0;
        while (i < biJ.length)
        {
          zzapg.zze localzze = biJ[i];
          if (localzze != null) {
            paramzzaov.zza(3, localzze);
          }
          i += 1;
        }
      }
      if (!Arrays.equals(biK, zzapf.bit)) {
        paramzzaov.zza(4, biK);
      }
      if (!Arrays.equals(biM, zzapf.bit)) {
        paramzzaov.zza(6, biM);
      }
      if (biP != null) {
        paramzzaov.zza(7, biP);
      }
      if (!biN.equals("")) {
        paramzzaov.zzr(8, biN);
      }
      if (biL != null) {
        paramzzaov.zza(9, biL);
      }
      if (aTD) {
        paramzzaov.zzj(10, aTD);
      }
      if (biI != 0) {
        paramzzaov.zzae(11, biI);
      }
      if (zzahl != 0) {
        paramzzaov.zzae(12, zzahl);
      }
      if (!biO.equals("")) {
        paramzzaov.zzr(13, biO);
      }
      if (!biQ.equals("")) {
        paramzzaov.zzr(14, biQ);
      }
      if (biR != 180000L) {
        paramzzaov.zzd(15, biR);
      }
      if (biS != null) {
        paramzzaov.zza(16, biS);
      }
      if (biG != 0L) {
        paramzzaov.zzb(17, biG);
      }
      if (!Arrays.equals(biT, zzapf.bit)) {
        paramzzaov.zza(18, biT);
      }
      if (biV != 0) {
        paramzzaov.zzae(19, biV);
      }
      if ((biW != null) && (biW.length > 0))
      {
        i = j;
        while (i < biW.length)
        {
          paramzzaov.zzae(20, biW[i]);
          i += 1;
        }
      }
      if (biH != 0L) {
        paramzzaov.zzb(21, biH);
      }
      if (biX != 0L) {
        paramzzaov.zzb(22, biX);
      }
      if (biY != null) {
        paramzzaov.zza(23, biY);
      }
      if (!biU.equals("")) {
        paramzzaov.zzr(24, biU);
      }
      super.zza(paramzzaov);
    }
    
    public zzd zzcj(zzaou paramzzaou)
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
        case 8: 
          biF = paramzzaou.M();
          break;
        case 18: 
          tag = paramzzaou.readString();
          break;
        case 26: 
          j = zzapf.zzc(paramzzaou, 26);
          if (biJ == null) {}
          for (i = 0;; i = biJ.length)
          {
            localObject = new zzapg.zze[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(biJ, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzapg.zze();
              paramzzaou.zza(localObject[j]);
              paramzzaou.J();
              j += 1;
            }
          }
          localObject[j] = new zzapg.zze();
          paramzzaou.zza(localObject[j]);
          biJ = ((zzapg.zze[])localObject);
          break;
        case 34: 
          biK = paramzzaou.readBytes();
          break;
        case 50: 
          biM = paramzzaou.readBytes();
          break;
        case 58: 
          if (biP == null) {
            biP = new zzapg.zza();
          }
          paramzzaou.zza(biP);
          break;
        case 66: 
          biN = paramzzaou.readString();
          break;
        case 74: 
          if (biL == null) {
            biL = new zzapg.zzb();
          }
          paramzzaou.zza(biL);
          break;
        case 80: 
          aTD = paramzzaou.P();
          break;
        case 88: 
          biI = paramzzaou.N();
          break;
        case 96: 
          zzahl = paramzzaou.N();
          break;
        case 106: 
          biO = paramzzaou.readString();
          break;
        case 114: 
          biQ = paramzzaou.readString();
          break;
        case 120: 
          biR = paramzzaou.R();
          break;
        case 130: 
          if (biS == null) {
            biS = new zzapg.zzc();
          }
          paramzzaou.zza(biS);
          break;
        case 136: 
          biG = paramzzaou.M();
          break;
        case 146: 
          biT = paramzzaou.readBytes();
          break;
        case 152: 
          i = paramzzaou.N();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
            biV = i;
          }
          break;
        case 160: 
          j = zzapf.zzc(paramzzaou, 160);
          if (biW == null) {}
          for (i = 0;; i = biW.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(biW, 0, localObject, 0, i);
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
          biW = ((int[])localObject);
          break;
        case 162: 
          int k = paramzzaou.zzaei(paramzzaou.S());
          i = paramzzaou.getPosition();
          j = 0;
          while (paramzzaou.X() > 0)
          {
            paramzzaou.N();
            j += 1;
          }
          paramzzaou.zzaek(i);
          if (biW == null) {}
          for (i = 0;; i = biW.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(biW, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = paramzzaou.N();
              j += 1;
            }
          }
          biW = ((int[])localObject);
          paramzzaou.zzaej(k);
          break;
        case 168: 
          biH = paramzzaou.M();
          break;
        case 176: 
          biX = paramzzaou.M();
          break;
        case 186: 
          if (biY == null) {
            biY = new zzapg.zzf();
          }
          paramzzaou.zza(biY);
          break;
        case 194: 
          biU = paramzzaou.readString();
        }
      }
    }
    
    protected int zzy()
    {
      int m = 0;
      int i = super.zzy();
      int j = i;
      if (biF != 0L) {
        j = i + zzaov.zze(1, biF);
      }
      i = j;
      if (!tag.equals("")) {
        i = j + zzaov.zzs(2, tag);
      }
      j = i;
      int k;
      if (biJ != null)
      {
        j = i;
        if (biJ.length > 0)
        {
          j = 0;
          while (j < biJ.length)
          {
            zzapg.zze localzze = biJ[j];
            k = i;
            if (localzze != null) {
              k = i + zzaov.zzc(3, localzze);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (!Arrays.equals(biK, zzapf.bit)) {
        i = j + zzaov.zzb(4, biK);
      }
      j = i;
      if (!Arrays.equals(biM, zzapf.bit)) {
        j = i + zzaov.zzb(6, biM);
      }
      i = j;
      if (biP != null) {
        i = j + zzaov.zzc(7, biP);
      }
      j = i;
      if (!biN.equals("")) {
        j = i + zzaov.zzs(8, biN);
      }
      i = j;
      if (biL != null) {
        i = j + zzaov.zzc(9, biL);
      }
      j = i;
      if (aTD) {
        j = i + zzaov.zzk(10, aTD);
      }
      i = j;
      if (biI != 0) {
        i = j + zzaov.zzag(11, biI);
      }
      j = i;
      if (zzahl != 0) {
        j = i + zzaov.zzag(12, zzahl);
      }
      i = j;
      if (!biO.equals("")) {
        i = j + zzaov.zzs(13, biO);
      }
      j = i;
      if (!biQ.equals("")) {
        j = i + zzaov.zzs(14, biQ);
      }
      i = j;
      if (biR != 180000L) {
        i = j + zzaov.zzg(15, biR);
      }
      j = i;
      if (biS != null) {
        j = i + zzaov.zzc(16, biS);
      }
      i = j;
      if (biG != 0L) {
        i = j + zzaov.zze(17, biG);
      }
      j = i;
      if (!Arrays.equals(biT, zzapf.bit)) {
        j = i + zzaov.zzb(18, biT);
      }
      i = j;
      if (biV != 0) {
        i = j + zzaov.zzag(19, biV);
      }
      j = i;
      if (biW != null)
      {
        j = i;
        if (biW.length > 0)
        {
          k = 0;
          j = m;
          while (j < biW.length)
          {
            k += zzaov.zzaeo(biW[j]);
            j += 1;
          }
          j = i + k + biW.length * 2;
        }
      }
      i = j;
      if (biH != 0L) {
        i = j + zzaov.zze(21, biH);
      }
      j = i;
      if (biX != 0L) {
        j = i + zzaov.zze(22, biX);
      }
      i = j;
      if (biY != null) {
        i = j + zzaov.zzc(23, biY);
      }
      j = i;
      if (!biU.equals("")) {
        j = i + zzaov.zzs(24, biU);
      }
      return j;
    }
  }
  
  public static final class zze
    extends zzaow<zze>
    implements Cloneable
  {
    private static volatile zze[] biZ;
    public String value;
    public String zzcb;
    
    public zze()
    {
      ay();
    }
    
    public static zze[] ax()
    {
      if (biZ == null) {}
      synchronized (zzapa.bij)
      {
        if (biZ == null) {
          biZ = new zze[0];
        }
        return biZ;
      }
    }
    
    public zze ay()
    {
      zzcb = "";
      value = "";
      bib = null;
      bik = -1;
      return this;
    }
    
    public zze az()
    {
      try
      {
        zze localzze = (zze)super.ac();
        return localzze;
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
      label41:
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof zze));
          paramObject = (zze)paramObject;
          if (zzcb != null) {
            break;
          }
          bool1 = bool2;
        } while (zzcb != null);
        if (value != null) {
          break label111;
        }
        bool1 = bool2;
      } while (value != null);
      for (;;)
      {
        if ((bib == null) || (bib.isEmpty()))
        {
          if (bib != null)
          {
            bool1 = bool2;
            if (!bib.isEmpty()) {
              break;
            }
          }
          return true;
          if (zzcb.equals(zzcb)) {
            break label41;
          }
          return false;
          label111:
          if (!value.equals(value)) {
            return false;
          }
        }
      }
      return bib.equals(bib);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int j;
      if (zzcb == null)
      {
        i = 0;
        if (value != null) {
          break label89;
        }
        j = 0;
        label33:
        k = m;
        if (bib != null) {
          if (!bib.isEmpty()) {
            break label100;
          }
        }
      }
      label89:
      label100:
      for (int k = m;; k = bib.hashCode())
      {
        return (j + (i + (n + 527) * 31) * 31) * 31 + k;
        i = zzcb.hashCode();
        break;
        j = value.hashCode();
        break label33;
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      if (!zzcb.equals("")) {
        paramzzaov.zzr(1, zzcb);
      }
      if (!value.equals("")) {
        paramzzaov.zzr(2, value);
      }
      super.zza(paramzzaov);
    }
    
    public zze zzck(zzaou paramzzaou)
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
          zzcb = paramzzaou.readString();
          break;
        case 18: 
          value = paramzzaou.readString();
        }
      }
    }
    
    protected int zzy()
    {
      int j = super.zzy();
      int i = j;
      if (!zzcb.equals("")) {
        i = j + zzaov.zzs(1, zzcb);
      }
      j = i;
      if (!value.equals("")) {
        j = i + zzaov.zzs(2, value);
      }
      return j;
    }
  }
  
  public static final class zzf
    extends zzaow<zzf>
    implements Cloneable
  {
    public int bja;
    
    public zzf()
    {
      aA();
    }
    
    public zzf aA()
    {
      bja = -1;
      bib = null;
      bik = -1;
      return this;
    }
    
    public zzf aB()
    {
      try
      {
        zzf localzzf = (zzf)super.ac();
        return localzzf;
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
          } while (!(paramObject instanceof zzf));
          paramObject = (zzf)paramObject;
          bool1 = bool2;
        } while (bja != bja);
        if ((bib != null) && (!bib.isEmpty())) {
          break label76;
        }
        if (bib == null) {
          break;
        }
        bool1 = bool2;
      } while (!bib.isEmpty());
      return true;
      label76:
      return bib.equals(bib);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = bja;
      if ((bib == null) || (bib.isEmpty())) {}
      for (int i = 0;; i = bib.hashCode()) {
        return i + ((j + 527) * 31 + k) * 31;
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      if (bja != -1) {
        paramzzaov.zzae(1, bja);
      }
      super.zza(paramzzaov);
    }
    
    public zzf zzcl(zzaou paramzzaou)
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
        case 8: 
          i = paramzzaou.N();
          switch (i)
          {
          default: 
            break;
          case -1: 
          case 0: 
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 17: 
            bja = i;
          }
          break;
        }
      }
    }
    
    protected int zzy()
    {
      int j = super.zzy();
      int i = j;
      if (bja != -1) {
        i = j + zzaov.zzag(1, bja);
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzapg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */