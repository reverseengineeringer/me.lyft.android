package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzaoz
  implements Cloneable
{
  private Object aQx;
  private zzaox<?, ?> bih;
  private List<zzape> bii = new ArrayList();
  
  private byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[zzy()];
    zza(zzaov.zzba(arrayOfByte));
    return arrayOfByte;
  }
  
  public final zzaoz af()
  {
    zzaoz localzzaoz = new zzaoz();
    try
    {
      bih = bih;
      if (bii == null) {
        bii = null;
      }
      while (aQx == null)
      {
        return localzzaoz;
        bii.addAll(bii);
      }
      if (!(aQx instanceof zzapc)) {
        break label93;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    aQx = ((zzapc)((zzapc)aQx).clone());
    return localCloneNotSupportedException;
    label93:
    if ((aQx instanceof byte[]))
    {
      aQx = ((byte[])aQx).clone();
      return localCloneNotSupportedException;
    }
    Object localObject1;
    Object localObject2;
    int i;
    if ((aQx instanceof byte[][]))
    {
      localObject1 = (byte[][])aQx;
      localObject2 = new byte[localObject1.length][];
      aQx = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((aQx instanceof boolean[]))
    {
      aQx = ((boolean[])aQx).clone();
      return localCloneNotSupportedException;
    }
    if ((aQx instanceof int[]))
    {
      aQx = ((int[])aQx).clone();
      return localCloneNotSupportedException;
    }
    if ((aQx instanceof long[]))
    {
      aQx = ((long[])aQx).clone();
      return localCloneNotSupportedException;
    }
    if ((aQx instanceof float[]))
    {
      aQx = ((float[])aQx).clone();
      return localCloneNotSupportedException;
    }
    if ((aQx instanceof double[]))
    {
      aQx = ((double[])aQx).clone();
      return localCloneNotSupportedException;
    }
    if ((aQx instanceof zzapc[]))
    {
      localObject1 = (zzapc[])aQx;
      localObject2 = new zzapc[localObject1.length];
      aQx = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((zzapc)localObject1[i].clone());
        i += 1;
      }
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
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof zzaoz));
      paramObject = (zzaoz)paramObject;
      if ((aQx == null) || (aQx == null)) {
        break;
      }
      bool1 = bool2;
    } while (bih != bih);
    if (!bih.bau.isArray()) {
      return aQx.equals(aQx);
    }
    if ((aQx instanceof byte[])) {
      return Arrays.equals((byte[])aQx, (byte[])aQx);
    }
    if ((aQx instanceof int[])) {
      return Arrays.equals((int[])aQx, (int[])aQx);
    }
    if ((aQx instanceof long[])) {
      return Arrays.equals((long[])aQx, (long[])aQx);
    }
    if ((aQx instanceof float[])) {
      return Arrays.equals((float[])aQx, (float[])aQx);
    }
    if ((aQx instanceof double[])) {
      return Arrays.equals((double[])aQx, (double[])aQx);
    }
    if ((aQx instanceof boolean[])) {
      return Arrays.equals((boolean[])aQx, (boolean[])aQx);
    }
    return Arrays.deepEquals((Object[])aQx, (Object[])aQx);
    if ((bii != null) && (bii != null)) {
      return bii.equals(bii);
    }
    try
    {
      bool1 = Arrays.equals(toByteArray(), ((zzaoz)paramObject).toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException((Throwable)paramObject);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  void zza(zzaov paramzzaov)
    throws IOException
  {
    if (aQx != null) {
      bih.zza(aQx, paramzzaov);
    }
    for (;;)
    {
      return;
      Iterator localIterator = bii.iterator();
      while (localIterator.hasNext()) {
        ((zzape)localIterator.next()).zza(paramzzaov);
      }
    }
  }
  
  void zza(zzape paramzzape)
  {
    bii.add(paramzzape);
  }
  
  int zzy()
  {
    int j;
    if (aQx != null)
    {
      j = bih.zzcr(aQx);
      return j;
    }
    Iterator localIterator = bii.iterator();
    for (int i = 0;; i = ((zzape)localIterator.next()).zzy() + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaoz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */