package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.braintreepayments.api.Utils;
import com.braintreepayments.api.annotations.Beta;
import com.braintreepayments.api.exceptions.ErrorWithResponse.BraintreeError;
import com.braintreepayments.api.exceptions.ErrorWithResponse.BraintreeErrors;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

@Beta
public class ThreeDSecureAuthenticationResponse
  implements Parcelable
{
  public static final Parcelable.Creator<ThreeDSecureAuthenticationResponse> CREATOR = new Parcelable.Creator()
  {
    public ThreeDSecureAuthenticationResponse createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ThreeDSecureAuthenticationResponse(paramAnonymousParcel, null);
    }
    
    public ThreeDSecureAuthenticationResponse[] newArray(int paramAnonymousInt)
    {
      return new ThreeDSecureAuthenticationResponse[paramAnonymousInt];
    }
  };
  private Card card;
  private ErrorWithResponse.BraintreeErrors errors;
  private String exception;
  private boolean success;
  
  public ThreeDSecureAuthenticationResponse() {}
  
  private ThreeDSecureAuthenticationResponse(Parcel paramParcel)
  {
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      success = bool;
      card = ((Card)paramParcel.readParcelable(Card.class.getClassLoader()));
      errors = ((ErrorWithResponse.BraintreeErrors)paramParcel.readParcelable(ErrorWithResponse.BraintreeError.class.getClassLoader()));
      exception = paramParcel.readString();
      return;
    }
  }
  
  public static ThreeDSecureAuthenticationResponse fromException(String paramString)
  {
    ThreeDSecureAuthenticationResponse localThreeDSecureAuthenticationResponse = new ThreeDSecureAuthenticationResponse();
    success = false;
    exception = paramString;
    return localThreeDSecureAuthenticationResponse;
  }
  
  public static ThreeDSecureAuthenticationResponse fromJson(String paramString)
  {
    ThreeDSecureAuthenticationResponse localThreeDSecureAuthenticationResponse = new ThreeDSecureAuthenticationResponse();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Card localCard = (Card)Utils.getGson().fromJson(localJSONObject.getJSONObject("paymentMethod").toString(), Card.class);
      localCard.setThreeDSecureInfo((ThreeDSecureInfo)Utils.getGson().fromJson(localJSONObject.getJSONObject("threeDSecureInfo").toString(), ThreeDSecureInfo.class));
      card = localCard;
      success = localJSONObject.getBoolean("success");
      errors = ((ErrorWithResponse.BraintreeErrors)Utils.getGson().fromJson(paramString, ErrorWithResponse.BraintreeErrors.class));
      return localThreeDSecureAuthenticationResponse;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        success = false;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Card getCard()
  {
    return card;
  }
  
  public ErrorWithResponse.BraintreeErrors getErrors()
  {
    return errors;
  }
  
  public String getException()
  {
    return exception;
  }
  
  public boolean isSuccess()
  {
    return success;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (success) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeParcelable(card, paramInt);
      paramParcel.writeParcelable(errors, paramInt);
      paramParcel.writeString(exception);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.ThreeDSecureAuthenticationResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */