package com.appboy.models;

import bo.app.ch;
import com.appboy.enums.inappmessage.MessageType;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppMessageFull
  extends InAppMessageImmersiveBase
{
  public InAppMessageFull() {}
  
  public InAppMessageFull(JSONObject paramJSONObject, ch paramch)
  {
    super(paramJSONObject, paramch);
  }
  
  public JSONObject forJsonPut()
  {
    if (e != null) {
      return e;
    }
    try
    {
      JSONObject localJSONObject = super.forJsonPut();
      localJSONObject.put("type", MessageType.FULL.name());
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.InAppMessageFull
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */