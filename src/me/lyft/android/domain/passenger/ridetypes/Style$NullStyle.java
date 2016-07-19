package me.lyft.android.domain.passenger.ridetypes;

class Style$NullStyle
  extends Style
{
  private static final Style INSTANCE = new NullStyle();
  
  private Style$NullStyle()
  {
    super("");
  }
  
  static Style getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.Style.NullStyle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */