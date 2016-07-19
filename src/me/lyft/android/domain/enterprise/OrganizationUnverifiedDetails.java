package me.lyft.android.domain.enterprise;

import me.lyft.android.common.INullable;

public class OrganizationUnverifiedDetails
  implements INullable
{
  private String unverifiedDescription;
  private String unverifiedHeader;
  
  public OrganizationUnverifiedDetails(String paramString1, String paramString2)
  {
    unverifiedHeader = paramString1;
    unverifiedDescription = paramString2;
  }
  
  public static OrganizationUnverifiedDetails empty()
  {
    return NullOrganizationUnverifiedDetails.INSTANCE;
  }
  
  public String getUnverifiedDescription()
  {
    return unverifiedDescription;
  }
  
  public String getUnverifiedHeader()
  {
    return unverifiedHeader;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullOrganizationUnverifiedDetails
    extends OrganizationUnverifiedDetails
  {
    private static final OrganizationUnverifiedDetails INSTANCE = new NullOrganizationUnverifiedDetails();
    
    public NullOrganizationUnverifiedDetails()
    {
      super("");
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.enterprise.OrganizationUnverifiedDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */