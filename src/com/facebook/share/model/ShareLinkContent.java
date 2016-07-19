package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareLinkContent
  extends ShareContent<ShareLinkContent, Builder>
{
  public static final Parcelable.Creator<ShareLinkContent> CREATOR = new Parcelable.Creator()
  {
    public ShareLinkContent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ShareLinkContent(paramAnonymousParcel);
    }
    
    public ShareLinkContent[] newArray(int paramAnonymousInt)
    {
      return new ShareLinkContent[paramAnonymousInt];
    }
  };
  private final String contentDescription;
  private final String contentTitle;
  private final Uri imageUrl;
  private final String quote;
  
  ShareLinkContent(Parcel paramParcel)
  {
    super(paramParcel);
    contentDescription = paramParcel.readString();
    contentTitle = paramParcel.readString();
    imageUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    quote = paramParcel.readString();
  }
  
  private ShareLinkContent(Builder paramBuilder)
  {
    super(paramBuilder);
    contentDescription = contentDescription;
    contentTitle = contentTitle;
    imageUrl = imageUrl;
    quote = quote;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getContentDescription()
  {
    return contentDescription;
  }
  
  public String getContentTitle()
  {
    return contentTitle;
  }
  
  public Uri getImageUrl()
  {
    return imageUrl;
  }
  
  public String getQuote()
  {
    return quote;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(contentDescription);
    paramParcel.writeString(contentTitle);
    paramParcel.writeParcelable(imageUrl, 0);
    paramParcel.writeString(quote);
  }
  
  public static final class Builder
    extends ShareContent.Builder<ShareLinkContent, Builder>
  {
    private String contentDescription;
    private String contentTitle;
    private Uri imageUrl;
    private String quote;
    
    public ShareLinkContent build()
    {
      return new ShareLinkContent(this, null);
    }
    
    public Builder readFrom(ShareLinkContent paramShareLinkContent)
    {
      if (paramShareLinkContent == null) {
        return this;
      }
      return ((Builder)super.readFrom(paramShareLinkContent)).setContentDescription(paramShareLinkContent.getContentDescription()).setImageUrl(paramShareLinkContent.getImageUrl()).setContentTitle(paramShareLinkContent.getContentTitle()).setQuote(paramShareLinkContent.getQuote());
    }
    
    public Builder setContentDescription(String paramString)
    {
      contentDescription = paramString;
      return this;
    }
    
    public Builder setContentTitle(String paramString)
    {
      contentTitle = paramString;
      return this;
    }
    
    public Builder setImageUrl(Uri paramUri)
    {
      imageUrl = paramUri;
      return this;
    }
    
    public Builder setQuote(String paramString)
    {
      quote = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareLinkContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */