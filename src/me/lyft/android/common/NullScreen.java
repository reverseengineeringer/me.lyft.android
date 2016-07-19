package me.lyft.android.common;

import com.lyft.scoop.Screen;

public class NullScreen
  extends Screen
{
  private static final NullScreen instance = new NullScreen();
  
  public static NullScreen getInstance()
  {
    return instance;
  }
  
  public static boolean isNull(Screen paramScreen)
  {
    return instance.equals(paramScreen);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.NullScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */