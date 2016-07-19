package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ShareVideoContent$1
  implements Parcelable.Creator<ShareVideoContent>
{
  public ShareVideoContent createFromParcel(Parcel paramParcel)
  {
    return new ShareVideoContent(paramParcel);
  }
  
  public ShareVideoContent[] newArray(int paramInt)
  {
    return new ShareVideoContent[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareVideoContent.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */