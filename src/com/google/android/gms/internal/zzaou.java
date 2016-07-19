package com.google.android.gms.internal;

import java.io.IOException;

public final class zzaou
{
  private int bhR;
  private int bhS;
  private int bhT;
  private int bhU;
  private int bhV;
  private int bhW = Integer.MAX_VALUE;
  private int bhX;
  private int bhY = 64;
  private int bhZ = 67108864;
  private final byte[] buffer;
  
  private zzaou(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    buffer = paramArrayOfByte;
    bhR = paramInt1;
    bhS = (paramInt1 + paramInt2);
    bhU = paramInt1;
  }
  
  private void W()
  {
    bhS += bhT;
    int i = bhS;
    if (i > bhW)
    {
      bhT = (i - bhW);
      bhS -= bhT;
      return;
    }
    bhT = 0;
  }
  
  public static int zzaeh(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }
  
  public static zzaou zzaz(byte[] paramArrayOfByte)
  {
    return zzb(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static zzaou zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzaou(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static long zzcq(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  public int J()
    throws IOException
  {
    if (Y())
    {
      bhV = 0;
      return 0;
    }
    bhV = S();
    if (bhV == 0) {
      throw zzapb.aj();
    }
    return bhV;
  }
  
  public void K()
    throws IOException
  {
    int i;
    do
    {
      i = J();
    } while ((i != 0) && (zzaeg(i)));
  }
  
  public long L()
    throws IOException
  {
    return T();
  }
  
  public long M()
    throws IOException
  {
    return T();
  }
  
  public int N()
    throws IOException
  {
    return S();
  }
  
  public boolean P()
    throws IOException
  {
    return S() != 0;
  }
  
  public int Q()
    throws IOException
  {
    return zzaeh(S());
  }
  
  public long R()
    throws IOException
  {
    return zzcq(T());
  }
  
  public int S()
    throws IOException
  {
    int i = Z();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = Z();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = Z();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = Z();
      if (k >= 0) {
        return i | k << 21;
      }
      j = Z();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (Z() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw zzapb.ai();
  }
  
  public long T()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = Z();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw zzapb.ai();
  }
  
  public int U()
    throws IOException
  {
    return Z() & 0xFF | (Z() & 0xFF) << 8 | (Z() & 0xFF) << 16 | (Z() & 0xFF) << 24;
  }
  
  public long V()
    throws IOException
  {
    int i = Z();
    int j = Z();
    int k = Z();
    int m = Z();
    int n = Z();
    int i1 = Z();
    int i2 = Z();
    int i3 = Z();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public int X()
  {
    if (bhW == Integer.MAX_VALUE) {
      return -1;
    }
    int i = bhU;
    return bhW - i;
  }
  
  public boolean Y()
  {
    return bhU == bhS;
  }
  
  public byte Z()
    throws IOException
  {
    if (bhU == bhS) {
      throw zzapb.ag();
    }
    byte[] arrayOfByte = buffer;
    int i = bhU;
    bhU = (i + 1);
    return arrayOfByte[i];
  }
  
  public int getPosition()
  {
    return bhU - bhR;
  }
  
  public byte[] readBytes()
    throws IOException
  {
    int i = S();
    if (i < 0) {
      throw zzapb.ah();
    }
    if (i == 0) {
      return zzapf.bit;
    }
    if (i > bhS - bhU) {
      throw zzapb.ag();
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(buffer, bhU, arrayOfByte, 0, i);
    bhU = (i + bhU);
    return arrayOfByte;
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(V());
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(U());
  }
  
  public String readString()
    throws IOException
  {
    int i = S();
    if (i < 0) {
      throw zzapb.ah();
    }
    if (i > bhS - bhU) {
      throw zzapb.ag();
    }
    String str = new String(buffer, bhU, i, zzapa.UTF_8);
    bhU = (i + bhU);
    return str;
  }
  
  public void zza(zzapc paramzzapc)
    throws IOException
  {
    int i = S();
    if (bhX >= bhY) {
      throw zzapb.am();
    }
    i = zzaei(i);
    bhX += 1;
    paramzzapc.zzb(this);
    zzaef(0);
    bhX -= 1;
    zzaej(i);
  }
  
  public byte[] zzad(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return zzapf.bit;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    int i = bhR;
    System.arraycopy(buffer, i + paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public void zzaef(int paramInt)
    throws zzapb
  {
    if (bhV != paramInt) {
      throw zzapb.ak();
    }
  }
  
  public boolean zzaeg(int paramInt)
    throws IOException
  {
    switch (zzapf.zzaez(paramInt))
    {
    default: 
      throw zzapb.al();
    case 0: 
      N();
      return true;
    case 1: 
      V();
      return true;
    case 2: 
      zzael(S());
      return true;
    case 3: 
      K();
      zzaef(zzapf.zzaj(zzapf.zzafa(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    U();
    return true;
  }
  
  public int zzaei(int paramInt)
    throws zzapb
  {
    if (paramInt < 0) {
      throw zzapb.ah();
    }
    paramInt = bhU + paramInt;
    int i = bhW;
    if (paramInt > i) {
      throw zzapb.ag();
    }
    bhW = paramInt;
    W();
    return i;
  }
  
  public void zzaej(int paramInt)
  {
    bhW = paramInt;
    W();
  }
  
  public void zzaek(int paramInt)
  {
    if (paramInt > bhU - bhR)
    {
      int i = bhU;
      int j = bhR;
      throw new IllegalArgumentException(50 + "Position " + paramInt + " is beyond current " + (i - j));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException(24 + "Bad position " + paramInt);
    }
    bhU = (bhR + paramInt);
  }
  
  public void zzael(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw zzapb.ah();
    }
    if (bhU + paramInt > bhW)
    {
      zzael(bhW - bhU);
      throw zzapb.ag();
    }
    if (paramInt <= bhS - bhU)
    {
      bhU += paramInt;
      return;
    }
    throw zzapb.ag();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaou
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */