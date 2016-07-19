package com.squareup.okhttp.internal.framed;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class Ping
{
  private final CountDownLatch latch = new CountDownLatch(1);
  private long received = -1L;
  private long sent = -1L;
  
  void cancel()
  {
    if ((received != -1L) || (sent == -1L)) {
      throw new IllegalStateException();
    }
    received = (sent - 1L);
    latch.countDown();
  }
  
  void receive()
  {
    if ((received != -1L) || (sent == -1L)) {
      throw new IllegalStateException();
    }
    received = System.nanoTime();
    latch.countDown();
  }
  
  public long roundTripTime()
    throws InterruptedException
  {
    latch.await();
    return received - sent;
  }
  
  public long roundTripTime(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    if (latch.await(paramLong, paramTimeUnit)) {
      return received - sent;
    }
    return -2L;
  }
  
  void send()
  {
    if (sent != -1L) {
      throw new IllegalStateException();
    }
    sent = System.nanoTime();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.Ping
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */