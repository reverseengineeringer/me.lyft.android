package me.lyft.android.domain.passenger.ridetypes;

import me.lyft.android.common.INullable;

public class Style
  implements INullable
{
  private final String primaryColor;
  
  public Style(String paramString)
  {
    primaryColor = paramString;
  }
  
  public static Style empty()
  {
    return NullStyle.getInstance();
  }
  
  public String getPrimaryColor()
  {
    return primaryColor;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  static class NullStyle
    extends Style
  {
    private static final Style INSTANCE = new NullStyle();
    
    private NullStyle()
    {
      super();
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
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.Style
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */