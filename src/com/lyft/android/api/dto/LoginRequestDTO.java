package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class LoginRequestDTO
{
  @SerializedName("additionalAuthMethod")
  public final AdditionalAuthMethodDTO additionalAuthMethod;
  @SerializedName("appInfoRevision")
  public final String appInfoRevision;
  @SerializedName("appStoreSource")
  public final String appStoreSource;
  @SerializedName("couponCode")
  public final String couponCode;
  @SerializedName("email")
  public final String email;
  @SerializedName("firstName")
  public final String firstName;
  @SerializedName("forceNewAccount")
  public final Boolean forceNewAccount;
  @SerializedName("lastName")
  public final String lastName;
  @SerializedName("location")
  public final LocationDTO location;
  @SerializedName("matId")
  public final String matId;
  @SerializedName("phone")
  public final PhoneDTO phone;
  @SerializedName("termsAccepted")
  public final Boolean termsAccepted;
  
  public LoginRequestDTO(String paramString1, String paramString2, String paramString3, String paramString4, PhoneDTO paramPhoneDTO, String paramString5, Boolean paramBoolean1, LocationDTO paramLocationDTO, String paramString6, String paramString7, AdditionalAuthMethodDTO paramAdditionalAuthMethodDTO, Boolean paramBoolean2)
  {
    firstName = paramString1;
    lastName = paramString2;
    email = paramString3;
    couponCode = paramString4;
    phone = paramPhoneDTO;
    matId = paramString5;
    termsAccepted = paramBoolean1;
    location = paramLocationDTO;
    appInfoRevision = paramString6;
    appStoreSource = paramString7;
    additionalAuthMethod = paramAdditionalAuthMethodDTO;
    forceNewAccount = paramBoolean2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class LoginRequestDTO {\n");
    localStringBuilder.append("  firstName: ").append(firstName).append("\n");
    localStringBuilder.append("  lastName: ").append(lastName).append("\n");
    localStringBuilder.append("  email: ").append(email).append("\n");
    localStringBuilder.append("  couponCode: ").append(couponCode).append("\n");
    localStringBuilder.append("  phone: ").append(phone).append("\n");
    localStringBuilder.append("  matId: ").append(matId).append("\n");
    localStringBuilder.append("  termsAccepted: ").append(termsAccepted).append("\n");
    localStringBuilder.append("  location: ").append(location).append("\n");
    localStringBuilder.append("  appInfoRevision: ").append(appInfoRevision).append("\n");
    localStringBuilder.append("  appStoreSource: ").append(appStoreSource).append("\n");
    localStringBuilder.append("  additionalAuthMethod: ").append(additionalAuthMethod).append("\n");
    localStringBuilder.append("  forceNewAccount: ").append(forceNewAccount).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.LoginRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */