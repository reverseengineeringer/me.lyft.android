package me.lyft.android.domain.enterprise;

public class Organization$NullOrganization
  extends Organization
{
  private static final Organization INSTANCE = new NullOrganization();
  
  public Organization$NullOrganization()
  {
    super("", "", "", OrganizationJoinDetails.empty(), OrganizationUnverifiedDetails.empty(), OrganizationPromotionStatus.empty(), OrganizationPromotionDetails.empty(), OrganizationBenefitDetails.empty(), OrganizationBenefitStatus.empty());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.enterprise.Organization.NullOrganization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */