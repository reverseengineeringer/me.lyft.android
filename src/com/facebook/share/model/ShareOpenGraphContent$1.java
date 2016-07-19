package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ShareOpenGraphContent$1
  implements Parcelable.Creator<ShareOpenGraphContent>
{
  public ShareOpenGraphContent createFromParcel(Parcel paramParcel)
  {
    return new ShareOpenGraphContent(paramParcel);
  }
  
  public ShareOpenGraphContent[] newArray(int paramInt)
  {
    return new ShareOpenGraphContent[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareOpenGraphContent.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */