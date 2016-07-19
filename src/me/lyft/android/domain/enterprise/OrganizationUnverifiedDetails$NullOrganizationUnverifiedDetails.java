package me.lyft.android.domain.enterprise;

public class OrganizationUnverifiedDetails$NullOrganizationUnverifiedDetails
  extends OrganizationUnverifiedDetails
{
  private static final OrganizationUnverifiedDetails INSTANCE = new NullOrganizationUnverifiedDetails();
  
  public OrganizationUnverifiedDetails$NullOrganizationUnverifiedDetails()
  {
    super("", "");
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.enterprise.OrganizationUnverifiedDetails.NullOrganizationUnverifiedDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */