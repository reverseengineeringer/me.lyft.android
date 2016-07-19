package me.lyft.android.domain.enterprise;

public class OrganizationPromotionStatus$NullOrganizationPromotionStatus
  extends OrganizationPromotionStatus
{
  private static final OrganizationPromotionStatus INSTANCE = new NullOrganizationPromotionStatus();
  
  public OrganizationPromotionStatus$NullOrganizationPromotionStatus()
  {
    super(50, 0, "", "", "");
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.enterprise.OrganizationPromotionStatus.NullOrganizationPromotionStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */