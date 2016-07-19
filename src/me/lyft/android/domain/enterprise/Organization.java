package me.lyft.android.domain.enterprise;

import me.lyft.android.common.INullable;

public class Organization
  implements INullable
{
  private OrganizationBenefitDetails benefitDetails;
  private OrganizationBenefitStatus benefitStatus;
  String email;
  private OrganizationJoinDetails joinDetails;
  private String name;
  private OrganizationPromotionDetails promotionDetails;
  private OrganizationPromotionStatus promotionStatus;
  private String status;
  private OrganizationUnverifiedDetails unverifiedDetails;
  
  public Organization(String paramString1, String paramString2, String paramString3, OrganizationJoinDetails paramOrganizationJoinDetails, OrganizationUnverifiedDetails paramOrganizationUnverifiedDetails, OrganizationPromotionStatus paramOrganizationPromotionStatus, OrganizationPromotionDetails paramOrganizationPromotionDetails, OrganizationBenefitDetails paramOrganizationBenefitDetails, OrganizationBenefitStatus paramOrganizationBenefitStatus)
  {
    email = paramString1;
    status = paramString2;
    name = paramString3;
    joinDetails = paramOrganizationJoinDetails;
    unverifiedDetails = paramOrganizationUnverifiedDetails;
    promotionStatus = paramOrganizationPromotionStatus;
    promotionDetails = paramOrganizationPromotionDetails;
    benefitDetails = paramOrganizationBenefitDetails;
    benefitStatus = paramOrganizationBenefitStatus;
  }
  
  public static Organization empty()
  {
    return NullOrganization.INSTANCE;
  }
  
  public OrganizationBenefitDetails getBenefitDetails()
  {
    return benefitDetails;
  }
  
  public OrganizationBenefitStatus getBenefitStatus()
  {
    return benefitStatus;
  }
  
  public String getEmail()
  {
    return email;
  }
  
  public OrganizationJoinDetails getJoinDetails()
  {
    return joinDetails;
  }
  
  public String getName()
  {
    return name;
  }
  
  public OrganizationPromotionDetails getPromotionDetails()
  {
    return promotionDetails;
  }
  
  public OrganizationPromotionStatus getPromotionStatus()
  {
    return promotionStatus;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public OrganizationUnverifiedDetails getUnverifiedDetails()
  {
    return unverifiedDetails;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullOrganization
    extends Organization
  {
    private static final Organization INSTANCE = new NullOrganization();
    
    public NullOrganization()
    {
      super("", "", OrganizationJoinDetails.empty(), OrganizationUnverifiedDetails.empty(), OrganizationPromotionStatus.empty(), OrganizationPromotionDetails.empty(), OrganizationBenefitDetails.empty(), OrganizationBenefitStatus.empty());
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.enterprise.Organization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */