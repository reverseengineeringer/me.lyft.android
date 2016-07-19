package com.crashlytics.android.core;

import java.util.concurrent.CountDownLatch;

class CrashlyticsCore$OptInLatch
{
  private final CountDownLatch latch = new CountDownLatch(1);
  private boolean send = false;
  
  void await()
  {
    try
    {
      latch.await();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  boolean getOptIn()
  {
    return send;
  }
  
  void setOptIn(boolean paramBoolean)
  {
    send = paramBoolean;
    latch.countDown();
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore.OptInLatch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */