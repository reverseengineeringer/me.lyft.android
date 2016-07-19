package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;

public final class ShareVideo$Builder
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

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareVideo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */