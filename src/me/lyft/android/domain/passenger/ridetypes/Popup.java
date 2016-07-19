package me.lyft.android.domain.passenger.ridetypes;

import me.lyft.android.common.INullable;

public class Popup
  implements INullable
{
  private final String backgroundColor;
  private final String description;
  private final String iconFile;
  private final String seats;
  private final boolean showOnFirstSelection;
  private final String title;
  
  public Popup(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    backgroundColor = paramString1;
    iconFile = paramString2;
    title = paramString3;
    seats = paramString4;
    description = paramString5;
    showOnFirstSelection = paramBoolean;
  }
  
  public static Popup empty()
  {
    return NullPopup.getInstance();
  }
  
  public String getBackgroundColor()
  {
    return backgroundColor;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public String getIconFile()
  {
    return iconFile;
  }
  
  public String getSeats()
  {
    return seats;
  }
  
  public boolean getShowOnFirstSelection()
  {
    return showOnFirstSelection;
  }
  
  public String getTitle()
  {
    return title;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  static class NullPopup
    extends Popup
  {
    private static final Popup INSTANCE = new NullPopup();
    
    private NullPopup()
    {
      super("", "", "", "", false);
    }
    
    static Popup getInstance()
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
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.Popup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */