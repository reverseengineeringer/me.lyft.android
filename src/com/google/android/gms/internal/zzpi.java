package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class zzpi
{
  private static long zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = 0L;
    int i = Math.min(paramInt2, 8);
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      l |= (paramArrayOfByte[(paramInt1 + paramInt2)] & 0xFF) << paramInt2 * 8;
      paramInt2 += 1;
    }
    return l;
  }
  
  private static long zza(byte[] paramArrayOfByte, long paramLong)
  {
    int j = paramArrayOfByte.length & 0xFFFFFFF8;
    int k = paramArrayOfByte.length & 0x7;
    paramLong ^= paramArrayOfByte.length * -4132994306676758123L;
    int i = 0;
    while (i < j)
    {
      l = zzaf(zzb(paramArrayOfByte, i) * -4132994306676758123L);
      i += 8;
      paramLong = (paramLong ^ l * -4132994306676758123L) * -4132994306676758123L;
    }
    long l = paramLong;
    if (k != 0) {
      l = (paramLong ^ zza(paramArrayOfByte, j, k)) * -4132994306676758123L;
    }
    return zzaf(zzaf(l) * -4132994306676758123L);
  }
  
  private static void zza(byte[] paramArrayOfByte, int paramInt, long paramLong1, long paramLong2, long[] paramArrayOfLong)
  {
    long l4 = zzb(paramArrayOfByte, paramInt);
    long l2 = zzb(paramArrayOfByte, paramInt + 8);
    long l3 = zzb(paramArrayOfByte, paramInt + 16);
    long l1 = zzb(paramArrayOfByte, paramInt + 24);
    paramLong1 = l4 + paramLong1;
    paramLong2 = Long.rotateRight(paramLong2 + paramLong1 + l1, 51);
    l2 = l2 + paramLong1 + l3;
    l3 = Long.rotateRight(l2, 23);
    paramArrayOfLong[0] = (l2 + l1);
    paramArrayOfLong[1] = (paramLong1 + (l3 + paramLong2));
  }
  
  private static long zzaf(long paramLong)
  {
    return paramLong >>> 47 ^ paramLong;
  }
  
  private static long zzb(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt, 8);
    paramArrayOfByte.order(ByteOrder.LITTLE_ENDIAN);
    return paramArrayOfByte.getLong();
  }
  
  private static long zzc(long paramLong1, long paramLong2)
  {
    paramLong2 = (paramLong2 ^ paramLong1) * -4132994306676758123L;
    paramLong1 = (paramLong2 ^ paramLong2 >>> 47 ^ paramLong1) * -4132994306676758123L;
    return (paramLong1 ^ paramLong1 >>> 47) * -4132994306676758123L;
  }
  
  public static long zzm(byte[] paramArrayOfByte)
  {
    long l3 = -6505348102511208375L;
    long l1;
    if (paramArrayOfByte.length <= 32)
    {
      l1 = zza(paramArrayOfByte, -1397348546323613475L);
      if (paramArrayOfByte.length < 8) {
        break label105;
      }
    }
    label105:
    for (long l2 = zzb(paramArrayOfByte, 0);; l2 = -6505348102511208375L)
    {
      if (paramArrayOfByte.length >= 9) {
        l3 = zzb(paramArrayOfByte, paramArrayOfByte.length - 8);
      }
      l2 = zzc(l1 + l3, l2);
      if (l2 != 0L)
      {
        l1 = l2;
        if (l2 != 1L) {}
      }
      else
      {
        l1 = l2 - 2L;
      }
      return l1;
      if (paramArrayOfByte.length <= 64)
      {
        l1 = zzn(paramArrayOfByte);
        break;
      }
      l1 = zzo(paramArrayOfByte);
      break;
    }
  }
  
  private static long zzn(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    long l1 = zzb(paramArrayOfByte, 24);
    long l2 = zzb(paramArrayOfByte, 0) + (i + zzb(paramArrayOfByte, i - 16)) * -6505348102511208375L;
    long l3 = Long.rotateRight(l2 + l1, 52);
    long l4 = Long.rotateRight(l2, 37);
    l2 += zzb(paramArrayOfByte, 8);
    long l5 = Long.rotateRight(l2, 7);
    l2 += zzb(paramArrayOfByte, 16);
    l3 = Long.rotateRight(l2, 31) + l3 + (l4 + l5);
    long l7 = zzb(paramArrayOfByte, 16) + zzb(paramArrayOfByte, i - 32);
    l4 = zzb(paramArrayOfByte, i - 8);
    l5 = Long.rotateRight(l7 + l4, 52);
    long l6 = Long.rotateRight(l7, 37);
    long l8 = l7 + zzb(paramArrayOfByte, i - 24);
    l7 = Long.rotateRight(l8, 7);
    l8 = zzb(paramArrayOfByte, i - 16) + l8;
    return zzaf(zzaf((Long.rotateRight(l8, 31) + l5 + (l6 + l7) + (l1 + l2)) * -4288712594273399085L + (l8 + l4 + l3) * -6505348102511208375L) * -6505348102511208375L + l3) * -4288712594273399085L;
  }
  
  private static long zzo(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    long l3 = zzb(paramArrayOfByte, 0);
    long l2 = zzb(paramArrayOfByte, i - 16) ^ 0x8D58AC26AFE12E47;
    long l1 = zzb(paramArrayOfByte, i - 56);
    long[] arrayOfLong1 = new long[2];
    long[] arrayOfLong2 = new long[2];
    zza(paramArrayOfByte, i - 64, i, l2, arrayOfLong1);
    zza(paramArrayOfByte, i - 32, i * -8261664234251669945L, -6505348102511208375L, arrayOfLong2);
    l1 = (l1 ^ 0xA5B85C5E198ED849) + zzaf(arrayOfLong1[1]) * -8261664234251669945L;
    l3 = Long.rotateRight(l1 + l3, 39);
    l2 = Long.rotateRight(l2, 33) * -8261664234251669945L;
    int j = 0;
    l3 = -8261664234251669945L * l3;
    i = i - 1 & 0xFFFFFFC0;
    for (;;)
    {
      l3 = Long.rotateRight(l3 + l2 + arrayOfLong1[0] + zzb(paramArrayOfByte, j + 16), 37);
      l2 = Long.rotateRight(arrayOfLong1[1] + l2 + zzb(paramArrayOfByte, j + 48), 42);
      l3 = l3 * -8261664234251669945L ^ arrayOfLong2[1];
      l2 = l2 * -8261664234251669945L ^ arrayOfLong1[0];
      long l4 = Long.rotateRight(l1 ^ arrayOfLong2[0], 33);
      zza(paramArrayOfByte, j, arrayOfLong1[1] * -8261664234251669945L, arrayOfLong2[0] + l3, arrayOfLong1);
      zza(paramArrayOfByte, j + 32, l4 + arrayOfLong2[1], l2, arrayOfLong2);
      j += 64;
      i -= 64;
      if (i == 0) {
        return zzc(zzc(arrayOfLong1[0], arrayOfLong2[0]) + zzaf(l2) * -8261664234251669945L + l3, zzc(arrayOfLong1[1], arrayOfLong2[1]) + l4);
      }
      l1 = l3;
      l3 = l4;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */