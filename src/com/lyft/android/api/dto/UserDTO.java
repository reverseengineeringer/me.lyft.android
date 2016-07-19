package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UserDTO
{
  @SerializedName("applePushToken")
  public final String applePushToken;
  @SerializedName("approvedDriver")
  public final Boolean approvedDriver;
  @SerializedName("chauffeurDriverDispatchEnabled")
  public final Boolean chauffeurDriverDispatchEnabled;
  @SerializedName("chauffeurDriverStatus")
  public final String chauffeurDriverStatus;
  @SerializedName("coarseLocationsEnabled")
  public final Boolean coarseLocationsEnabled;
  @SerializedName("credits")
  public final List<CreditDTO> credits;
  @SerializedName("dailyTotalFares")
  public final MoneyDTO dailyTotalFares;
  @SerializedName("debtMoney")
  public final MoneyDTO debtMoney;
  @SerializedName("driverDestination")
  public final DeprecatedPlaceDTO driverDestination;
  @SerializedName("driverDocumentsEnabled")
  public final Boolean driverDocumentsEnabled;
  @SerializedName("driverRating")
  public final Double driverRating;
  @SerializedName("email")
  public final String email;
  @SerializedName("expenseRidesToConcurDefault")
  public final String expenseRidesToConcurDefault;
  @SerializedName("facebookUid")
  public final String facebookUid;
  @SerializedName("firstName")
  public final String firstName;
  @SerializedName("googleNowRefreshToken")
  public final String googleNowRefreshToken;
  @SerializedName("googlePushToken")
  public final String googlePushToken;
  @SerializedName("hasBusinessProfile")
  public final Boolean hasBusinessProfile;
  @SerializedName("id")
  public final String id;
  @SerializedName("joinDate")
  public final String joinDate;
  @SerializedName("lastName")
  public final String lastName;
  @SerializedName("lastRide")
  public final Boolean lastRide;
  @SerializedName("location")
  public final LocationDTO location;
  @SerializedName("lyftId")
  public final String lyftId;
  @SerializedName("lyftToken")
  public final String lyftToken;
  @SerializedName("mode")
  public final String mode;
  @SerializedName("onboardingUrl")
  public final String onboardingUrl;
  @SerializedName("permissions")
  public final PermissionsDTO permissions;
  @SerializedName("phone")
  public final PhoneDTO phone;
  @SerializedName("pollingRate")
  public final Long pollingRate;
  @SerializedName("profileFields")
  public final List<String> profileFields;
  @SerializedName("pusherChannel")
  public final String pusherChannel;
  @SerializedName("redirectToDriverApplication")
  public final Boolean redirectToDriverApplication;
  @SerializedName("referralCode")
  public final String referralCode;
  @SerializedName("region")
  public final String region;
  @SerializedName("requestProfileV1FacebookPermissions")
  public final Boolean requestProfileV1FacebookPermissions;
  @SerializedName("shortcuts")
  public final List<ShortcutDTO> shortcuts;
  @SerializedName("showExpressPayPopUp")
  public final Boolean showExpressPayPopUp;
  @SerializedName("termsAccepted")
  public final Boolean termsAccepted;
  @SerializedName("termsUrl")
  public final String termsUrl;
  @SerializedName("userPhoto")
  public final String userPhoto;
  @SerializedName("wheelchair")
  public final Boolean wheelchair;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class UserDTO {\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  lyftId: ").append(lyftId).append("\n");
    localStringBuilder.append("  firstName: ").append(firstName).append("\n");
    localStringBuilder.append("  lastName: ").append(lastName).append("\n");
    localStringBuilder.append("  termsAccepted: ").append(termsAccepted).append("\n");
    localStringBuilder.append("  termsUrl: ").append(termsUrl).append("\n");
    localStringBuilder.append("  onboardingUrl: ").append(onboardingUrl).append("\n");
    localStringBuilder.append("  userPhoto: ").append(userPhoto).append("\n");
    localStringBuilder.append("  joinDate: ").append(joinDate).append("\n");
    localStringBuilder.append("  phone: ").append(phone).append("\n");
    localStringBuilder.append("  email: ").append(email).append("\n");
    localStringBuilder.append("  mode: ").append(mode).append("\n");
    localStringBuilder.append("  lyftToken: ").append(lyftToken).append("\n");
    localStringBuilder.append("  facebookUid: ").append(facebookUid).append("\n");
    localStringBuilder.append("  region: ").append(region).append("\n");
    localStringBuilder.append("  referralCode: ").append(referralCode).append("\n");
    localStringBuilder.append("  pusherChannel: ").append(pusherChannel).append("\n");
    localStringBuilder.append("  approvedDriver: ").append(approvedDriver).append("\n");
    localStringBuilder.append("  applePushToken: ").append(applePushToken).append("\n");
    localStringBuilder.append("  googlePushToken: ").append(googlePushToken).append("\n");
    localStringBuilder.append("  permissions: ").append(permissions).append("\n");
    localStringBuilder.append("  redirectToDriverApplication: ").append(redirectToDriverApplication).append("\n");
    localStringBuilder.append("  dailyTotalFares: ").append(dailyTotalFares).append("\n");
    localStringBuilder.append("  profileFields: ").append(profileFields).append("\n");
    localStringBuilder.append("  lastRide: ").append(lastRide).append("\n");
    localStringBuilder.append("  expenseRidesToConcurDefault: ").append(expenseRidesToConcurDefault).append("\n");
    localStringBuilder.append("  credits: ").append(credits).append("\n");
    localStringBuilder.append("  shortcuts: ").append(shortcuts).append("\n");
    localStringBuilder.append("  showExpressPayPopUp: ").append(showExpressPayPopUp).append("\n");
    localStringBuilder.append("  driverDocumentsEnabled: ").append(driverDocumentsEnabled).append("\n");
    localStringBuilder.append("  requestProfileV1FacebookPermissions: ").append(requestProfileV1FacebookPermissions).append("\n");
    localStringBuilder.append("  googleNowRefreshToken: ").append(googleNowRefreshToken).append("\n");
    localStringBuilder.append("  driverDestination: ").append(driverDestination).append("\n");
    localStringBuilder.append("  pollingRate: ").append(pollingRate).append("\n");
    localStringBuilder.append("  wheelchair: ").append(wheelchair).append("\n");
    localStringBuilder.append("  debtMoney: ").append(debtMoney).append("\n");
    localStringBuilder.append("  location: ").append(location).append("\n");
    localStringBuilder.append("  driverRating: ").append(driverRating).append("\n");
    localStringBuilder.append("  hasBusinessProfile: ").append(hasBusinessProfile).append("\n");
    localStringBuilder.append("  chauffeurDriverStatus: ").append(chauffeurDriverStatus).append("\n");
    localStringBuilder.append("  chauffeurDriverDispatchEnabled: ").append(chauffeurDriverDispatchEnabled).append("\n");
    localStringBuilder.append("  coarseLocationsEnabled: ").append(coarseLocationsEnabled).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.UserDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */