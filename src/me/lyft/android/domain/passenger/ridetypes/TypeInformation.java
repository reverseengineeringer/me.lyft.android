package me.lyft.android.domain.passenger.ridetypes;

import me.lyft.android.common.INullable;

public class TypeInformation
  implements INullable
{
  private final String description;
  private final String glyph;
  private final String image;
  private final String mapMarker;
  private final String pickupSubtitle;
  private final String subtitle;
  private final String title;
  
  public TypeInformation(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    title = paramString1;
    subtitle = paramString2;
    description = paramString3;
    pickupSubtitle = paramString4;
    glyph = paramString5;
    image = paramString6;
    mapMarker = paramString7;
  }
  
  public static TypeInformation empty()
  {
    return NullTypeInformation.getInstance();
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public String getGlyph()
  {
    return glyph;
  }
  
  public String getImage()
  {
    return image;
  }
  
  public String getMapMarker()
  {
    return mapMarker;
  }
  
  public String getPickupSubtitle()
  {
    return pickupSubtitle;
  }
  
  public String getSubtitle()
  {
    return subtitle;
  }
  
  public String getTitle()
  {
    return title;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  static class NullTypeInformation
    extends TypeInformation
  {
    private static final TypeInformation INSTANCE = new NullTypeInformation();
    
    private NullTypeInformation()
    {
      super("", "", "", "", "", "");
    }
    
    static TypeInformation getInstance()
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
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.TypeInformation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */