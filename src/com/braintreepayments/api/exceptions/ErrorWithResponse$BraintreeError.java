package com.braintreepayments.api.exceptions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ErrorWithResponse$BraintreeError
  implements Parcelable
{
  public static final Parcelable.Creator<BraintreeError> CREATOR = new Parcelable.Creator()
  {
    public ErrorWithResponse.BraintreeError createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ErrorWithResponse.BraintreeError(paramAnonymousParcel, null);
    }
    
    public ErrorWithResponse.BraintreeError[] newArray(int paramAnonymousInt)
    {
      return new ErrorWithResponse.BraintreeError[paramAnonymousInt];
    }
  };
  private String field;
  private List<BraintreeError> fieldErrors = new ArrayList();
  private String message;
  
  public ErrorWithResponse$BraintreeError() {}
  
  private ErrorWithResponse$BraintreeError(Parcel paramParcel)
  {
    fieldErrors = new ArrayList();
    paramParcel.readList(fieldErrors, ArrayList.class.getClassLoader());
    field = paramParcel.readString();
    message = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public BraintreeError errorFor(String paramString)
  {
    if (fieldErrors != null)
    {
      Iterator localIterator = fieldErrors.iterator();
      while (localIterator.hasNext())
      {
        BraintreeError localBraintreeError = (BraintreeError)localIterator.next();
        if (field.equals(paramString)) {
          return localBraintreeError;
        }
      }
    }
    return null;
  }
  
  public String getField()
  {
    return field;
  }
  
  public List<BraintreeError> getFieldErrors()
  {
    return fieldErrors;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("BraintreeError for ").append(field).append(": ").append(message).append(" -> ");
    if (fieldErrors != null) {}
    for (String str = fieldErrors.toString();; str = "") {
      return str;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(fieldErrors);
    paramParcel.writeString(field);
    paramParcel.writeString(message);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.exceptions.ErrorWithResponse.BraintreeError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */