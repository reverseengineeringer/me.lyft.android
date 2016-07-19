package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareVideoContent
  extends ShareContent<ShareVideoContent, Builder>
  implements ShareModel
{
  public static final Parcelable.Creator<ShareVideoContent> CREATOR = new Parcelable.Creator()
  {
    public ShareVideoContent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ShareVideoContent(paramAnonymousParcel);
    }
    
    public ShareVideoContent[] newArray(int paramAnonymousInt)
    {
      return new ShareVideoContent[paramAnonymousInt];
    }
  };
  private final String contentDescription;
  private final String contentTitle;
  private final SharePhoto previewPhoto;
  private final ShareVideo video;
  
  ShareVideoContent(Parcel paramParcel)
  {
    super(paramParcel);
    contentDescription = paramParcel.readString();
    contentTitle = paramParcel.readString();
    SharePhoto.Builder localBuilder = new SharePhoto.Builder().readFrom(paramParcel);
    if ((localBuilder.getImageUrl() != null) || (localBuilder.getBitmap() != null)) {}
    for (previewPhoto = localBuilder.build();; previewPhoto = null)
    {
      video = new ShareVideo.Builder().readFrom(paramParcel).build();
      return;
    }
  }
  
  private ShareVideoContent(Builder paramBuilder)
  {
    super(paramBuilder);
    contentDescription = contentDescription;
    contentTitle = contentTitle;
    previewPhoto = previewPhoto;
    video = video;
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
  
  public SharePhoto getPreviewPhoto()
  {
    return previewPhoto;
  }
  
  public ShareVideo getVideo()
  {
    return video;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(contentDescription);
    paramParcel.writeString(contentTitle);
    paramParcel.writeParcelable(previewPhoto, 0);
    paramParcel.writeParcelable(video, 0);
  }
  
  public static final class Builder
    extends ShareContent.Builder<ShareVideoContent, Builder>
  {
    private String contentDescription;
    private String contentTitle;
    private SharePhoto previewPhoto;
    private ShareVideo video;
    
    public ShareVideoContent build()
    {
      return new ShareVideoContent(this, null);
    }
    
    public Builder readFrom(ShareVideoContent paramShareVideoContent)
    {
      if (paramShareVideoContent == null) {
        return this;
      }
      return ((Builder)super.readFrom(paramShareVideoContent)).setContentDescription(paramShareVideoContent.getContentDescription()).setContentTitle(paramShareVideoContent.getContentTitle()).setPreviewPhoto(paramShareVideoContent.getPreviewPhoto()).setVideo(paramShareVideoContent.getVideo());
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
    
    public Builder setPreviewPhoto(SharePhoto paramSharePhoto)
    {
      if (paramSharePhoto == null) {}
      for (paramSharePhoto = null;; paramSharePhoto = new SharePhoto.Builder().readFrom(paramSharePhoto).build())
      {
        previewPhoto = paramSharePhoto;
        return this;
      }
    }
    
    public Builder setVideo(ShareVideo paramShareVideo)
    {
      if (paramShareVideo == null) {
        return this;
      }
      video = new ShareVideo.Builder().readFrom(paramShareVideo).build();
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareVideoContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */