package bo.app;

import android.opengl.GLES10;

public final class jt
{
  private static ip a;
  
  static
  {
    int[] arrayOfInt = new int[1];
    GLES10.glGetIntegerv(3379, arrayOfInt, 0);
    int i = Math.max(arrayOfInt[0], 2048);
    a = new ip(i, i);
  }
  
  public static int a(ip paramip)
  {
    int i = a;
    int j = b;
    int k = aa;
    int m = ab;
    return Math.max((int)Math.ceil(i / k), (int)Math.ceil(j / m));
  }
  
  public static int a(ip paramip1, ip paramip2, int paramInt, boolean paramBoolean)
  {
    int j = 1;
    int k = a;
    int m = b;
    int n = a;
    int i1 = b;
    switch (ju.a[(paramInt - 1)])
    {
    default: 
      paramInt = 1;
      if (paramInt <= 0) {
        paramInt = j;
      }
      break;
    }
    for (;;)
    {
      int i = aa;
      j = ab;
      for (;;)
      {
        if ((k / paramInt <= i) && (m / paramInt <= j)) {
          break label256;
        }
        if (paramBoolean)
        {
          paramInt *= 2;
          continue;
          int i2;
          int i3;
          if (paramBoolean)
          {
            i2 = k / 2;
            i3 = m / 2;
            i = 1;
            for (;;)
            {
              if (i2 / i <= n)
              {
                paramInt = i;
                if (i3 / i <= i1) {
                  break;
                }
              }
              i *= 2;
            }
          }
          paramInt = Math.max(k / n, m / i1);
          break;
          if (paramBoolean)
          {
            i2 = k / 2;
            i3 = m / 2;
            i = 1;
            for (;;)
            {
              paramInt = i;
              if (i2 / i <= n) {
                break;
              }
              paramInt = i;
              if (i3 / i <= i1) {
                break;
              }
              i *= 2;
            }
          }
          paramInt = Math.min(k / n, m / i1);
          break;
        }
        paramInt += 1;
      }
      label256:
      return paramInt;
    }
  }
  
  public static ip a(jm paramjm, ip paramip)
  {
    int j = paramjm.a();
    int i = j;
    if (j <= 0) {
      i = a;
    }
    int k = paramjm.b();
    j = k;
    if (k <= 0) {
      j = b;
    }
    return new ip(i, j);
  }
  
  public static float b(ip paramip1, ip paramip2, int paramInt, boolean paramBoolean)
  {
    int k = a;
    int m = b;
    int i = a;
    int j = b;
    float f1 = k / i;
    float f2 = m / j;
    if (((paramInt == is.a) && (f1 >= f2)) || ((paramInt == is.b) && (f1 < f2)))
    {
      j = (int)(m / f1);
      paramInt = i;
      i = paramInt;
    }
    for (;;)
    {
      f2 = 1.0F;
      if ((paramBoolean) || (i >= k) || (j >= m))
      {
        f1 = f2;
        if (paramBoolean)
        {
          f1 = f2;
          if (i != k)
          {
            f1 = f2;
            if (j == m) {}
          }
        }
      }
      else
      {
        f1 = i / k;
      }
      return f1;
      i = (int)(k / f2);
      paramInt = j;
      j = paramInt;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.jt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */