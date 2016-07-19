package com.appboy.models.outgoing;

import com.appboy.Constants;
import com.appboy.models.IPutIntoJson;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AttributionData
  implements IPutIntoJson<JSONObject>
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AttributionData.class.getName() });
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  
  public AttributionData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramString4;
  }
  
  public JSONObject forJsonPut()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!StringUtils.isNullOrBlank(b)) {
        localJSONObject.put("source", b);
      }
      if (!StringUtils.isNullOrBlank(c)) {
        localJSONObject.put("campaign", c);
      }
      if (!StringUtils.isNullOrBlank(d)) {
        localJSONObject.put("adgroup", d);
      }
      if (!StringUtils.isNullOrBlank(e)) {
        localJSONObject.put("ad", e);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(a, "Caught exception creating AttributionData Json.", localJSONException);
    }
    return localJSONObject;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.outgoing.AttributionData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */