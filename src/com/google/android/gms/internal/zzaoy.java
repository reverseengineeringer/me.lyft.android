package com.google.android.gms.internal;

public final class zzaoy
  implements Cloneable
{
  private static final zzaoz bid = new zzaoz();
  private boolean bie = false;
  private int[] bif;
  private zzaoz[] big;
  private int mSize;
  
  zzaoy()
  {
    this(10);
  }
  
  zzaoy(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    bif = new int[paramInt];
    big = new zzaoz[paramInt];
    mSize = 0;
  }
  
  private int idealByteArraySize(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  private boolean zza(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean zza(zzaoz[] paramArrayOfzzaoz1, zzaoz[] paramArrayOfzzaoz2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (!paramArrayOfzzaoz1[i].equals(paramArrayOfzzaoz2[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private int zzaey(int paramInt)
  {
    int i = 0;
    int j = mSize - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = bif[k];
      if (m < paramInt) {
        i = k + 1;
      } else if (m > paramInt) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public final zzaoy ae()
  {
    int j = size();
    zzaoy localzzaoy = new zzaoy(j);
    System.arraycopy(bif, 0, bif, 0, j);
    int i = 0;
    while (i < j)
    {
      if (big[i] != null) {
        big[i] = ((zzaoz)big[i].clone());
      }
      i += 1;
    }
    mSize = j;
    return localzzaoy;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzaoy)) {
        return false;
      }
      paramObject = (zzaoy)paramObject;
      if (size() != ((zzaoy)paramObject).size()) {
        return false;
      }
    } while ((zza(bif, bif, mSize)) && (zza(big, big, mSize)));
    return false;
  }
  
  public int hashCode()
  {
    int j = 17;
    int i = 0;
    while (i < mSize)
    {
      j = (j * 31 + bif[i]) * 31 + big[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  int size()
  {
    return mSize;
  }
  
  void zza(int paramInt, zzaoz paramzzaoz)
  {
    int i = zzaey(paramInt);
    if (i >= 0)
    {
      big[i] = paramzzaoz;
      return;
    }
    i ^= 0xFFFFFFFF;
    if ((i < mSize) && (big[i] == bid))
    {
      bif[i] = paramInt;
      big[i] = paramzzaoz;
      return;
    }
    if (mSize >= bif.length)
    {
      int j = idealIntArraySize(mSize + 1);
      int[] arrayOfInt = new int[j];
      zzaoz[] arrayOfzzaoz = new zzaoz[j];
      System.arraycopy(bif, 0, arrayOfInt, 0, bif.length);
      System.arraycopy(big, 0, arrayOfzzaoz, 0, big.length);
      bif = arrayOfInt;
      big = arrayOfzzaoz;
    }
    if (mSize - i != 0)
    {
      System.arraycopy(bif, i, bif, i + 1, mSize - i);
      System.arraycopy(big, i, big, i + 1, mSize - i);
    }
    bif[i] = paramInt;
    big[i] = paramzzaoz;
    mSize += 1;
  }
  
  zzaoz zzaew(int paramInt)
  {
    paramInt = zzaey(paramInt);
    if ((paramInt < 0) || (big[paramInt] == bid)) {
      return null;
    }
    return big[paramInt];
  }
  
  zzaoz zzaex(int paramInt)
  {
    return big[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzaoy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */