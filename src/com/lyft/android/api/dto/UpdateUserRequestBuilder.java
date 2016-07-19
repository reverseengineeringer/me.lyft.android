package com.lyft.android.api.dto;

import java.util.ArrayList;
import java.util.List;

public class UpdateUserRequestBuilder
{
  private Boolean carpoolDriverDispatchEnabled;
  private String couponCode;
  private String defaultNavApp;
  private String email;
  private String fbToken;
  private String firstName;
  private String googlePushToken;
  private List<PresignedPhotoUrlDTO> images;
  private Boolean isDriverLastRide;
  private Boolean isNavAppReroutable;
  private String lastName;
  private String mode;
  private PermissionsDTO permissions;
  private PhoneDTO phone;
  private List<String> profileFields;
  private String termsUrl;
  private Boolean wheelchair;
  
  public UpdateUserRequestDTO build()
  {
    return new UpdateUserRequestDTO(email, firstName, lastName, mode, googlePushToken, null, permissions, profileFields, images, phone, couponCode, null, termsUrl, fbToken, isDriverLastRide, wheelchair, defaultNavApp, isNavAppReroutable, carpoolDriverDispatchEnabled);
  }
  
  public UpdateUserRequestBuilder withCarpoolDriverDispatchEnabled(Boolean paramBoolean)
  {
    carpoolDriverDispatchEnabled = paramBoolean;
    return this;
  }
  
  public UpdateUserRequestBuilder withCouponCode(String paramString)
  {
    couponCode = paramString;
    return this;
  }
  
  public UpdateUserRequestBuilder withDefaultNavApp(String paramString)
  {
    defaultNavApp = paramString;
    return this;
  }
  
  public UpdateUserRequestBuilder withDriverLastRide(Boolean paramBoolean)
  {
    isDriverLastRide = paramBoolean;
    return this;
  }
  
  public UpdateUserRequestBuilder withEmail(String paramString)
  {
    email = paramString;
    return this;
  }
  
  public UpdateUserRequestBuilder withFirstName(String paramString)
  {
    firstName = paramString;
    return this;
  }
  
  public UpdateUserRequestBuilder withGooglePushToken(String paramString)
  {
    googlePushToken = paramString;
    return this;
  }
  
  public UpdateUserRequestBuilder withImage(PresignedPhotoUrlDTO paramPresignedPhotoUrlDTO)
  {
    if (images == null) {
      images = new ArrayList();
    }
    images.add(paramPresignedPhotoUrlDTO);
    return this;
  }
  
  public UpdateUserRequestBuilder withLastName(String paramString)
  {
    lastName = paramString;
    return this;
  }
  
  public UpdateUserRequestBuilder withMode(String paramString)
  {
    mode = paramString;
    return this;
  }
  
  public UpdateUserRequestBuilder withNavAppReroutable(Boolean paramBoolean)
  {
    isNavAppReroutable = paramBoolean;
    return this;
  }
  
  public UpdateUserRequestBuilder withPermissions(PermissionsDTO paramPermissionsDTO)
  {
    permissions = paramPermissionsDTO;
    return this;
  }
  
  public UpdateUserRequestBuilder withPhone(PhoneDTO paramPhoneDTO)
  {
    phone = paramPhoneDTO;
    return this;
  }
  
  public UpdateUserRequestBuilder withProfileFields(List<String> paramList)
  {
    profileFields = paramList;
    return this;
  }
  
  public UpdateUserRequestBuilder withTermsUrl(String paramString)
  {
    termsUrl = paramString;
    return this;
  }
  
  public UpdateUserRequestBuilder withWheelchair(Boolean paramBoolean)
  {
    wheelchair = paramBoolean;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.UpdateUserRequestBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */