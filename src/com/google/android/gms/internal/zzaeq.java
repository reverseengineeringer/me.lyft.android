package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzaeq
  extends zzaow<zzaeq>
{
  public zza[] aLD;
  
  public zzaeq()
  {
    zzcjf();
  }
  
  public static zzaeq zzar(byte[] paramArrayOfByte)
    throws zzapb
  {
    return (zzaeq)zzapc.zza(new zzaeq(), paramArrayOfByte);
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
        } while (!(paramObject instanceof zzaeq));
        paramObject = (zzaeq)paramObject;
        bool1 = bool2;
      } while (!zzapa.equals(aLD, aLD));
      if ((bib != null) && (!bib.isEmpty())) {
        break label79;
      }
      if (bib == null) {
        break;
      }
      bool1 = bool2;
    } while (!bib.isEmpty());
    return true;
    label79:
    return bib.equals(bib);
  }
  
  public int hashCode()
  {
    int j = getClass().getName().hashCode();
    int k = zzapa.hashCode(aLD);
    if ((bib == null) || (bib.isEmpty())) {}
    for (int i = 0;; i = bib.hashCode()) {
      return i + ((j + 527) * 31 + k) * 31;
    }
  }
  
  public void zza(zzaov paramzzaov)
    throws IOException
  {
    if ((aLD != null) && (aLD.length > 0))
    {
      int i = 0;
      while (i < aLD.length)
      {
        zza localzza = aLD[i];
        if (localzza != null) {
          paramzzaov.zza(1, localzza);
        }
        i += 1;
      }
    }
    super.zza(paramzzaov);
  }
  
  public zzaeq zzbu(zzaou paramzzaou)
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
        if (aLD == null) {}
        zza[] arrayOfzza;
        for (i = 0;; i = aLD.length)
        {
          arrayOfzza = new zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(aLD, 0, arrayOfzza, 0, i);
            j = i;
          }
          while (j < arrayOfzza.length - 1)
          {
            arrayOfzza[j] = new zza();
            paramzzaou.zza(arrayOfzza[j]);
            paramzzaou.J();
            j += 1;
          }
        }
        arrayOfzza[j] = new zza();
        paramzzaou.zza(arrayOfzza[j]);
        aLD = arrayOfzza;
      }
    }
  }
  
  public zzaeq zzcjf()
  {
    aLD = zza.zzcjg();
    bib = null;
    bik = -1;
    return this;
  }
  
  protected int zzy()
  {
    int i = super.zzy();
    int k = i;
    if (aLD != null)
    {
      k = i;
      if (aLD.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= aLD.length) {
            break;
          }
          zza localzza = aLD[j];
          k = i;
          if (localzza != null) {
            k = i + zzaov.zzc(1, localzza);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public static final class zza
    extends zzaow<zza>
  {
    private static volatile zza[] aLE;
    public zza aLF;
    public String name;
    
    public zza()
    {
      zzcjh();
    }
    
    public static zza[] zzcjg()
    {
      if (aLE == null) {}
      synchronized (zzapa.bij)
      {
        if (aLE == null) {
          aLE = new zza[0];
        }
        return aLE;
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
          } while (!(paramObject instanceof zza));
          paramObject = (zza)paramObject;
          if (name != null) {
            break;
          }
          bool1 = bool2;
        } while (name != null);
        if (aLF != null) {
          break label111;
        }
        bool1 = bool2;
      } while (aLF != null);
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
          if (name.equals(name)) {
            break label41;
          }
          return false;
          label111:
          if (!aLF.equals(aLF)) {
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
      if (name == null)
      {
        i = 0;
        if (aLF != null) {
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
        i = name.hashCode();
        break;
        j = aLF.hashCode();
        break label33;
      }
    }
    
    public void zza(zzaov paramzzaov)
      throws IOException
    {
      paramzzaov.zzr(1, name);
      if (aLF != null) {
        paramzzaov.zza(2, aLF);
      }
      super.zza(paramzzaov);
    }
    
    public zza zzbv(zzaou paramzzaou)
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
          name = paramzzaou.readString();
          break;
        case 18: 
          if (aLF == null) {
            aLF = new zza();
          }
          paramzzaou.zza(aLF);
        }
      }
    }
    
    public zza zzcjh()
    {
      name = "";
      aLF = null;
      bib = null;
      bik = -1;
      return this;
    }
    
    protected int zzy()
    {
      int j = super.zzy() + zzaov.zzs(1, name);
      int i = j;
      if (aLF != null) {
        i = j + zzaov.zzc(2, aLF);
      }
      return i;
    }
    
    public static final class zza
      extends zzaow<zza>
    {
      private static volatile zza[] aLG;
      public zza aLH;
      public int type;
      
      public zza()
      {
        zzcjj();
      }
      
      public static zza[] zzcji()
      {
        if (aLG == null) {}
        synchronized (zzapa.bij)
        {
          if (aLG == null) {
            aLG = new zza[0];
          }
          return aLG;
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
            } while (!(paramObject instanceof zza));
            paramObject = (zza)paramObject;
            bool1 = bool2;
          } while (type != type);
          if (aLH != null) {
            break;
          }
          bool1 = bool2;
        } while (aLH != null);
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
            if (!aLH.equals(aLH)) {
              return false;
            }
          }
        }
        return bib.equals(bib);
      }
      
      public int hashCode()
      {
        int k = 0;
        int m = getClass().getName().hashCode();
        int n = type;
        int i;
        if (aLH == null)
        {
          i = 0;
          j = k;
          if (bib != null) {
            if (!bib.isEmpty()) {
              break label84;
            }
          }
        }
        label84:
        for (int j = k;; j = bib.hashCode())
        {
          return (i + ((m + 527) * 31 + n) * 31) * 31 + j;
          i = aLH.hashCode();
          break;
        }
      }
      
      public void zza(zzaov paramzzaov)
        throws IOException
      {
        paramzzaov.zzae(1, type);
        if (aLH != null) {
          paramzzaov.zza(2, aLH);
        }
        super.zza(paramzzaov);
      }
      
      public zza zzbw(zzaou paramzzaou)
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
              type = i;
            }
            break;
          case 18: 
            if (aLH == null) {
              aLH = new zza();
            }
            paramzzaou.zza(aLH);
          }
        }
      }
      
      public zza zzcjj()
      {
        type = 1;
        aLH = null;
        bib = null;
        bik = -1;
        return this;
      }
      
      protected int zzy()
      {
        int j = super.zzy() + zzaov.zzag(1, type);
        int i = j;
        if (aLH != null) {
          i = j + zzaov.zzc(2, aLH);
        }
        return i;
      }
      
      public static final class zza
        extends zzaow<zza>
      {
        public byte[] aLI;
        public String aLJ;
        public double aLK;
        public float aLL;
        public long aLM;
        public int aLN;
        public int aLO;
        public boolean aLP;
        public zzaeq.zza[] aLQ;
        public zzaeq.zza.zza[] aLR;
        public String[] aLS;
        public long[] aLT;
        public float[] aLU;
        public long aLV;
        
        public zza()
        {
          zzcjk();
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
              } while (!(paramObject instanceof zza));
              paramObject = (zza)paramObject;
              bool1 = bool2;
            } while (!Arrays.equals(aLI, aLI));
            if (aLJ != null) {
              break;
            }
            bool1 = bool2;
          } while (aLJ != null);
          while (aLJ.equals(aLJ))
          {
            bool1 = bool2;
            if (Double.doubleToLongBits(aLK) != Double.doubleToLongBits(aLK)) {
              break;
            }
            bool1 = bool2;
            if (Float.floatToIntBits(aLL) != Float.floatToIntBits(aLL)) {
              break;
            }
            bool1 = bool2;
            if (aLM != aLM) {
              break;
            }
            bool1 = bool2;
            if (aLN != aLN) {
              break;
            }
            bool1 = bool2;
            if (aLO != aLO) {
              break;
            }
            bool1 = bool2;
            if (aLP != aLP) {
              break;
            }
            bool1 = bool2;
            if (!zzapa.equals(aLQ, aLQ)) {
              break;
            }
            bool1 = bool2;
            if (!zzapa.equals(aLR, aLR)) {
              break;
            }
            bool1 = bool2;
            if (!zzapa.equals(aLS, aLS)) {
              break;
            }
            bool1 = bool2;
            if (!zzapa.equals(aLT, aLT)) {
              break;
            }
            bool1 = bool2;
            if (!zzapa.equals(aLU, aLU)) {
              break;
            }
            bool1 = bool2;
            if (aLV != aLV) {
              break;
            }
            if ((bib != null) && (!bib.isEmpty())) {
              break label297;
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
          label297:
          return bib.equals(bib);
        }
        
        public int hashCode()
        {
          int m = 0;
          int n = getClass().getName().hashCode();
          int i1 = Arrays.hashCode(aLI);
          int i;
          int i2;
          int i3;
          int i4;
          int i5;
          int i6;
          int j;
          label100:
          int i7;
          int i8;
          int i9;
          int i10;
          int i11;
          int i12;
          if (aLJ == null)
          {
            i = 0;
            long l = Double.doubleToLongBits(aLK);
            i2 = (int)(l ^ l >>> 32);
            i3 = Float.floatToIntBits(aLL);
            i4 = (int)(aLM ^ aLM >>> 32);
            i5 = aLN;
            i6 = aLO;
            if (!aLP) {
              break label288;
            }
            j = 1231;
            i7 = zzapa.hashCode(aLQ);
            i8 = zzapa.hashCode(aLR);
            i9 = zzapa.hashCode(aLS);
            i10 = zzapa.hashCode(aLT);
            i11 = zzapa.hashCode(aLU);
            i12 = (int)(aLV ^ aLV >>> 32);
            k = m;
            if (bib != null) {
              if (!bib.isEmpty()) {
                break label295;
              }
            }
          }
          label288:
          label295:
          for (int k = m;; k = bib.hashCode())
          {
            return (((((((j + ((((((i + ((n + 527) * 31 + i1) * 31) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + k;
            i = aLJ.hashCode();
            break;
            j = 1237;
            break label100;
          }
        }
        
        public void zza(zzaov paramzzaov)
          throws IOException
        {
          int j = 0;
          if (!Arrays.equals(aLI, zzapf.bit)) {
            paramzzaov.zza(1, aLI);
          }
          if (!aLJ.equals("")) {
            paramzzaov.zzr(2, aLJ);
          }
          if (Double.doubleToLongBits(aLK) != Double.doubleToLongBits(0.0D)) {
            paramzzaov.zza(3, aLK);
          }
          if (Float.floatToIntBits(aLL) != Float.floatToIntBits(0.0F)) {
            paramzzaov.zzc(4, aLL);
          }
          if (aLM != 0L) {
            paramzzaov.zzb(5, aLM);
          }
          if (aLN != 0) {
            paramzzaov.zzae(6, aLN);
          }
          if (aLO != 0) {
            paramzzaov.zzaf(7, aLO);
          }
          if (aLP) {
            paramzzaov.zzj(8, aLP);
          }
          int i;
          Object localObject;
          if ((aLQ != null) && (aLQ.length > 0))
          {
            i = 0;
            while (i < aLQ.length)
            {
              localObject = aLQ[i];
              if (localObject != null) {
                paramzzaov.zza(9, (zzapc)localObject);
              }
              i += 1;
            }
          }
          if ((aLR != null) && (aLR.length > 0))
          {
            i = 0;
            while (i < aLR.length)
            {
              localObject = aLR[i];
              if (localObject != null) {
                paramzzaov.zza(10, (zzapc)localObject);
              }
              i += 1;
            }
          }
          if ((aLS != null) && (aLS.length > 0))
          {
            i = 0;
            while (i < aLS.length)
            {
              localObject = aLS[i];
              if (localObject != null) {
                paramzzaov.zzr(11, (String)localObject);
              }
              i += 1;
            }
          }
          if ((aLT != null) && (aLT.length > 0))
          {
            i = 0;
            while (i < aLT.length)
            {
              paramzzaov.zzb(12, aLT[i]);
              i += 1;
            }
          }
          if (aLV != 0L) {
            paramzzaov.zzb(13, aLV);
          }
          if ((aLU != null) && (aLU.length > 0))
          {
            i = j;
            while (i < aLU.length)
            {
              paramzzaov.zzc(14, aLU[i]);
              i += 1;
            }
          }
          super.zza(paramzzaov);
        }
        
        public zza zzbx(zzaou paramzzaou)
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
              aLI = paramzzaou.readBytes();
              break;
            case 18: 
              aLJ = paramzzaou.readString();
              break;
            case 25: 
              aLK = paramzzaou.readDouble();
              break;
            case 37: 
              aLL = paramzzaou.readFloat();
              break;
            case 40: 
              aLM = paramzzaou.M();
              break;
            case 48: 
              aLN = paramzzaou.N();
              break;
            case 56: 
              aLO = paramzzaou.Q();
              break;
            case 64: 
              aLP = paramzzaou.P();
              break;
            case 74: 
              j = zzapf.zzc(paramzzaou, 74);
              if (aLQ == null) {}
              for (i = 0;; i = aLQ.length)
              {
                localObject = new zzaeq.zza[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(aLQ, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = new zzaeq.zza();
                  paramzzaou.zza(localObject[j]);
                  paramzzaou.J();
                  j += 1;
                }
              }
              localObject[j] = new zzaeq.zza();
              paramzzaou.zza(localObject[j]);
              aLQ = ((zzaeq.zza[])localObject);
              break;
            case 82: 
              j = zzapf.zzc(paramzzaou, 82);
              if (aLR == null) {}
              for (i = 0;; i = aLR.length)
              {
                localObject = new zzaeq.zza.zza[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(aLR, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = new zzaeq.zza.zza();
                  paramzzaou.zza(localObject[j]);
                  paramzzaou.J();
                  j += 1;
                }
              }
              localObject[j] = new zzaeq.zza.zza();
              paramzzaou.zza(localObject[j]);
              aLR = ((zzaeq.zza.zza[])localObject);
              break;
            case 90: 
              j = zzapf.zzc(paramzzaou, 90);
              if (aLS == null) {}
              for (i = 0;; i = aLS.length)
              {
                localObject = new String[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(aLS, 0, localObject, 0, i);
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
              aLS = ((String[])localObject);
              break;
            case 96: 
              j = zzapf.zzc(paramzzaou, 96);
              if (aLT == null) {}
              for (i = 0;; i = aLT.length)
              {
                localObject = new long[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(aLT, 0, localObject, 0, i);
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
              aLT = ((long[])localObject);
              break;
            case 98: 
              k = paramzzaou.zzaei(paramzzaou.S());
              i = paramzzaou.getPosition();
              j = 0;
              while (paramzzaou.X() > 0)
              {
                paramzzaou.M();
                j += 1;
              }
              paramzzaou.zzaek(i);
              if (aLT == null) {}
              for (i = 0;; i = aLT.length)
              {
                localObject = new long[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(aLT, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length)
                {
                  localObject[j] = paramzzaou.M();
                  j += 1;
                }
              }
              aLT = ((long[])localObject);
              paramzzaou.zzaej(k);
              break;
            case 104: 
              aLV = paramzzaou.M();
              break;
            case 117: 
              j = zzapf.zzc(paramzzaou, 117);
              if (aLU == null) {}
              for (i = 0;; i = aLU.length)
              {
                localObject = new float[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(aLU, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = paramzzaou.readFloat();
                  paramzzaou.J();
                  j += 1;
                }
              }
              localObject[j] = paramzzaou.readFloat();
              aLU = ((float[])localObject);
              break;
            case 114: 
              i = paramzzaou.S();
              k = paramzzaou.zzaei(i);
              j = i / 4;
              if (aLU == null) {}
              for (i = 0;; i = aLU.length)
              {
                localObject = new float[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(aLU, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length)
                {
                  localObject[j] = paramzzaou.readFloat();
                  j += 1;
                }
              }
              aLU = ((float[])localObject);
              paramzzaou.zzaej(k);
            }
          }
        }
        
        public zza zzcjk()
        {
          aLI = zzapf.bit;
          aLJ = "";
          aLK = 0.0D;
          aLL = 0.0F;
          aLM = 0L;
          aLN = 0;
          aLO = 0;
          aLP = false;
          aLQ = zzaeq.zza.zzcjg();
          aLR = zzaeq.zza.zza.zzcji();
          aLS = zzapf.bir;
          aLT = zzapf.bin;
          aLU = zzapf.bio;
          aLV = 0L;
          bib = null;
          bik = -1;
          return this;
        }
        
        protected int zzy()
        {
          int i2 = 0;
          int j = super.zzy();
          int i = j;
          if (!Arrays.equals(aLI, zzapf.bit)) {
            i = j + zzaov.zzb(1, aLI);
          }
          j = i;
          if (!aLJ.equals("")) {
            j = i + zzaov.zzs(2, aLJ);
          }
          i = j;
          if (Double.doubleToLongBits(aLK) != Double.doubleToLongBits(0.0D)) {
            i = j + zzaov.zzb(3, aLK);
          }
          j = i;
          if (Float.floatToIntBits(aLL) != Float.floatToIntBits(0.0F)) {
            j = i + zzaov.zzd(4, aLL);
          }
          i = j;
          if (aLM != 0L) {
            i = j + zzaov.zze(5, aLM);
          }
          j = i;
          if (aLN != 0) {
            j = i + zzaov.zzag(6, aLN);
          }
          int k = j;
          if (aLO != 0) {
            k = j + zzaov.zzah(7, aLO);
          }
          i = k;
          if (aLP) {
            i = k + zzaov.zzk(8, aLP);
          }
          j = i;
          Object localObject;
          if (aLQ != null)
          {
            j = i;
            if (aLQ.length > 0)
            {
              j = 0;
              while (j < aLQ.length)
              {
                localObject = aLQ[j];
                k = i;
                if (localObject != null) {
                  k = i + zzaov.zzc(9, (zzapc)localObject);
                }
                j += 1;
                i = k;
              }
              j = i;
            }
          }
          i = j;
          if (aLR != null)
          {
            i = j;
            if (aLR.length > 0)
            {
              i = j;
              j = 0;
              while (j < aLR.length)
              {
                localObject = aLR[j];
                k = i;
                if (localObject != null) {
                  k = i + zzaov.zzc(10, (zzapc)localObject);
                }
                j += 1;
                i = k;
              }
            }
          }
          j = i;
          if (aLS != null)
          {
            j = i;
            if (aLS.length > 0)
            {
              j = 0;
              k = 0;
              int n;
              for (int m = 0; j < aLS.length; m = n)
              {
                localObject = aLS[j];
                int i1 = k;
                n = m;
                if (localObject != null)
                {
                  n = m + 1;
                  i1 = k + zzaov.zztg((String)localObject);
                }
                j += 1;
                k = i1;
              }
              j = i + k + m * 1;
            }
          }
          i = j;
          if (aLT != null)
          {
            i = j;
            if (aLT.length > 0)
            {
              k = 0;
              i = i2;
              while (i < aLT.length)
              {
                k += zzaov.zzcw(aLT[i]);
                i += 1;
              }
              i = j + k + aLT.length * 1;
            }
          }
          j = i;
          if (aLV != 0L) {
            j = i + zzaov.zze(13, aLV);
          }
          i = j;
          if (aLU != null)
          {
            i = j;
            if (aLU.length > 0) {
              i = j + aLU.length * 4 + aLU.length * 1;
            }
          }
          return i;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaeq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */