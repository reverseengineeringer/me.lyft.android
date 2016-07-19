package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzaeq$zza$zza$zza
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
  
  public zzaeq$zza$zza$zza()
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

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaeq.zza.zza.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */