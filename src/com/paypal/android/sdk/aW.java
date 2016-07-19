package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aw
{
  private static final String a = aw.class.getSimpleName();
  private final List b = new ArrayList();
  
  public final void a()
  {
    synchronized (b)
    {
      Iterator localIterator = b.iterator();
      if (localIterator.hasNext())
      {
        ax localax = (ax)localIterator.next();
        b.remove(localax);
      }
    }
  }
  
  public final void a(ay paramay)
  {
    synchronized (b)
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext()) {
        if (nexta == paramay)
        {
          new StringBuilder("Ignoring attempt to re-register listener ").append(paramay);
          return;
        }
      }
      b.add(new ax(this, paramay));
      return;
    }
  }
  
  public final void a(bg parambg, long paramLong)
  {
    new StringBuilder("dispatching ").append(parambg.o());
    if (parambg.p() < 0L) {
      new StringBuilder("discarding ").append(parambg.o());
    }
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      synchronized (b)
      {
        Iterator localIterator = b.iterator();
        if (localIterator.hasNext()) {
          localArrayList.add(0, (ax)localIterator.next());
        }
      }
      ??? = localArrayList.iterator();
      while (((Iterator)???).hasNext()) {
        nexta.a(parambg);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.aw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */