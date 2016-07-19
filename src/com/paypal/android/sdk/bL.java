package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.List;

public final class bl
  implements be
{
  private bm a;
  
  public bl(bm parambm)
  {
    a = parambm;
  }
  
  public static List d()
  {
    ArrayList localArrayList = new ArrayList();
    bm[] arrayOfbm = bm.values();
    int j = arrayOfbm.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new bl(arrayOfbm[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public final String a()
  {
    return a.name();
  }
  
  public final aD b()
  {
    return a.a();
  }
  
  public final String c()
  {
    return a.b();
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.bl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */