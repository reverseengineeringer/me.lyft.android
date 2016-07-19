package com.appboy.models.outgoing;

import com.appboy.Constants;
import com.appboy.models.IPutIntoJson;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class TwitterUser
  implements IPutIntoJson<JSONObject>
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, TwitterUser.class.getName() });
  private final Integer b;
  private final String c;
  private final String d;
  private final String e;
  private final Integer f;
  private final Integer g;
  private final Integer h;
  private final String i;
  
  public TwitterUser(Integer paramInteger1, String paramString1, String paramString2, String paramString3, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, String paramString4)
  {
    b = paramInteger1;
    c = paramString1;
    d = paramString2;
    e = paramString3;
    f = paramInteger2;
    g = paramInteger3;
    h = paramInteger4;
    i = paramString4;
  }
  
  public JSONObject forJsonPut()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!StringUtils.isNullOrBlank(c)) {
        localJSONObject.put("screen_name", c);
      }
      if (!StringUtils.isNullOrBlank(d)) {
        localJSONObject.put("name", d);
      }
      if (!StringUtils.isNullOrBlank(e)) {
        localJSONObject.put("description", e);
      }
      if (!StringUtils.isNullOrBlank(i)) {
        localJSONObject.put("profile_image_url", i);
      }
      localJSONObject.put("id", b);
      localJSONObject.put("followers_count", f);
      localJSONObject.put("friends_count", g);
      localJSONObject.put("statuses_count", h);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(a, "Caught exception creating twitter user Json.", localJSONException);
    }
    return localJSONObject;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.outgoing.TwitterUser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */