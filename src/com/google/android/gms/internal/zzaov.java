package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzaov
{
  private final ByteBuffer bia;
  
  private zzaov(ByteBuffer paramByteBuffer)
  {
    bia = paramByteBuffer;
    bia.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private zzaov(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  private static int zza(CharSequence paramCharSequence, int paramInt)
  {
    int m = paramCharSequence.length();
    int i = 0;
    if (paramInt < m)
    {
      int n = paramCharSequence.charAt(paramInt);
      int j;
      if (n < 2048)
      {
        i += (127 - n >>> 31);
        j = paramInt;
      }
      for (;;)
      {
        paramInt = j + 1;
        break;
        int k = i + 2;
        j = paramInt;
        i = k;
        if (55296 <= n)
        {
          j = paramInt;
          i = k;
          if (n <= 57343)
          {
            if (Character.codePointAt(paramCharSequence, paramInt) < 65536) {
              throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + paramInt);
            }
            j = paramInt + 1;
            i = k;
          }
        }
      }
    }
    return i;
  }
  
  private static int zza(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = paramCharSequence.length();
    int j = 0;
    int m = paramInt1 + paramInt2;
    paramInt2 = j;
    while ((paramInt2 < k) && (paramInt2 + paramInt1 < m))
    {
      j = paramCharSequence.charAt(paramInt2);
      if (j >= 128) {
        break;
      }
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)j);
      paramInt2 += 1;
    }
    if (paramInt2 == k) {
      return paramInt1 + k;
    }
    paramInt1 += paramInt2;
    if (paramInt2 < k)
    {
      int i = paramCharSequence.charAt(paramInt2);
      if ((i < 128) && (paramInt1 < m))
      {
        j = paramInt1 + 1;
        paramArrayOfByte[paramInt1] = ((byte)i);
        paramInt1 = j;
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        if ((i < 2048) && (paramInt1 <= m - 2))
        {
          j = paramInt1 + 1;
          paramArrayOfByte[paramInt1] = ((byte)(i >>> 6 | 0x3C0));
          paramInt1 = j + 1;
          paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int n;
          if (((i < 55296) || (57343 < i)) && (paramInt1 <= m - 3))
          {
            j = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(i >>> 12 | 0x1E0));
            n = j + 1;
            paramArrayOfByte[j] = ((byte)(i >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
          }
          else
          {
            if (paramInt1 > m - 4) {
              break label444;
            }
            j = paramInt2;
            char c;
            if (paramInt2 + 1 != paramCharSequence.length())
            {
              paramInt2 += 1;
              c = paramCharSequence.charAt(paramInt2);
              if (!Character.isSurrogatePair(i, c)) {
                j = paramInt2;
              }
            }
            else
            {
              throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + (j - 1));
            }
            j = Character.toCodePoint(i, c);
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 18 | 0xF0));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
            n = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)(j >>> 6 & 0x3F | 0x80));
            paramInt1 = n + 1;
            paramArrayOfByte[n] = ((byte)(j & 0x3F | 0x80));
          }
        }
      }
      label444:
      throw new ArrayIndexOutOfBoundsException(37 + "Failed writing " + i + " at index " + paramInt1);
    }
    return paramInt1;
  }
  
  private static void zza(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.isReadOnly()) {
      throw new ReadOnlyBufferException();
    }
    if (paramByteBuffer.hasArray()) {
      try
      {
        paramByteBuffer.position(zza(paramCharSequence, paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining()) - paramByteBuffer.arrayOffset());
        return;
      }
      catch (ArrayIndexOutOfBoundsException paramCharSequence)
      {
        paramByteBuffer = new BufferOverflowException();
        paramByteBuffer.initCause(paramCharSequence);
        throw paramByteBuffer;
      }
    }
    zzb(paramCharSequence, paramByteBuffer);
  }
  
  public static int zzaeo(int paramInt)
  {
    if (paramInt >= 0) {
      return zzaet(paramInt);
    }
    return 10;
  }
  
  public static int zzaep(int paramInt)
  {
    return zzaet(zzaev(paramInt));
  }
  
  public static int zzaer(int paramInt)
  {
    return zzaet(zzapf.zzaj(paramInt, 0));
  }
  
  public static int zzaet(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((0xF0000000 & paramInt) == 0) {
      return 4;
    }
    return 5;
  }
  
  public static int zzaev(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public static int zzag(int paramInt1, int paramInt2)
  {
    return zzaer(paramInt1) + zzaeo(paramInt2);
  }
  
  public static int zzah(int paramInt1, int paramInt2)
  {
    return zzaer(paramInt1) + zzaep(paramInt2);
  }
  
  public static int zzb(int paramInt, double paramDouble)
  {
    return zzaer(paramInt) + zzp(paramDouble);
  }
  
  public static int zzb(int paramInt, zzapc paramzzapc)
  {
    return zzaer(paramInt) * 2 + zzd(paramzzapc);
  }
  
  public static int zzb(int paramInt, byte[] paramArrayOfByte)
  {
    return zzaer(paramInt) + zzbc(paramArrayOfByte);
  }
  
  private static void zzb(CharSequence paramCharSequence, ByteBuffer paramByteBuffer)
  {
    int m = paramCharSequence.length();
    int j = 0;
    if (j < m)
    {
      int i = paramCharSequence.charAt(j);
      if (i < 128) {
        paramByteBuffer.put((byte)i);
      }
      for (;;)
      {
        j += 1;
        break;
        if (i < 2048)
        {
          paramByteBuffer.put((byte)(i >>> 6 | 0x3C0));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else if ((i < 55296) || (57343 < i))
        {
          paramByteBuffer.put((byte)(i >>> 12 | 0x1E0));
          paramByteBuffer.put((byte)(i >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(i & 0x3F | 0x80));
        }
        else
        {
          int k = j;
          char c;
          if (j + 1 != paramCharSequence.length())
          {
            j += 1;
            c = paramCharSequence.charAt(j);
            if (!Character.isSurrogatePair(i, c)) {
              k = j;
            }
          }
          else
          {
            throw new IllegalArgumentException(39 + "Unpaired surrogate at index " + (k - 1));
          }
          k = Character.toCodePoint(i, c);
          paramByteBuffer.put((byte)(k >>> 18 | 0xF0));
          paramByteBuffer.put((byte)(k >>> 12 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k >>> 6 & 0x3F | 0x80));
          paramByteBuffer.put((byte)(k & 0x3F | 0x80));
        }
      }
    }
  }
  
  public static zzaov zzba(byte[] paramArrayOfByte)
  {
    return zzc(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static int zzbc(byte[] paramArrayOfByte)
  {
    return zzaet(paramArrayOfByte.length) + paramArrayOfByte.length;
  }
  
  public static int zzc(int paramInt, zzapc paramzzapc)
  {
    return zzaer(paramInt) + zze(paramzzapc);
  }
  
  public static zzaov zzc(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new zzaov(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int zzcv(long paramLong)
  {
    return zzda(paramLong);
  }
  
  public static int zzcw(long paramLong)
  {
    return zzda(paramLong);
  }
  
  public static int zzcy(long paramLong)
  {
    return zzda(zzdc(paramLong));
  }
  
  public static int zzd(int paramInt, float paramFloat)
  {
    return zzaer(paramInt) + zzl(paramFloat);
  }
  
  public static int zzd(zzapc paramzzapc)
  {
    return paramzzapc.ao();
  }
  
  private static int zzd(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.length();
    int i = 0;
    while ((i < m) && (paramCharSequence.charAt(i) < '')) {
      i += 1;
    }
    for (;;)
    {
      int k = i;
      int j;
      if (j < m)
      {
        k = paramCharSequence.charAt(j);
        if (k < 2048)
        {
          j += 1;
          i = (127 - k >>> 31) + i;
        }
        else
        {
          k = i + zza(paramCharSequence, j);
        }
      }
      else
      {
        if (k < m)
        {
          long l = k;
          throw new IllegalArgumentException(54 + "UTF-8 length does not fit in int: " + (l + 4294967296L));
        }
        return k;
        j = i;
        i = m;
      }
    }
  }
  
  public static int zzda(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0xFFFFFFF800000000 & paramLong) == 0L) {
      return 5;
    }
    if ((0xFFFFFC0000000000 & paramLong) == 0L) {
      return 6;
    }
    if ((0xFFFE000000000000 & paramLong) == 0L) {
      return 7;
    }
    if ((0xFF00000000000000 & paramLong) == 0L) {
      return 8;
    }
    if ((0x8000000000000000 & paramLong) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public static long zzdc(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int zzdf(boolean paramBoolean)
  {
    return 1;
  }
  
  public static int zze(int paramInt, long paramLong)
  {
    return zzaer(paramInt) + zzcw(paramLong);
  }
  
  public static int zze(zzapc paramzzapc)
  {
    int i = paramzzapc.ao();
    return i + zzaet(i);
  }
  
  public static int zzg(int paramInt, long paramLong)
  {
    return zzaer(paramInt) + zzcy(paramLong);
  }
  
  public static int zzk(int paramInt, boolean paramBoolean)
  {
    return zzaer(paramInt) + zzdf(paramBoolean);
  }
  
  public static int zzl(float paramFloat)
  {
    return 4;
  }
  
  public static int zzp(double paramDouble)
  {
    return 8;
  }
  
  public static int zzs(int paramInt, String paramString)
  {
    return zzaer(paramInt) + zztg(paramString);
  }
  
  public static int zztg(String paramString)
  {
    int i = zzd(paramString);
    return i + zzaet(i);
  }
  
  public int aa()
  {
    return bia.remaining();
  }
  
  public void ab()
  {
    if (aa() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public void zza(int paramInt, double paramDouble)
    throws IOException
  {
    zzai(paramInt, 1);
    zzo(paramDouble);
  }
  
  public void zza(int paramInt, long paramLong)
    throws IOException
  {
    zzai(paramInt, 0);
    zzcr(paramLong);
  }
  
  public void zza(int paramInt, zzapc paramzzapc)
    throws IOException
  {
    zzai(paramInt, 2);
    zzc(paramzzapc);
  }
  
  public void zza(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    zzai(paramInt, 2);
    zzbb(paramArrayOfByte);
  }
  
  public void zzae(int paramInt1, int paramInt2)
    throws IOException
  {
    zzai(paramInt1, 0);
    zzaem(paramInt2);
  }
  
  public void zzaem(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      zzaes(paramInt);
      return;
    }
    zzcz(paramInt);
  }
  
  public void zzaen(int paramInt)
    throws IOException
  {
    zzaes(zzaev(paramInt));
  }
  
  public void zzaeq(int paramInt)
    throws IOException
  {
    zzc((byte)paramInt);
  }
  
  public void zzaes(int paramInt)
    throws IOException
  {
    for (;;)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        zzaeq(paramInt);
        return;
      }
      zzaeq(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
  }
  
  public void zzaeu(int paramInt)
    throws IOException
  {
    if (bia.remaining() < 4) {
      throw new zza(bia.position(), bia.limit());
    }
    bia.putInt(paramInt);
  }
  
  public void zzaf(int paramInt1, int paramInt2)
    throws IOException
  {
    zzai(paramInt1, 0);
    zzaen(paramInt2);
  }
  
  public void zzai(int paramInt1, int paramInt2)
    throws IOException
  {
    zzaes(zzapf.zzaj(paramInt1, paramInt2));
  }
  
  public void zzb(int paramInt, long paramLong)
    throws IOException
  {
    zzai(paramInt, 0);
    zzcs(paramLong);
  }
  
  public void zzb(zzapc paramzzapc)
    throws IOException
  {
    paramzzapc.zza(this);
  }
  
  public void zzbb(byte[] paramArrayOfByte)
    throws IOException
  {
    zzaes(paramArrayOfByte.length);
    zzbd(paramArrayOfByte);
  }
  
  public void zzbd(byte[] paramArrayOfByte)
    throws IOException
  {
    zzd(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void zzc(byte paramByte)
    throws IOException
  {
    if (!bia.hasRemaining()) {
      throw new zza(bia.position(), bia.limit());
    }
    bia.put(paramByte);
  }
  
  public void zzc(int paramInt, float paramFloat)
    throws IOException
  {
    zzai(paramInt, 5);
    zzk(paramFloat);
  }
  
  public void zzc(zzapc paramzzapc)
    throws IOException
  {
    zzaes(paramzzapc.an());
    paramzzapc.zza(this);
  }
  
  public void zzcr(long paramLong)
    throws IOException
  {
    zzcz(paramLong);
  }
  
  public void zzcs(long paramLong)
    throws IOException
  {
    zzcz(paramLong);
  }
  
  public void zzcu(long paramLong)
    throws IOException
  {
    zzcz(zzdc(paramLong));
  }
  
  public void zzcz(long paramLong)
    throws IOException
  {
    for (;;)
    {
      if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L)
      {
        zzaeq((int)paramLong);
        return;
      }
      zzaeq((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
  }
  
  public void zzd(int paramInt, long paramLong)
    throws IOException
  {
    zzai(paramInt, 0);
    zzcu(paramLong);
  }
  
  public void zzd(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (bia.remaining() >= paramInt2)
    {
      bia.put(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    throw new zza(bia.position(), bia.limit());
  }
  
  public void zzdb(long paramLong)
    throws IOException
  {
    if (bia.remaining() < 8) {
      throw new zza(bia.position(), bia.limit());
    }
    bia.putLong(paramLong);
  }
  
  public void zzde(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      zzaeq(i);
      return;
    }
  }
  
  public void zzj(int paramInt, boolean paramBoolean)
    throws IOException
  {
    zzai(paramInt, 0);
    zzde(paramBoolean);
  }
  
  public void zzk(float paramFloat)
    throws IOException
  {
    zzaeu(Float.floatToIntBits(paramFloat));
  }
  
  public void zzo(double paramDouble)
    throws IOException
  {
    zzdb(Double.doubleToLongBits(paramDouble));
  }
  
  public void zzr(int paramInt, String paramString)
    throws IOException
  {
    zzai(paramInt, 2);
    zztf(paramString);
  }
  
  public void zztf(String paramString)
    throws IOException
  {
    int i;
    int j;
    try
    {
      i = zzaet(paramString.length());
      if (i != zzaet(paramString.length() * 3)) {
        break label150;
      }
      j = bia.position();
      if (bia.remaining() < i) {
        throw new zza(i + j, bia.limit());
      }
    }
    catch (BufferOverflowException paramString)
    {
      zza localzza = new zza(bia.position(), bia.limit());
      localzza.initCause(paramString);
      throw localzza;
    }
    bia.position(j + i);
    zza(paramString, bia);
    int k = bia.position();
    bia.position(j);
    zzaes(k - j - i);
    bia.position(k);
    return;
    label150:
    zzaes(zzd(paramString));
    zza(paramString, bia);
  }
  
  public static class zza
    extends IOException
  {
    zza(int paramInt1, int paramInt2)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaov
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */