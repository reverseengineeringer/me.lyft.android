package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UpdateUserRequestDTO
{
  @SerializedName("applePushToken")
  public final String applePushToken;
  @SerializedName("chauffeurDriverDispatchEnabled")
  public final Boolean chauffeurDriverDispatchEnabled;
  @SerializedName("couponCode")
  public final String couponCode;
  @SerializedName("defaultNavApp")
  public final String defaultNavApp;
  @SerializedName("email")
  public final String email;
  @SerializedName("fbToken")
  public final String fbToken;
  @SerializedName("firstName")
  public final String firstName;
  @SerializedName("googlePushToken")
  public final String googlePushToken;
  @SerializedName("images")
  public final List<PresignedPhotoUrlDTO> images;
  @SerializedName("isNavAppReroutable")
  public final Boolean isNavAppReroutable;
  @SerializedName("lastName")
  public final String lastName;
  @SerializedName("lastRide")
  public final Boolean lastRide;
  @SerializedName("mode")
  public final String mode;
  @SerializedName("permissions")
  public final PermissionsDTO permissions;
  @SerializedName("phone")
  public final PhoneDTO phone;
  @SerializedName("profileFields")
  public final List<String> profileFields;
  @SerializedName("termsAccepted")
  public final Boolean termsAccepted;
  @SerializedName("termsUrl")
  public final String termsUrl;
  @SerializedName("wheelchair")
  public final Boolean wheelchair;
  
  public UpdateUserRequestDTO(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, PermissionsDTO paramPermissionsDTO, List<String> paramList, List<PresignedPhotoUrlDTO> paramList1, PhoneDTO paramPhoneDTO, String paramString7, Boolean paramBoolean1, String paramString8, String paramString9, Boolean paramBoolean2, Boolean paramBoolean3, String paramString10, Boolean paramBoolean4, Boolean paramBoolean5)
  {
    email = paramString1;
    firstName = paramString2;
    lastName = paramString3;
    mode = paramString4;
    googlePushToken = paramString5;
    applePushToken = paramString6;
    permissions = paramPermissionsDTO;
    profileFields = paramList;
    images = paramList1;
    phone = paramPhoneDTO;
    couponCode = paramString7;
    termsAccepted = paramBoolean1;
    termsUrl = paramString8;
    fbToken = paramString9;
    lastRide = paramBoolean2;
    wheelchair = paramBoolean3;
    defaultNavApp = paramString10;
    isNavAppReroutable = paramBoolean4;
    chauffeurDriverDispatchEnabled = paramBoolean5;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class UpdateUserRequestDTO {\n");
    localStringBuilder.append("  email: ").append(email).append("\n");
    localStringBuilder.append("  firstName: ").append(firstName).append("\n");
    localStringBuilder.append("  lastName: ").append(lastName).append("\n");
    localStringBuilder.append("  mode: ").append(mode).append("\n");
    localStringBuilder.append("  googlePushToken: ").append(googlePushToken).append("\n");
    localStringBuilder.append("  applePushToken: ").append(applePushToken).append("\n");
    localStringBuilder.append("  permissions: ").append(permissions).append("\n");
    localStringBuilder.append("  profileFields: ").append(profileFields).append("\n");
    localStringBuilder.append("  images: ").append(images).append("\n");
    localStringBuilder.append("  phone: ").append(phone).append("\n");
    localStringBuilder.append("  couponCode: ").append(couponCode).append("\n");
    localStringBuilder.append("  termsAccepted: ").append(termsAccepted).append("\n");
    localStringBuilder.append("  termsUrl: ").append(termsUrl).append("\n");
    localStringBuilder.append("  fbToken: ").append(fbToken).append("\n");
    localStringBuilder.append("  lastRide: ").append(lastRide).append("\n");
    localStringBuilder.append("  wheelchair: ").append(wheelchair).append("\n");
    localStringBuilder.append("  defaultNavApp: ").append(defaultNavApp).append("\n");
    localStringBuilder.append("  isNavAppReroutable: ").append(isNavAppReroutable).append("\n");
    localStringBuilder.append("  chauffeurDriverDispatchEnabled: ").append(chauffeurDriverDispatchEnabled).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.UpdateUserRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */