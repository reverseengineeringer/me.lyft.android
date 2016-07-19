package me.lyft.android.domain.enterprise;

import me.lyft.android.common.INullable;

public class OrganizationPromotionDetails
  implements INullable
{
  private String promotionDescription;
  private String promotionHeader;
  private String promotionPeriod;
  
  public OrganizationPromotionDetails(String paramString1, String paramString2, String paramString3)
  {
    promotionHeader = paramString1;
    promotionPeriod = paramString2;
    promotionDescription = paramString3;
  }
  
  public static OrganizationPromotionDetails empty()
  {
    return NullOrganizationPromotionDetails.INSTANCE;
  }
  
  public String getPromotionDescription()
  {
    return promotionDescription;
  }
  
  public String getPromotionHeader()
  {
    return promotionHeader;
  }
  
  public String getPromotionPeriod()
  {
    return promotionPeriod;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullOrganizationPromotionDetails
    extends OrganizationPromotionDetails
  {
    private static final OrganizationPromotionDetails INSTANCE = new NullOrganizationPromotionDetails();
    
    public NullOrganizationPromotionDetails()
    {
      super("", "");
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.enterprise.OrganizationPromotionDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */