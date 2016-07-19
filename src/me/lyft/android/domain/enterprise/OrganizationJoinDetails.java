package me.lyft.android.domain.enterprise;

import me.lyft.android.common.INullable;

public class OrganizationJoinDetails
  implements INullable
{
  private String joinDescription;
  private String joinHeader;
  
  public OrganizationJoinDetails(String paramString1, String paramString2)
  {
    joinHeader = paramString1;
    joinDescription = paramString2;
  }
  
  public static OrganizationJoinDetails empty()
  {
    return NullOrganizationJoinDetails.INSTANCE;
  }
  
  public String getJoinDescription()
  {
    return joinDescription;
  }
  
  public String getJoinHeader()
  {
    return joinHeader;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullOrganizationJoinDetails
    extends OrganizationJoinDetails
  {
    private static final OrganizationJoinDetails INSTANCE = new NullOrganizationJoinDetails();
    
    public NullOrganizationJoinDetails()
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
 * Qualified Name:     me.lyft.android.domain.enterprise.OrganizationJoinDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */