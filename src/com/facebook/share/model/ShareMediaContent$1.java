package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ShareMediaContent$1
  implements Parcelable.Creator<ShareMediaContent>
{
  public ShareMediaContent createFromParcel(Parcel paramParcel)
  {
    return new ShareMediaContent(paramParcel);
  }
  
  public ShareMediaContent[] newArray(int paramInt)
  {
    return new ShareMediaContent[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareMediaContent.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */