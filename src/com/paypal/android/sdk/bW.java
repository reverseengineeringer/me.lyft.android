package com.paypal.android.sdk;

public enum bw
{
  public static bw a(String paramString)
  {
    Object localObject;
    if (paramString == null)
    {
      localObject = a;
      return (bw)localObject;
    }
    bw[] arrayOfbw = values();
    int m = arrayOfbw.length;
    int k = 0;
    for (;;)
    {
      if (k >= m) {
        break label70;
      }
      bw localbw = arrayOfbw[k];
      if ((localbw != a) && (localbw != i))
      {
        localObject = localbw;
        if (paramString.equalsIgnoreCase(localbw.toString())) {
          break;
        }
      }
      k += 1;
    }
    label70:
    return a;
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.bw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */