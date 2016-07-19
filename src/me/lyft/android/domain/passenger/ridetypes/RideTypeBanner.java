package me.lyft.android.domain.passenger.ridetypes;

import me.lyft.android.common.INullable;
import me.lyft.android.common.Objects;

public class RideTypeBanner
  implements INullable
{
  private String bannerColor;
  private String deeplink;
  private String text;
  private String textColor;
  private String url;
  
  public RideTypeBanner(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    text = paramString1;
    url = paramString2;
    deeplink = paramString3;
    textColor = paramString4;
    bannerColor = paramString5;
  }
  
  public static RideTypeBanner empty()
  {
    return NullRideTypeBanner.instance;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    label88:
    label112:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool3;
              } while (paramObject == null);
              bool1 = bool3;
            } while (getClass() != paramObject.getClass());
            paramObject = (RideTypeBanner)paramObject;
            if (text == null) {
              break;
            }
            bool1 = bool3;
          } while (!text.equals(text));
          if (url == null) {
            break label166;
          }
          bool1 = bool3;
        } while (!url.equals(url));
        if (deeplink == null) {
          break label175;
        }
        bool1 = bool3;
      } while (!deeplink.equals(deeplink));
      if (textColor == null) {
        break label184;
      }
      bool1 = bool3;
    } while (!textColor.equals(textColor));
    label136:
    if (bannerColor != null) {
      bool1 = bannerColor.equals(bannerColor);
    }
    for (;;)
    {
      return bool1;
      if (text == null) {
        break;
      }
      return false;
      label166:
      if (url == null) {
        break label88;
      }
      return false;
      label175:
      if (deeplink == null) {
        break label112;
      }
      return false;
      label184:
      if (textColor == null) {
        break label136;
      }
      return false;
      bool1 = bool2;
      if (bannerColor != null) {
        bool1 = false;
      }
    }
  }
  
  public String getBannerColor()
  {
    return bannerColor;
  }
  
  public String getDeeplink()
  {
    return deeplink;
  }
  
  public String getText()
  {
    return (String)Objects.firstNonNull(text, "");
  }
  
  public String getTextColor()
  {
    return textColor;
  }
  
  public String getUrl()
  {
    return url;
  }
  
  public int hashCode()
  {
    int n = 0;
    int i;
    int j;
    label33:
    int k;
    if (text != null)
    {
      i = text.hashCode();
      if (url == null) {
        break label109;
      }
      j = url.hashCode();
      if (deeplink == null) {
        break label114;
      }
      k = deeplink.hashCode();
      label48:
      if (textColor == null) {
        break label119;
      }
    }
    label109:
    label114:
    label119:
    for (int m = textColor.hashCode();; m = 0)
    {
      if (bannerColor != null) {
        n = bannerColor.hashCode();
      }
      return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
      i = 0;
      break;
      j = 0;
      break label33;
      k = 0;
      break label48;
    }
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static final class NullRideTypeBanner
    extends RideTypeBanner
  {
    private static final RideTypeBanner instance = new NullRideTypeBanner();
    
    public NullRideTypeBanner()
    {
      super("", "", "", "");
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.RideTypeBanner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */