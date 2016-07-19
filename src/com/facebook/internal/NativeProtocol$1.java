package com.facebook.internal;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

final class NativeProtocol$1
  implements Runnable
{
  public void run()
  {
    try
    {
      Iterator localIterator = NativeProtocol.access$500().iterator();
      while (localIterator.hasNext()) {
        NativeProtocol.NativeAppInfo.access$600((NativeProtocol.NativeAppInfo)localIterator.next(), true);
      }
    }
    finally
    {
      NativeProtocol.access$700().set(false);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.NativeProtocol.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */