package android.support.v7.widget;

import android.util.SparseIntArray;

public abstract class GridLayoutManager$SpanSizeLookup
{
  private boolean mCacheSpanIndices = false;
  final SparseIntArray mSpanIndexCache = new SparseIntArray();
  
  int findReferenceIndexFromCache(int paramInt)
  {
    int i = 0;
    int j = mSpanIndexCache.size() - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      if (mSpanIndexCache.keyAt(k) < paramInt) {
        i = k + 1;
      } else {
        j = k - 1;
      }
    }
    paramInt = i - 1;
    if ((paramInt >= 0) && (paramInt < mSpanIndexCache.size())) {
      return mSpanIndexCache.keyAt(paramInt);
    }
    return -1;
  }
  
  int getCachedSpanIndex(int paramInt1, int paramInt2)
  {
    int i;
    if (!mCacheSpanIndices) {
      i = getSpanIndex(paramInt1, paramInt2);
    }
    int j;
    do
    {
      return i;
      j = mSpanIndexCache.get(paramInt1, -1);
      i = j;
    } while (j != -1);
    paramInt2 = getSpanIndex(paramInt1, paramInt2);
    mSpanIndexCache.put(paramInt1, paramInt2);
    return paramInt2;
  }
  
  public int getSpanGroupIndex(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    int i2 = getSpanSize(paramInt1);
    int m = 0;
    if (m < paramInt1)
    {
      int n = getSpanSize(m);
      int i1 = i + n;
      int k;
      if (i1 == paramInt2)
      {
        i = 0;
        k = j + 1;
      }
      for (;;)
      {
        m += 1;
        j = k;
        break;
        k = j;
        i = i1;
        if (i1 > paramInt2)
        {
          i = n;
          k = j + 1;
        }
      }
    }
    paramInt1 = j;
    if (i + i2 > paramInt2) {
      paramInt1 = j + 1;
    }
    return paramInt1;
  }
  
  public int getSpanIndex(int paramInt1, int paramInt2)
  {
    int n = getSpanSize(paramInt1);
    if (n == paramInt2) {
      paramInt1 = 0;
    }
    int i;
    do
    {
      return paramInt1;
      int k = 0;
      int m = 0;
      i = k;
      int j = m;
      if (mCacheSpanIndices)
      {
        i = k;
        j = m;
        if (mSpanIndexCache.size() > 0)
        {
          int i1 = findReferenceIndexFromCache(paramInt1);
          i = k;
          j = m;
          if (i1 >= 0)
          {
            i = mSpanIndexCache.get(i1) + getSpanSize(i1);
            j = i1 + 1;
          }
        }
      }
      if (j < paramInt1)
      {
        k = getSpanSize(j);
        m = i + k;
        if (m == paramInt2) {
          i = 0;
        }
        for (;;)
        {
          j += 1;
          break;
          i = m;
          if (m > paramInt2) {
            i = k;
          }
        }
      }
      paramInt1 = i;
    } while (i + n <= paramInt2);
    return 0;
  }
  
  public abstract int getSpanSize(int paramInt);
  
  public void invalidateSpanIndexCache()
  {
    mSpanIndexCache.clear();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.GridLayoutManager.SpanSizeLookup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */