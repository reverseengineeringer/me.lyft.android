package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ShareHashtag$1
  implements Parcelable.Creator<ShareHashtag>
{
  public ShareHashtag createFromParcel(Parcel paramParcel)
  {
    return new ShareHashtag(paramParcel);
  }
  
  public ShareHashtag[] newArray(int paramInt)
  {
    return new ShareHashtag[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareHashtag.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */