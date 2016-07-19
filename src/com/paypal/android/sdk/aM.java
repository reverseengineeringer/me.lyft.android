package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class am
{
  private List a = Collections.synchronizedList(new ArrayList());
  private List b = Collections.synchronizedList(new ArrayList());
  
  private void a()
  {
    if (!b.isEmpty()) {
      try
      {
        if (!b.isEmpty())
        {
          al localal = (al)b.get(0);
          b.remove(0);
          a.add(localal);
          new Thread(localal).start();
        }
        return;
      }
      finally {}
    }
  }
  
  public final void a(al paramal)
  {
    b.add(paramal);
    if (a.size() < 3) {
      a();
    }
  }
  
  public final void b(al paramal)
  {
    a.remove(paramal);
    a();
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.am
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */