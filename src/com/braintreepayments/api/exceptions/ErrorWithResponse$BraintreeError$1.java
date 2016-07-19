package com.braintreepayments.api.exceptions;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ErrorWithResponse$BraintreeError$1
  implements Parcelable.Creator<ErrorWithResponse.BraintreeError>
{
  public ErrorWithResponse.BraintreeError createFromParcel(Parcel paramParcel)
  {
    return new ErrorWithResponse.BraintreeError(paramParcel, null);
  }
  
  public ErrorWithResponse.BraintreeError[] newArray(int paramInt)
  {
    return new ErrorWithResponse.BraintreeError[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.exceptions.ErrorWithResponse.BraintreeError.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */