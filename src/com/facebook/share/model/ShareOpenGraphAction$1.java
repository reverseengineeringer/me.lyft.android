package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ShareOpenGraphAction$1
  implements Parcelable.Creator<ShareOpenGraphAction>
{
  public ShareOpenGraphAction createFromParcel(Parcel paramParcel)
  {
    return new ShareOpenGraphAction(paramParcel);
  }
  
  public ShareOpenGraphAction[] newArray(int paramInt)
  {
    return new ShareOpenGraphAction[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareOpenGraphAction.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */