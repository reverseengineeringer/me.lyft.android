package com.facebook.internal;

import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public abstract interface BundleJSONConverter$Setter
{
  public abstract void setOnBundle(Bundle paramBundle, String paramString, Object paramObject)
    throws JSONException;
  
  public abstract void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject)
    throws JSONException;
}

/* Location:
 * Qualified Name:     com.facebook.internal.BundleJSONConverter.Setter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */