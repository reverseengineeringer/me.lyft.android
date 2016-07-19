package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class AppInviteContent
  implements ShareModel
{
  public static final Parcelable.Creator<AppInviteContent> CREATOR = new Parcelable.Creator()
  {
    public AppInviteContent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new AppInviteContent(paramAnonymousParcel);
    }
    
    public AppInviteContent[] newArray(int paramAnonymousInt)
    {
      return new AppInviteContent[paramAnonymousInt];
    }
  };
  private final String applinkUrl;
  private final String previewImageUrl;
  private final String promoCode;
  private final String promoText;
  
  AppInviteContent(Parcel paramParcel)
  {
    applinkUrl = paramParcel.readString();
    previewImageUrl = paramParcel.readString();
    promoText = paramParcel.readString();
    promoCode = paramParcel.readString();
  }
  
  private AppInviteContent(Builder paramBuilder)
  {
    applinkUrl = applinkUrl;
    previewImageUrl = previewImageUrl;
    promoCode = promoCode;
    promoText = promoText;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getApplinkUrl()
  {
    return applinkUrl;
  }
  
  public String getPreviewImageUrl()
  {
    return previewImageUrl;
  }
  
  public String getPromotionCode()
  {
    return promoCode;
  }
  
  public String getPromotionText()
  {
    return promoText;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(applinkUrl);
    paramParcel.writeString(previewImageUrl);
    paramParcel.writeString(promoText);
    paramParcel.writeString(promoCode);
  }
  
  public static class Builder
    implements ShareModelBuilder<AppInviteContent, Builder>
  {
    private String applinkUrl;
    private String previewImageUrl;
    private String promoCode;
    private String promoText;
    
    private boolean isAlphanumericWithSpaces(String paramString)
    {
      int i = 0;
      while (i < paramString.length())
      {
        char c = paramString.charAt(i);
        if ((!Character.isDigit(c)) && (!Character.isLetter(c)) && (!Character.isSpaceChar(c))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    
    public AppInviteContent build()
    {
      return new AppInviteContent(this, null);
    }
    
    public Builder readFrom(AppInviteContent paramAppInviteContent)
    {
      if (paramAppInviteContent == null) {
        return this;
      }
      return setApplinkUrl(paramAppInviteContent.getApplinkUrl()).setPreviewImageUrl(paramAppInviteContent.getPreviewImageUrl()).setPromotionDetails(paramAppInviteContent.getPromotionText(), paramAppInviteContent.getPromotionCode());
    }
    
    public Builder setApplinkUrl(String paramString)
    {
      applinkUrl = paramString;
      return this;
    }
    
    public Builder setPreviewImageUrl(String paramString)
    {
      previewImageUrl = paramString;
      return this;
    }
    
    public Builder setPromotionDetails(String paramString1, String paramString2)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        if (paramString1.length() > 80) {
          throw new IllegalArgumentException("Invalid promotion text, promotionText needs to be between1 and 80 characters long");
        }
        if (!isAlphanumericWithSpaces(paramString1)) {
          throw new IllegalArgumentException("Invalid promotion text, promotionText can only contain alphanumericcharacters and spaces.");
        }
        if (!TextUtils.isEmpty(paramString2))
        {
          if (paramString2.length() > 10) {
            throw new IllegalArgumentException("Invalid promotion code, promotionCode can be between1 and 10 characters long");
          }
          if (!isAlphanumericWithSpaces(paramString2)) {
            throw new IllegalArgumentException("Invalid promotion code, promotionCode can only contain alphanumeric characters and spaces.");
          }
        }
      }
      else if (!TextUtils.isEmpty(paramString2))
      {
        throw new IllegalArgumentException("promotionCode cannot be specified without a valid promotionText");
      }
      promoCode = paramString2;
      promoText = paramString1;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.AppInviteContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */