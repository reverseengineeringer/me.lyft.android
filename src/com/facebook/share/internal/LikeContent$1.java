package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class LikeContent$1
  implements Parcelable.Creator<LikeContent>
{
  public LikeContent createFromParcel(Parcel paramParcel)
  {
    return new LikeContent(paramParcel);
  }
  
  public LikeContent[] newArray(int paramInt)
  {
    return new LikeContent[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeContent.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */