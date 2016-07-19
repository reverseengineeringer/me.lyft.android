package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SharePhotoContent$1
  implements Parcelable.Creator<SharePhotoContent>
{
  public SharePhotoContent createFromParcel(Parcel paramParcel)
  {
    return new SharePhotoContent(paramParcel);
  }
  
  public SharePhotoContent[] newArray(int paramInt)
  {
    return new SharePhotoContent[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.SharePhotoContent.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */