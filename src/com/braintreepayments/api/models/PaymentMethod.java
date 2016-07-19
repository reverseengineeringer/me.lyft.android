package com.braintreepayments.api.models;

import android.os.Parcelable;
import com.braintreepayments.api.Utils;
import com.braintreepayments.api.exceptions.ServerException;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PaymentMethod
  implements Parcelable, Serializable
{
  private static final String PAYMENT_METHOD_COLLECTION_KEY = "paymentMethods";
  private static final String PAYMENT_METHOD_TYPE_KEY = "type";
  protected String description;
  protected transient String mSource;
  protected String nonce;
  protected PaymentMethodOptions options;
  
  public static List<PaymentMethod> parsePaymentMethods(String paramString)
    throws ServerException
  {
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("paymentMethods");
        if (paramString == null) {
          return Collections.emptyList();
        }
        localArrayList = new ArrayList();
        i = 0;
        if (i < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(i);
          String str = localJSONObject.getString("type");
          if (str.equals("CreditCard")) {
            localArrayList.add(Utils.getGson().fromJson(localJSONObject.toString(), Card.class));
          } else if (str.equals("PayPalAccount")) {
            localArrayList.add(Utils.getGson().fromJson(localJSONObject.toString(), PayPalAccount.class));
          }
        }
      }
      catch (JSONException paramString)
      {
        throw new ServerException("Parsing server response failed");
      }
      return localArrayList;
      i += 1;
    }
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public String getNonce()
  {
    return nonce;
  }
  
  public String getSource()
  {
    return mSource;
  }
  
  public abstract String getTypeLabel();
  
  protected void setOptions(PaymentMethodOptions paramPaymentMethodOptions)
  {
    options = paramPaymentMethodOptions;
  }
  
  public void setSource(String paramString)
  {
    mSource = paramString;
  }
  
  public static abstract interface Builder<T extends PaymentMethod>
  {
    public static final String METADATA_KEY = "_meta";
    
    public abstract T build();
    
    public abstract T fromJson(String paramString);
    
    public abstract String getApiPath();
    
    public abstract String getApiResource();
    
    public abstract Builder<T> integration(String paramString);
    
    public abstract Builder<T> source(String paramString);
    
    @Deprecated
    public abstract Map<String, Object> toJson();
    
    public abstract String toJsonString();
    
    public abstract Builder<T> validate(boolean paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.PaymentMethod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */