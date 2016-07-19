package com.appboy.enums;

public enum Month
{
  private final int a;
  
  static
  {
    FEBRUARY = new Month("FEBRUARY", 1, 1);
    MARCH = new Month("MARCH", 2, 2);
    APRIL = new Month("APRIL", 3, 3);
    MAY = new Month("MAY", 4, 4);
    JUNE = new Month("JUNE", 5, 5);
    JULY = new Month("JULY", 6, 6);
    AUGUST = new Month("AUGUST", 7, 7);
    SEPTEMBER = new Month("SEPTEMBER", 8, 8);
    OCTOBER = new Month("OCTOBER", 9, 9);
    NOVEMBER = new Month("NOVEMBER", 10, 10);
  }
  
  private Month(int paramInt)
  {
    a = paramInt;
  }
  
  public final int getValue()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     com.appboy.enums.Month
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */