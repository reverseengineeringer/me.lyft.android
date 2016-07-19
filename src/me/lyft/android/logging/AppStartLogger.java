package me.lyft.android.logging;

public class AppStartLogger
{
  private static final long APP_START_TIME = ;
  
  public static final void log(String paramString)
  {
    L.d("appstart " + paramString + " time:" + (System.currentTimeMillis() - APP_START_TIME), new Object[0]);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.logging.AppStartLogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */