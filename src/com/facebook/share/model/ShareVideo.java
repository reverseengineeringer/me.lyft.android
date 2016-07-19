package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareVideo
  extends ShareMedia
{
  public static final Parcelable.Creator<ShareVideo> CREATOR = new Parcelable.Creator()
  {
    public ShareVideo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ShareVideo(paramAnonymousParcel);
    }
    
    public ShareVideo[] newArray(int paramAnonymousInt)
    {
      return new ShareVideo[paramAnonymousInt];
    }
  };
  private final Uri localUrl;
  
  ShareVideo(Parcel paramParcel)
  {
    super(paramParcel);
    localUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
  }
  
  private ShareVideo(Builder paramBuilder)
  {
    super(paramBuilder);
    localUrl = localUrl;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Uri getLocalUrl()
  {
    return localUrl;
  }
  
  public ShareMedia.Type getMediaType()
  {
    return ShareMedia.Type.VIDEO;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(localUrl, 0);
  }
  
  public static final class Builder
    extends ShareMedia.Builder<ShareVideo, Builder>
  {
    private Uri localUrl;
    
    public ShareVideo build()
    {
      return new ShareVideo(this, null);
    }
    
    Builder readFrom(Parcel paramParcel)
    {
      return readFrom((ShareVideo)paramParcel.readParcelable(ShareVideo.class.getClassLoader()));
    }
    
    public Builder readFrom(ShareVideo paramShareVideo)
    {
      if (paramShareVideo == null) {
        return this;
      }
      return ((Builder)super.readFrom(paramShareVideo)).setLocalUrl(paramShareVideo.getLocalUrl());
    }
    
    public Builder setLocalUrl(Uri paramUri)
    {
      localUrl = paramUri;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareVideo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */