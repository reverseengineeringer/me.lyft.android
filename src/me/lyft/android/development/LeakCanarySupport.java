package me.lyft.android.development;

import me.lyft.android.LyftApplication;

public class LeakCanarySupport
{
  private static Class<?> getProxyClass()
    throws ClassNotFoundException
  {
    return Class.forName("me.lyft.android.development.proxies.LeakCanaryProxy");
  }
  
  public static void installIfPresent(LyftApplication paramLyftApplication) {}
}

/* Location:
 * Qualified Name:     me.lyft.android.development.LeakCanarySupport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */