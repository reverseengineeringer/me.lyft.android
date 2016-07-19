package com.facebook.share.widget;

public enum LikeView$AuxiliaryViewPosition
{
  BOTTOM("bottom", 0),  INLINE("inline", 1),  TOP("top", 2);
  
  static AuxiliaryViewPosition DEFAULT = BOTTOM;
  private int intValue;
  private String stringValue;
  
  private LikeView$AuxiliaryViewPosition(String paramString, int paramInt)
  {
    stringValue = paramString;
    intValue = paramInt;
  }
  
  static AuxiliaryViewPosition fromInt(int paramInt)
  {
    AuxiliaryViewPosition[] arrayOfAuxiliaryViewPosition = values();
    int j = arrayOfAuxiliaryViewPosition.length;
    int i = 0;
    while (i < j)
    {
      AuxiliaryViewPosition localAuxiliaryViewPosition = arrayOfAuxiliaryViewPosition[i];
      if (localAuxiliaryViewPosition.getValue() == paramInt) {
        return localAuxiliaryViewPosition;
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
 * Qualified Name:     com.facebook.share.widget.LikeView.AuxiliaryViewPosition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */