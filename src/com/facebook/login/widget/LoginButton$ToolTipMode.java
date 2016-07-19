package com.facebook.login.widget;

public enum LoginButton$ToolTipMode
{
  AUTOMATIC("automatic", 0),  DISPLAY_ALWAYS("display_always", 1),  NEVER_DISPLAY("never_display", 2);
  
  public static ToolTipMode DEFAULT = AUTOMATIC;
  private int intValue;
  private String stringValue;
  
  private LoginButton$ToolTipMode(String paramString, int paramInt)
  {
    stringValue = paramString;
    intValue = paramInt;
  }
  
  public static ToolTipMode fromInt(int paramInt)
  {
    ToolTipMode[] arrayOfToolTipMode = values();
    int j = arrayOfToolTipMode.length;
    int i = 0;
    while (i < j)
    {
      ToolTipMode localToolTipMode = arrayOfToolTipMode[i];
      if (localToolTipMode.getValue() == paramInt) {
        return localToolTipMode;
      }
      i += 1;
    }
    return null;
  }
  
  public int getValue()
  {
    return intValue;
  }
  
  public String toString()
  {
    return stringValue;
  }
}

/* Location:
 * Qualified Name:     com.facebook.login.widget.LoginButton.ToolTipMode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */