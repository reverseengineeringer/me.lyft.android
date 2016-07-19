package com.braintreepayments.api.exceptions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public final class ErrorWithResponse$BraintreeErrors
  implements Parcelable
{
  public static final Parcelable.Creator<BraintreeErrors> CREATOR = new Parcelable.Creator()
  {
    public ErrorWithResponse.BraintreeErrors createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ErrorWithResponse.BraintreeErrors(paramAnonymousParcel, null);
    }
    
    public ErrorWithResponse.BraintreeErrors[] newArray(int paramAnonymousInt)
    {
      return new ErrorWithResponse.BraintreeErrors[paramAnonymousInt];
    }
  };
  private ErrorWithResponse.BraintreeError error;
  private List<ErrorWithResponse.BraintreeError> fieldErrors = new ArrayList();
  
  public ErrorWithResponse$BraintreeErrors() {}
  
  private ErrorWithResponse$BraintreeErrors(Parcel paramParcel)
  {
    paramParcel.readTypedList(fieldErrors, ErrorWithResponse.BraintreeError.CREATOR);
    error = ((ErrorWithResponse.BraintreeError)paramParcel.readParcelable(ErrorWithResponse.BraintreeError.class.getClassLoader()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected List<ErrorWithResponse.BraintreeError> getFieldErrors()
  {
    return fieldErrors;
  }
  
  protected String getMessage()
  {
    if (error != null) {
      return error.getMessage();
    }
    return "Parsing error response failed";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedList(fieldErrors);
    paramParcel.writeParcelable(error, 0);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.exceptions.ErrorWithResponse.BraintreeErrors
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */