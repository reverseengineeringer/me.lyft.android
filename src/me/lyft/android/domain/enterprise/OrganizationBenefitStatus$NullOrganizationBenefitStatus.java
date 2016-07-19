package me.lyft.android.domain.enterprise;

public class OrganizationBenefitStatus$NullOrganizationBenefitStatus
  extends OrganizationBenefitStatus
{
  private static final OrganizationBenefitStatus INSTANCE = new NullOrganizationBenefitStatus();
  
  public OrganizationBenefitStatus$NullOrganizationBenefitStatus()
  {
    super("", "");
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.enterprise.OrganizationBenefitStatus.NullOrganizationBenefitStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */