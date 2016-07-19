package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ShareFeedContent$1
  implements Parcelable.Creator<ShareFeedContent>
{
  public ShareFeedContent createFromParcel(Parcel paramParcel)
  {
    return new ShareFeedContent(paramParcel);
  }
  
  public ShareFeedContent[] newArray(int paramInt)
  {
    return new ShareFeedContent[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.ShareFeedContent.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */