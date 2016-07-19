package com.appboy.models.outgoing;

import bo.app.de;
import com.appboy.Constants;
import com.appboy.models.IPutIntoJson;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class Feedback
  implements IPutIntoJson<JSONObject>
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, Feedback.class.getName() });
  private final String b;
  private final String c;
  private final boolean d;
  private final Environment e;
  private final de f;
  
  public Feedback(String paramString1, String paramString2, boolean paramBoolean, Environment paramEnvironment, de paramde)
  {
    if (StringUtils.isNullOrBlank(paramString1)) {
      throw new IllegalArgumentException("Message cannot be null or blank");
    }
    b = paramString1;
    c = paramString2;
    d = paramBoolean;
    e = paramEnvironment;
    f = paramde;
  }
  
  public final JSONObject forJsonPut()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("message", StringUtils.checkNotNullOrEmpty(b));
      localJSONObject.put("reply_to", c);
      localJSONObject.put("is_bug", d);
      if (f != null) {
        localJSONObject.put("device", f.a());
      }
      if (e != null) {
        localJSONObject.put("environment", e.forStatelessJsonPut());
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(a, "Caught exception creating feedback Json.", localJSONException);
    }
    return localJSONObject;
  }
  
  public final String getMessage()
  {
    return b;
  }
  
  public final String getReplyToEmail()
  {
    return c;
  }
  
  public final boolean isReportingABug()
  {
    return d;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.outgoing.Feedback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */