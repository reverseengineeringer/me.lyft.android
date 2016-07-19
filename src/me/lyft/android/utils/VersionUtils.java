package me.lyft.android.utils;

import android.os.Build.VERSION;

public class VersionUtils
{
  private static final int MARSHMALLOW = 23;
  
  public static boolean hasJellyBean()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  public static boolean hasKitKat()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public static boolean hasLollipop()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public static boolean hasMarshmallow()
  {
    return (Build.VERSION.SDK_INT >= 23) || ("MNC".equals(Build.VERSION.CODENAME));
  }
  
  public static boolean isIceCreamSandwich()
  {
    return (Build.VERSION.SDK_INT == 14) || (Build.VERSION.SDK_INT == 15);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.utils.VersionUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */