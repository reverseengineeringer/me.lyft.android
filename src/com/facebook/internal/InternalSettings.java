package com.facebook.internal;

public class InternalSettings
{
  private static volatile String mCustomUserAgent;
  
  public static String getCustomUserAgent()
  {
    return mCustomUserAgent;
  }
  
  public static void setCustomUserAgent(String paramString)
  {
    mCustomUserAgent = paramString;
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.InternalSettings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */