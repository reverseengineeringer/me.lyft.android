package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SharePhoto$1
  implements Parcelable.Creator<SharePhoto>
{
  public SharePhoto createFromParcel(Parcel paramParcel)
  {
    return new SharePhoto(paramParcel);
  }
  
  public SharePhoto[] newArray(int paramInt)
  {
    return new SharePhoto[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.SharePhoto.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */