package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ThreeDSecureLookup$1
  implements Parcelable.Creator<ThreeDSecureLookup>
{
  public ThreeDSecureLookup createFromParcel(Parcel paramParcel)
  {
    return new ThreeDSecureLookup(paramParcel, null);
  }
  
  public ThreeDSecureLookup[] newArray(int paramInt)
  {
    return new ThreeDSecureLookup[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.ThreeDSecureLookup.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */