package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.braintreepayments.api.Utils;
import com.braintreepayments.api.annotations.Beta;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

@Beta
public class ThreeDSecureLookup
  implements Parcelable
{
  public static final Parcelable.Creator<ThreeDSecureLookup> CREATOR = new Parcelable.Creator()
  {
    public ThreeDSecureLookup createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ThreeDSecureLookup(paramAnonymousParcel, null);
    }
    
    public ThreeDSecureLookup[] newArray(int paramAnonymousInt)
    {
      return new ThreeDSecureLookup[paramAnonymousInt];
    }
  };
  private String acsUrl;
  private Card card;
  private String md;
  private String pareq;
  private String termUrl;
  
  public ThreeDSecureLookup() {}
  
  private ThreeDSecureLookup(Parcel paramParcel)
  {
    acsUrl = paramParcel.readString();
    md = paramParcel.readString();
    termUrl = paramParcel.readString();
    pareq = paramParcel.readString();
  }
  
  public static ThreeDSecureLookup fromJson(String paramString)
    throws JSONException
  {
    Object localObject = new JSONObject(paramString);
    paramString = (Card)Utils.getGson().fromJson(((JSONObject)localObject).getJSONObject("paymentMethod").toString(), Card.class);
    paramString.setThreeDSecureInfo((ThreeDSecureInfo)Utils.getGson().fromJson(((JSONObject)localObject).getJSONObject("threeDSecureInfo").toString(), ThreeDSecureInfo.class));
    localObject = (ThreeDSecureLookup)Utils.getGson().fromJson(((JSONObject)localObject).getJSONObject("lookup").toString(), ThreeDSecureLookup.class);
    card = paramString;
    return (ThreeDSecureLookup)localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAcsUrl()
  {
    return acsUrl;
  }
  
  public Card getCard()
  {
    return card;
  }
  
  public String getMd()
  {
    return md;
  }
  
  public String getPareq()
  {
    return pareq;
  }
  
  public String getTermUrl()
  {
    return termUrl;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(acsUrl);
    paramParcel.writeString(md);
    paramParcel.writeString(termUrl);
    paramParcel.writeString(pareq);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.ThreeDSecureLookup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */