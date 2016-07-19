package me.lyft.android.domain.enterprise;

import com.lyft.android.api.dto.InviteTextDTO;
import com.lyft.android.api.dto.OrganizationBenefitDetailsDTO;
import com.lyft.android.api.dto.OrganizationBenefitStatusDTO;
import com.lyft.android.api.dto.OrganizationDTO;
import com.lyft.android.api.dto.OrganizationJoinDetailsDTO;
import com.lyft.android.api.dto.OrganizationPromotionDetailsDTO;
import com.lyft.android.api.dto.OrganizationPromotionStatusDTO;
import com.lyft.android.api.dto.OrganizationUnverifiedDetailsDTO;
import com.lyft.android.api.dto.UserOrganizationDTO;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.invite.InviteText;

public class UserOrganizationMapper
{
  public static UserOrganization fromDTO(UserOrganizationDTO paramUserOrganizationDTO)
  {
    if (paramUserOrganizationDTO == null) {
      return UserOrganization.empty();
    }
    return new UserOrganization((Organization)Objects.firstNonNull(fromOrganizationDTO(organization), Organization.empty()), (InviteText)Objects.firstNonNull(fromInviteTextDTO(inviteText), InviteText.empty()));
  }
  
  public static InviteText fromInviteTextDTO(InviteTextDTO paramInviteTextDTO)
  {
    return new InviteText((String)Objects.firstNonNull(emailSubject, InviteText.empty().getEmailSubject()), (String)Objects.firstNonNull(emailBody, InviteText.empty().getEmailBody()), (String)Objects.firstNonNull(smsBody, InviteText.empty().getSmsBody()), (String)Objects.firstNonNull(benefitsUrl, InviteText.empty().getBenefitsUrl()));
  }
  
  public static OrganizationBenefitDetails fromOrganizationBenefitDetailsDTO(OrganizationBenefitDetailsDTO paramOrganizationBenefitDetailsDTO)
  {
    if (paramOrganizationBenefitDetailsDTO == null) {
      return OrganizationBenefitDetails.empty();
    }
    return new OrganizationBenefitDetails((String)Objects.firstNonNull(benefitDescription, OrganizationBenefitDetails.empty().getBenefitDescription()), (String)Objects.firstNonNull(benefitCredit, OrganizationBenefitDetails.empty().getBenefitCredit()), (String)Objects.firstNonNull(benefitRestriction, OrganizationBenefitDetails.empty().getBenefitRestriction()));
  }
  
  public static OrganizationBenefitStatus fromOrganizationBenefitStatusDTO(OrganizationBenefitStatusDTO paramOrganizationBenefitStatusDTO)
  {
    if (paramOrganizationBenefitStatusDTO == null) {
      return OrganizationBenefitStatus.empty();
    }
    return new OrganizationBenefitStatus((String)Objects.firstNonNull(benefitHeader, OrganizationBenefitStatus.empty().getBenefitHeader()), (String)Objects.firstNonNull(benefitDescription, OrganizationBenefitStatus.empty().getBenefitDescription()));
  }
  
  public static Organization fromOrganizationDTO(OrganizationDTO paramOrganizationDTO)
  {
    if (paramOrganizationDTO == null) {
      return Organization.empty();
    }
    return new Organization((String)Objects.firstNonNull(email, Organization.empty().getEmail()), (String)Objects.firstNonNull(status, Organization.empty().getStatus()), (String)Objects.firstNonNull(name, Organization.empty().getName()), (OrganizationJoinDetails)Objects.firstNonNull(fromOrganizationJoinDetailsDTO(joinDetails), Organization.empty().getJoinDetails()), (OrganizationUnverifiedDetails)Objects.firstNonNull(fromOrganizationUnverifiedDetailsDTO(unverifiedDetails), Organization.empty().getUnverifiedDetails()), (OrganizationPromotionStatus)Objects.firstNonNull(fromOrganizationPromotionStatusDTO(promotionStatus), Organization.empty().getPromotionStatus()), (OrganizationPromotionDetails)Objects.firstNonNull(fromOrganizationPromotionDetailsDTO(promotionDetails), Organization.empty().getPromotionDetails()), (OrganizationBenefitDetails)Objects.firstNonNull(fromOrganizationBenefitDetailsDTO(benefitDetails), Organization.empty().getBenefitDetails()), (OrganizationBenefitStatus)Objects.firstNonNull(fromOrganizationBenefitStatusDTO(benefitStatus), Organization.empty().getBenefitStatus()));
  }
  
  public static OrganizationJoinDetails fromOrganizationJoinDetailsDTO(OrganizationJoinDetailsDTO paramOrganizationJoinDetailsDTO)
  {
    if (paramOrganizationJoinDetailsDTO == null) {
      return OrganizationJoinDetails.empty();
    }
    return new OrganizationJoinDetails((String)Objects.firstNonNull(joinHeader, OrganizationJoinDetails.empty().getJoinHeader()), (String)Objects.firstNonNull(joinDescription, OrganizationJoinDetails.empty().getJoinDescription()));
  }
  
  public static OrganizationPromotionDetails fromOrganizationPromotionDetailsDTO(OrganizationPromotionDetailsDTO paramOrganizationPromotionDetailsDTO)
  {
    if (paramOrganizationPromotionDetailsDTO == null) {
      return OrganizationPromotionDetails.empty();
    }
    return new OrganizationPromotionDetails((String)Objects.firstNonNull(promotionHeader, OrganizationPromotionDetails.empty().getPromotionHeader()), (String)Objects.firstNonNull(promotionPeriod, OrganizationPromotionDetails.empty().getPromotionPeriod()), (String)Objects.firstNonNull(promotionDescription, OrganizationPromotionDetails.empty().getPromotionDescription()));
  }
  
  public static OrganizationPromotionStatus fromOrganizationPromotionStatusDTO(OrganizationPromotionStatusDTO paramOrganizationPromotionStatusDTO)
  {
    if (paramOrganizationPromotionStatusDTO == null) {
      return OrganizationPromotionStatus.empty();
    }
    return new OrganizationPromotionStatus(((Integer)Objects.firstNonNull(needed, Integer.valueOf(OrganizationPromotionStatus.empty().getNeeded()))).intValue(), ((Integer)Objects.firstNonNull(registered, Integer.valueOf(OrganizationPromotionStatus.empty().getRegistered()))).intValue(), (String)Objects.firstNonNull(promotionHeader, OrganizationPromotionStatus.empty().getPromotionHeader()), (String)Objects.firstNonNull(promotionDescription, OrganizationPromotionStatus.empty().getPromotionDescription()), (String)Objects.firstNonNull(pendingApprovalText, OrganizationPromotionStatus.empty().getPendingApprovalText()));
  }
  
  public static OrganizationUnverifiedDetails fromOrganizationUnverifiedDetailsDTO(OrganizationUnverifiedDetailsDTO paramOrganizationUnverifiedDetailsDTO)
  {
    if (paramOrganizationUnverifiedDetailsDTO == null) {
      return OrganizationUnverifiedDetails.empty();
    }
    return new OrganizationUnverifiedDetails((String)Objects.firstNonNull(unverifiedHeader, OrganizationUnverifiedDetails.empty().getUnverifiedHeader()), (String)Objects.firstNonNull(unverifiedDescription, OrganizationUnverifiedDetails.empty().getUnverifiedDescription()));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.enterprise.UserOrganizationMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */