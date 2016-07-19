package com.appboy.models;

import bo.app.ch;
import com.appboy.enums.inappmessage.MessageType;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppMessageHtmlFull
  extends InAppMessageHtmlBase
{
  public InAppMessageHtmlFull() {}
  
  public InAppMessageHtmlFull(JSONObject paramJSONObject, ch paramch)
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
      localJSONObject.put("type", MessageType.HTML_FULL.name());
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.InAppMessageHtmlFull
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */