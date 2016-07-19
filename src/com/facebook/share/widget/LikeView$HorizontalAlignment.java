package com.facebook.share.widget;

public enum LikeView$HorizontalAlignment
{
  CENTER("center", 0),  LEFT("left", 1),  RIGHT("right", 2);
  
  static HorizontalAlignment DEFAULT = CENTER;
  private int intValue;
  private String stringValue;
  
  private LikeView$HorizontalAlignment(String paramString, int paramInt)
  {
    stringValue = paramString;
    intValue = paramInt;
  }
  
  static HorizontalAlignment fromInt(int paramInt)
  {
    HorizontalAlignment[] arrayOfHorizontalAlignment = values();
    int j = arrayOfHorizontalAlignment.length;
    int i = 0;
    while (i < j)
    {
      HorizontalAlignment localHorizontalAlignment = arrayOfHorizontalAlignment[i];
      if (localHorizontalAlignment.getValue() == paramInt) {
        return localHorizontalAlignment;
      }
      i += 1;
    }
    return null;
  }
  
  private int getValue()
  {
    return intValue;
  }
  
  public String toString()
  {
    return stringValue;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.widget.LikeView.HorizontalAlignment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */