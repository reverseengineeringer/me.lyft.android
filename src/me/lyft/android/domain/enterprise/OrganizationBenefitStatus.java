package me.lyft.android.domain.enterprise;

import me.lyft.android.common.INullable;

public class OrganizationBenefitStatus
  implements INullable
{
  private String benefitDescription;
  private String benefitHeader;
  
  public OrganizationBenefitStatus(String paramString1, String paramString2)
  {
    benefitHeader = paramString1;
    benefitDescription = paramString2;
  }
  
  public static OrganizationBenefitStatus empty()
  {
    return NullOrganizationBenefitStatus.INSTANCE;
  }
  
  public String getBenefitDescription()
  {
    return benefitDescription;
  }
  
  public String getBenefitHeader()
  {
    return benefitHeader;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullOrganizationBenefitStatus
    extends OrganizationBenefitStatus
  {
    private static final OrganizationBenefitStatus INSTANCE = new NullOrganizationBenefitStatus();
    
    public NullOrganizationBenefitStatus()
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
 * Qualified Name:     me.lyft.android.domain.enterprise.OrganizationBenefitStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */