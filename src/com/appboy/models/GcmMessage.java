package com.appboy.models;

import com.appboy.support.AppboyLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class GcmMessage
  implements IPutIntoJson<JSONObject>
{
  private static final String a = String.format("%s.%s", new Object[] { "Appboy", GcmMessage.class.getName() });
  private final String b;
  private final String c;
  private final Map<String, String> d;
  private final String e;
  private final String f;
  private final Integer g;
  
  public GcmMessage(String paramString1, String paramString2, Map<String, String> paramMap, String paramString3, String paramString4, Integer paramInteger)
  {
    b = paramString1;
    c = paramString2;
    if (paramMap != null) {}
    for (d = paramMap;; d = new HashMap())
    {
      e = paramString3;
      f = paramString4;
      g = paramInteger;
      return;
    }
  }
  
  public JSONObject forJsonPut()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", b);
      localJSONObject.put("content", c);
      localJSONObject.put("extras", new JSONObject(d));
      if (e != null) {
        localJSONObject.put("collapse_key", e);
      }
      if (f != null) {
        localJSONObject.put("campaign_id", f);
      }
      if (g != null) {
        localJSONObject.put("notification_id", g);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(a, "Caught exception creating gcm message Json.", localJSONException);
    }
    return localJSONObject;
  }
  
  public String getCampaignId()
  {
    return f;
  }
  
  public String getContent()
  {
    return c;
  }
  
  public Map<String, String> getExtras()
  {
    return d;
  }
  
  public Integer getNotificationId()
  {
    return g;
  }
  
  public String getTitle()
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.GcmMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */