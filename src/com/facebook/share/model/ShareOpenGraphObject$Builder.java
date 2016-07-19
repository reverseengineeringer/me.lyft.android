package com.facebook.share.model;

import android.os.Parcel;

public final class ShareOpenGraphObject$Builder
  extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphObject, Builder>
{
  public ShareOpenGraphObject$Builder()
  {
    putBoolean("fbsdk:create_object", true);
  }
  
  public ShareOpenGraphObject build()
  {
    return new ShareOpenGraphObject(this, null);
  }
  
  Builder readFrom(Parcel paramParcel)
  {
    return (Builder)readFrom((ShareOpenGraphObject)paramParcel.readParcelable(ShareOpenGraphObject.class.getClassLoader()));
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareOpenGraphObject.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */