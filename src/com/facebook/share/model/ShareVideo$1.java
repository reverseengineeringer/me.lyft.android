package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ShareVideo$1
  implements Parcelable.Creator<ShareVideo>
{
  public ShareVideo createFromParcel(Parcel paramParcel)
  {
    return new ShareVideo(paramParcel);
  }
  
  public ShareVideo[] newArray(int paramInt)
  {
    return new ShareVideo[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareVideo.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */