package com.facebook.internal;

import com.facebook.FacebookException;
import org.json.JSONObject;

public abstract interface Utility$GraphMeRequestWithCacheCallback
{
  public abstract void onFailure(FacebookException paramFacebookException);
  
  public abstract void onSuccess(JSONObject paramJSONObject);
}

/* Location:
 * Qualified Name:     com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */