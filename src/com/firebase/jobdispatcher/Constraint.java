package com.firebase.jobdispatcher;

public final class Constraint
{
  static final int[] ALL_CONSTRAINTS = { 2, 1, 4 };
  
  static int compact(int[] paramArrayOfInt)
  {
    int j = 0;
    int k = paramArrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      j |= paramArrayOfInt[i];
      i += 1;
    }
    return j;
  }
  
  static int[] uncompact(int paramInt)
  {
    int j = 0;
    int[] arrayOfInt1 = ALL_CONSTRAINTS;
    int m = arrayOfInt1.length;
    int i = 0;
    int k;
    if (i < m)
    {
      k = arrayOfInt1[i];
      if ((paramInt & k) == k) {}
      for (k = 1;; k = 0)
      {
        j += k;
        i += 1;
        break;
      }
    }
    arrayOfInt1 = new int[j];
    int[] arrayOfInt2 = ALL_CONSTRAINTS;
    m = arrayOfInt2.length;
    j = 0;
    i = 0;
    if (j < m)
    {
      int n = arrayOfInt2[j];
      if ((paramInt & n) != n) {
        break label112;
      }
      k = i + 1;
      arrayOfInt1[i] = n;
      i = k;
    }
    label112:
    for (;;)
    {
      j += 1;
      break;
      return arrayOfInt1;
    }
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.Constraint
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */