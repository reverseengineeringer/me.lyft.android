package me.lyft.android.common;

import java.io.Closeable;

public class Closeables
{
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.Closeables
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */