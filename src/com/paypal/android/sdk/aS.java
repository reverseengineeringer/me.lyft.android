package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class as
  extends Handler
{
  private WeakReference a;
  
  public as(ar paramar)
  {
    a = new WeakReference(paramar);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    }
    ar localar;
    do
    {
      return;
      localar = (ar)a.get();
    } while (localar == null);
    ar.a(localar, (bg)obj);
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.as
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */