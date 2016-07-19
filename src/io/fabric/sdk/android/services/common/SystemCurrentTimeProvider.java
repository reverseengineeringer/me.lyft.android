package io.fabric.sdk.android.services.common;

public class SystemCurrentTimeProvider
  implements CurrentTimeProvider
{
  public long getCurrentTimeMillis()
  {
    return System.currentTimeMillis();
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.SystemCurrentTimeProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */