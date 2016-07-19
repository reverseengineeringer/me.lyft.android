package io.fabric.sdk.android.services.concurrency.internal;

public class ExponentialBackoff
  implements Backoff
{
  private final long baseTimeMillis;
  private final int power;
  
  public ExponentialBackoff(long paramLong, int paramInt)
  {
    baseTimeMillis = paramLong;
    power = paramInt;
  }
  
  public long getDelayMillis(int paramInt)
  {
    return (baseTimeMillis * Math.pow(power, paramInt));
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.internal.ExponentialBackoff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */