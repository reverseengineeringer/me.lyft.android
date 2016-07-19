package me.lyft.android.domain.enterprise;

public class OrganizationJoinDetails$NullOrganizationJoinDetails
  extends OrganizationJoinDetails
{
  private static final OrganizationJoinDetails INSTANCE = new NullOrganizationJoinDetails();
  
  public OrganizationJoinDetails$NullOrganizationJoinDetails()
  {
    super("", "");
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.enterprise.OrganizationJoinDetails.NullOrganizationJoinDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */