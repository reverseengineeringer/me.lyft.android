package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ThreeDSecureAuthenticationResponse$1
  implements Parcelable.Creator<ThreeDSecureAuthenticationResponse>
{
  public ThreeDSecureAuthenticationResponse createFromParcel(Parcel paramParcel)
  {
    return new ThreeDSecureAuthenticationResponse(paramParcel, null);
  }
  
  public ThreeDSecureAuthenticationResponse[] newArray(int paramInt)
  {
    return new ThreeDSecureAuthenticationResponse[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.ThreeDSecureAuthenticationResponse.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */