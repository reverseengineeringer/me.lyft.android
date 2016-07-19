package me.lyft.android.domain.invite;

import me.lyft.android.common.INullable;
import me.lyft.android.common.Strings;

public class WarmWelcome
  implements INullable
{
  private final String attribution;
  private final String credit;
  private final String photoUrl;
  private final String promo;
  
  public WarmWelcome(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    attribution = paramString1;
    credit = paramString2;
    photoUrl = paramString3;
    promo = paramString4;
  }
  
  public static WarmWelcome empty()
  {
    return NullWarmWelcome.getInstance();
  }
  
  public String getAttribution()
  {
    return attribution;
  }
  
  public String getCredit()
  {
    return credit;
  }
  
  public String getPhotoUrl()
  {
    return photoUrl;
  }
  
  public String getPromo()
  {
    return promo;
  }
  
  public boolean hasPhoto()
  {
    return !Strings.isNullOrEmpty(photoUrl);
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  static class NullWarmWelcome
    extends WarmWelcome
  {
    private static WarmWelcome INSTANCE = new NullWarmWelcome();
    
    private NullWarmWelcome()
    {
      super(null, null, null);
    }
    
    public static WarmWelcome getInstance()
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
 * Qualified Name:     me.lyft.android.domain.invite.WarmWelcome
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */