package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ShareLinkContent$1
  implements Parcelable.Creator<ShareLinkContent>
{
  public ShareLinkContent createFromParcel(Parcel paramParcel)
  {
    return new ShareLinkContent(paramParcel);
  }
  
  public ShareLinkContent[] newArray(int paramInt)
  {
    return new ShareLinkContent[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareLinkContent.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */