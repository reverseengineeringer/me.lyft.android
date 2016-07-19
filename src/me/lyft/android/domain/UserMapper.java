package me.lyft.android.domain;

import com.lyft.android.api.dto.PhoneDTO;
import com.lyft.android.api.dto.UserDTO;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.LocationMapper;
import me.lyft.android.domain.payment.MoneyMapper;
import me.lyft.android.domain.profile.ProfileMapper;

public class UserMapper
{
  public static final String DRIVER = "driver";
  private static final String SEND_CONCUR_RIDE_RECEIPTS_ENABLED = "enabled";
  
  public static User fromUserDTO(UserDTO paramUserDTO)
  {
    User localUser = new User();
    localUser.setId(id);
    localUser.setLyftId((String)Objects.firstNonNull(lyftId, id));
    localUser.setFirstName(firstName);
    localUser.setLastName(lastName);
    localUser.setEmail(email);
    localUser.setPhotoUrl(userPhoto);
    localUser.setRegion(region);
    localUser.setOnboardingUrl((String)Objects.firstNonNull(onboardingUrl, ""));
    localUser.setTermsUrl((String)Objects.firstNonNull(termsUrl, ""));
    localUser.setIsDispatchable(Strings.equalsIgnoreCase(mode, "driver"));
    localUser.setShouldRedirectToDriverUi(((Boolean)Objects.firstNonNull(redirectToDriverApplication, Boolean.valueOf(false))).booleanValue());
    localUser.setIsApprovedDriver(((Boolean)Objects.firstNonNull(approvedDriver, Boolean.valueOf(false))).booleanValue());
    localUser.setWheelchairNeeded(((Boolean)Objects.firstNonNull(wheelchair, Boolean.valueOf(false))).booleanValue());
    localUser.setFacebookUid(facebookUid);
    localUser.setSubmittedDriverApplication(((Boolean)Objects.firstNonNull(driverDocumentsEnabled, Boolean.valueOf(false))).booleanValue());
    localUser.setDriverLastRide(((Boolean)Objects.firstNonNull(lastRide, Boolean.valueOf(false))).booleanValue());
    localUser.setReferralCode(referralCode);
    Phone localPhone = new Phone();
    String str;
    if (phone != null)
    {
      str = phone.number;
      localPhone.setNumber(str);
      if (phone == null) {
        break label588;
      }
      bool = ((Boolean)Objects.firstNonNull(phone.verificationNeeded, Boolean.valueOf(true))).booleanValue();
      label298:
      localPhone.setVerificationNeeded(bool);
      localUser.setPhone(localPhone);
      localUser.setLocation(LocationMapper.fromLocationDTO(location));
      localUser.setDebtMoney(MoneyMapper.fromMoneyDTO(debtMoney));
      localUser.setCarpoolDriverStatus(fromUserDtoCarpoolDriverStatus(chauffeurDriverStatus));
      localUser.setCarpoolDriverDispatchEnabled(((Boolean)Objects.firstNonNull(chauffeurDriverDispatchEnabled, Boolean.valueOf(false))).booleanValue());
      localUser.setCoarseLocationTrackingEnabled(((Boolean)Objects.firstNonNull(coarseLocationsEnabled, Boolean.valueOf(false))).booleanValue());
      if (Strings.isNullOrEmpty(expenseRidesToConcurDefault)) {
        break label593;
      }
      bool = true;
      label397:
      localUser.setIsConcurLiked(bool);
      if ((!localUser.isConcurLinked()) || (!sendConcurRideReceiptsEnabled(expenseRidesToConcurDefault))) {
        break label598;
      }
    }
    label588:
    label593:
    label598:
    for (boolean bool = true;; bool = false)
    {
      localUser.setSendConcurRideReceipts(bool);
      localUser.setShowExpressPayPopUp(((Boolean)Objects.firstNonNull(showExpressPayPopUp, Boolean.valueOf(false))).booleanValue());
      localUser.setDriverDocumentsEnabled(((Boolean)Objects.firstNonNull(driverDocumentsEnabled, Boolean.valueOf(false))).booleanValue());
      localUser.setDriverDestination(LocationMapper.fromPlaceDTO(driverDestination));
      localUser.setHasBusinessProfile(((Boolean)Objects.firstNonNull(hasBusinessProfile, Boolean.valueOf(false))).booleanValue());
      localUser.setRequestProfileV1FacebookPermissions(((Boolean)Objects.firstNonNull(requestProfileV1FacebookPermissions, Boolean.valueOf(false))).booleanValue());
      localUser.setDriverRating(driverRating);
      localUser.setHometown(ProfileMapper.getProfileValue(profileFields, 0));
      localUser.setFavoriteMusic(ProfileMapper.getProfileValue(profileFields, 1));
      localUser.setAboutMe(ProfileMapper.getProfileValue(profileFields, 2));
      localUser.setJoinDate(joinDate);
      localUser.setPushToken(googlePushToken);
      return localUser;
      str = null;
      break;
      bool = true;
      break label298;
      bool = false;
      break label397;
    }
  }
  
  private static User.CarpoolDriverStatus fromUserDtoCarpoolDriverStatus(String paramString)
  {
    if (paramString == null) {
      return User.CarpoolDriverStatus.NONE;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return User.CarpoolDriverStatus.NONE;
        if (paramString.equals("shouldShowOnboarding"))
        {
          i = 0;
          continue;
          if (paramString.equals("needsPreApprovalOnboarding"))
          {
            i = 1;
            continue;
            if (paramString.equals("needsPostApprovalOnboarding"))
            {
              i = 2;
              continue;
              if (paramString.equals("completedOnboarding")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return User.CarpoolDriverStatus.SHOULD_SHOW_ONBOARDING;
    return User.CarpoolDriverStatus.NEEDS_PRE_APPROVAL_ONBOARDING;
    return User.CarpoolDriverStatus.NEEDS_POST_APPROVAL_ONBOARDING;
    return User.CarpoolDriverStatus.COMPLETED_ONBOARDING;
  }
  
  public static boolean sendConcurRideReceiptsEnabled(String paramString)
  {
    return "enabled".equalsIgnoreCase(paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.UserMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */