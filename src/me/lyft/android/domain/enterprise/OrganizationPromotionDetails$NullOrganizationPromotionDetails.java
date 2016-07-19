package me.lyft.android.domain.enterprise;

public class OrganizationPromotionDetails$NullOrganizationPromotionDetails
  extends OrganizationPromotionDetails
{
  private static final OrganizationPromotionDetails INSTANCE = new NullOrganizationPromotionDetails();
  
  public OrganizationPromotionDetails$NullOrganizationPromotionDetails()
  {
    super("", "", "");
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.enterprise.OrganizationPromotionDetails.NullOrganizationPromotionDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */