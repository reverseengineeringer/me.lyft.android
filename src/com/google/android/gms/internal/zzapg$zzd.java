package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzapg$zzd
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
  
  public zzapg$zzd()
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

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzapg.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */