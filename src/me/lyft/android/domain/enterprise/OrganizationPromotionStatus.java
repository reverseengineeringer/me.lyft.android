package me.lyft.android.domain.enterprise;

import me.lyft.android.common.INullable;

public class OrganizationPromotionStatus
  implements INullable
{
  private int needed;
  private String pendingApprovalText;
  private String promotionDescription;
  private String promotionHeader;
  private int registered;
  
  public OrganizationPromotionStatus(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    needed = paramInt1;
    registered = paramInt2;
    promotionHeader = paramString1;
    promotionDescription = paramString2;
    pendingApprovalText = paramString3;
  }
  
  public static OrganizationPromotionStatus empty()
  {
    return NullOrganizationPromotionStatus.INSTANCE;
  }
  
  public int getNeeded()
  {
    return needed;
  }
  
  public String getPendingApprovalText()
  {
    return pendingApprovalText;
  }
  
  public String getPromotionDescription()
  {
    return promotionDescription;
  }
  
  public String getPromotionHeader()
  {
    return promotionHeader;
  }
  
  public int getRegistered()
  {
    return registered;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullOrganizationPromotionStatus
    extends OrganizationPromotionStatus
  {
    private static final OrganizationPromotionStatus INSTANCE = new NullOrganizationPromotionStatus();
    
    public NullOrganizationPromotionStatus()
    {
      super(0, "", "", "");
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.enterprise.OrganizationPromotionStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */