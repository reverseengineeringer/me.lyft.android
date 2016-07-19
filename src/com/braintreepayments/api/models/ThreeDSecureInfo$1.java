package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ThreeDSecureInfo$1
  implements Parcelable.Creator<ThreeDSecureInfo>
{
  public ThreeDSecureInfo createFromParcel(Parcel paramParcel)
  {
    return new ThreeDSecureInfo(paramParcel, null);
  }
  
  public ThreeDSecureInfo[] newArray(int paramInt)
  {
    return new ThreeDSecureInfo[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.ThreeDSecureInfo.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */