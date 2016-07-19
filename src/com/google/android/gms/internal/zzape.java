package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzape
{
  final byte[] bil;
  final int tag;
  
  zzape(int paramInt, byte[] paramArrayOfByte)
  {
    tag = paramInt;
    bil = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzape)) {
        return false;
      }
      paramObject = (zzape)paramObject;
    } while ((tag == tag) && (Arrays.equals(bil, bil)));
    return false;
  }
  
  public int hashCode()
  {
    return (tag + 527) * 31 + Arrays.hashCode(bil);
  }
  
  void zza(zzaov paramzzaov)
    throws IOException
  {
    paramzzaov.zzaes(tag);
    paramzzaov.zzbd(bil);
  }
  
  int zzy()
  {
    return zzaov.zzaet(tag) + 0 + bil.length;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzape
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */