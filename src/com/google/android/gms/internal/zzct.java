package com.google.android.gms.internal;

import java.util.PriorityQueue;

@zzir
public class zzct
{
  static long zza(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3)
  {
    return ((paramLong1 + 1073807359L - (paramInt1 + 2147483647L) % 1073807359L * paramLong2 % 1073807359L) % 1073807359L * paramLong3 % 1073807359L + (paramInt2 + 2147483647L) % 1073807359L) % 1073807359L;
  }
  
  static long zza(long paramLong, int paramInt)
  {
    long l;
    if (paramInt == 0) {
      l = 1L;
    }
    do
    {
      return l;
      l = paramLong;
    } while (paramInt == 1);
    if (paramInt % 2 == 0) {
      return zza(paramLong * paramLong % 1073807359L, paramInt / 2) % 1073807359L;
    }
    return zza(paramLong * paramLong % 1073807359L, paramInt / 2) % 1073807359L * paramLong % 1073807359L;
  }
  
  static String zza(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if (paramArrayOfString.length < paramInt1 + paramInt2)
    {
      zzkh.e("Unable to construct shingle");
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramInt1;
    while (i < paramInt1 + paramInt2 - 1)
    {
      localStringBuffer.append(paramArrayOfString[i]);
      localStringBuffer.append(' ');
      i += 1;
    }
    localStringBuffer.append(paramArrayOfString[(paramInt1 + paramInt2 - 1)]);
    return localStringBuffer.toString();
  }
  
  static void zza(int paramInt1, long paramLong, String paramString, int paramInt2, PriorityQueue<zza> paramPriorityQueue)
  {
    paramString = new zza(paramLong, paramString, paramInt2);
    if ((paramPriorityQueue.size() == paramInt1) && ((peekzzath > zzath) || (peekvalue > value))) {}
    do
    {
      do
      {
        return;
      } while (paramPriorityQueue.contains(paramString));
      paramPriorityQueue.add(paramString);
    } while (paramPriorityQueue.size() <= paramInt1);
    paramPriorityQueue.poll();
  }
  
  public static void zza(String[] paramArrayOfString, int paramInt1, int paramInt2, PriorityQueue<zza> paramPriorityQueue)
  {
    if (paramArrayOfString.length < paramInt2) {
      zza(paramInt1, zzb(paramArrayOfString, 0, paramArrayOfString.length), zza(paramArrayOfString, 0, paramArrayOfString.length), paramArrayOfString.length, paramPriorityQueue);
    }
    for (;;)
    {
      return;
      long l1 = zzb(paramArrayOfString, 0, paramInt2);
      zza(paramInt1, l1, zza(paramArrayOfString, 0, paramInt2), paramInt2, paramPriorityQueue);
      long l2 = zza(16785407L, paramInt2 - 1);
      int i = 1;
      while (i < paramArrayOfString.length - paramInt2 + 1)
      {
        l1 = zza(zzcr.zzac(paramArrayOfString[(i - 1)]), zzcr.zzac(paramArrayOfString[(i + paramInt2 - 1)]), l1, l2, 16785407L);
        zza(paramInt1, l1, zza(paramArrayOfString, i, paramInt2), paramArrayOfString.length, paramPriorityQueue);
        i += 1;
      }
    }
  }
  
  private static long zzb(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    long l = (zzcr.zzac(paramArrayOfString[paramInt1]) + 2147483647L) % 1073807359L;
    int i = paramInt1 + 1;
    while (i < paramInt1 + paramInt2)
    {
      l = (l * 16785407L % 1073807359L + (zzcr.zzac(paramArrayOfString[i]) + 2147483647L) % 1073807359L) % 1073807359L;
      i += 1;
    }
    return l;
  }
  
  public static class zza
  {
    final long value;
    final String zzatg;
    final int zzath;
    
    zza(long paramLong, String paramString, int paramInt)
    {
      value = paramLong;
      zzatg = paramString;
      zzath = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof zza))) {
        return false;
      }
      return (value == value) && (zzath == zzath);
    }
    
    public int hashCode()
    {
      return (int)value;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */