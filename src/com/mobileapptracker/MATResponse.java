package com.mobileapptracker;

import org.json.JSONObject;

public abstract interface MATResponse
{
  public abstract void didFailWithError(JSONObject paramJSONObject);
  
  public abstract void didSucceedWithData(JSONObject paramJSONObject);
  
  public abstract void enqueuedActionWithRefId(String paramString);
}

/* Location:
 * Qualified Name:     com.mobileapptracker.MATResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */