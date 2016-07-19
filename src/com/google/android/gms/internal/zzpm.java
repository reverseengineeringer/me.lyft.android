package com.google.android.gms.internal;

public class zzpm
{
  public static long zzd(long paramLong1, long paramLong2)
  {
    if (paramLong1 >= 0L) {
      return paramLong1 % paramLong2;
    }
    return (Long.MAX_VALUE % paramLong2 + 1L + (paramLong1 & 0x7FFFFFFFFFFFFFFF) % paramLong2) % paramLong2;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */