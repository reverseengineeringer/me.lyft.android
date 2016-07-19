package com.appboy.support;

import java.util.Random;

public final class IntentUtils
{
  private static final Random a = new Random();
  
  public static int getRequestCode()
  {
    return a.nextInt();
  }
}

/* Location:
 * Qualified Name:     com.appboy.support.IntentUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */