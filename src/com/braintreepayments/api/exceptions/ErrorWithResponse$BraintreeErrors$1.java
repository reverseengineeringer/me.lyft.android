package com.braintreepayments.api.exceptions;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ErrorWithResponse$BraintreeErrors$1
  implements Parcelable.Creator<ErrorWithResponse.BraintreeErrors>
{
  public ErrorWithResponse.BraintreeErrors createFromParcel(Parcel paramParcel)
  {
    return new ErrorWithResponse.BraintreeErrors(paramParcel, null);
  }
  
  public ErrorWithResponse.BraintreeErrors[] newArray(int paramInt)
  {
    return new ErrorWithResponse.BraintreeErrors[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.exceptions.ErrorWithResponse.BraintreeErrors.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */