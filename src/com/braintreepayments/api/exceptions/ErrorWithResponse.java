package com.braintreepayments.api.exceptions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.braintreepayments.api.Utils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ErrorWithResponse
  extends Exception
{
  private final List<BraintreeError> fieldErrors;
  private final String message;
  private final int statusCode;
  
  public ErrorWithResponse(int paramInt, BraintreeErrors paramBraintreeErrors)
  {
    statusCode = paramInt;
    if (paramBraintreeErrors != null)
    {
      fieldErrors = paramBraintreeErrors.getFieldErrors();
      message = paramBraintreeErrors.getMessage();
      return;
    }
    fieldErrors = null;
    message = "Parsing error response failed";
  }
  
  public ErrorWithResponse(int paramInt, String paramString)
  {
    this(paramInt, (BraintreeErrors)Utils.getGson().fromJson(paramString, BraintreeErrors.class));
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
  
  public List<BraintreeError> getFieldErrors()
  {
    return fieldErrors;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public int getStatusCode()
  {
    return statusCode;
  }
  
  public String toString()
  {
    return "ErrorWithResponse (" + statusCode + "): " + message + "\n" + fieldErrors.toString();
  }
  
  public static final class BraintreeError
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
    
    public BraintreeError() {}
    
    private BraintreeError(Parcel paramParcel)
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
  
  public static final class BraintreeErrors
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
    
    public BraintreeErrors() {}
    
    private BraintreeErrors(Parcel paramParcel)
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
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.exceptions.ErrorWithResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */