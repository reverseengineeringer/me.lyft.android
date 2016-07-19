package me.lyft.android.domain.enterprise;

import me.lyft.android.common.INullable;

public class OrganizationBenefitDetails
  implements INullable
{
  private String benefitCredit;
  private String benefitDescription;
  private String benefitRestriction;
  
  public OrganizationBenefitDetails(String paramString1, String paramString2, String paramString3)
  {
    benefitDescription = paramString1;
    benefitCredit = paramString2;
    benefitRestriction = paramString3;
  }
  
  public static OrganizationBenefitDetails empty()
  {
    return NullOrganizationBenefitDetails.INSTANCE;
  }
  
  public String getBenefitCredit()
  {
    return benefitCredit;
  }
  
  public String getBenefitDescription()
  {
    return benefitDescription;
  }
  
  public String getBenefitRestriction()
  {
    return benefitRestriction;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullOrganizationBenefitDetails
    extends OrganizationBenefitDetails
  {
    private static final OrganizationBenefitDetails INSTANCE = new NullOrganizationBenefitDetails();
    
    public NullOrganizationBenefitDetails()
    {
      super("", "");
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.enterprise.OrganizationBenefitDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */