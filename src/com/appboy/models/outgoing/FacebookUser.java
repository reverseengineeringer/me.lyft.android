package com.appboy.models.outgoing;

import com.appboy.Constants;
import com.appboy.enums.Gender;
import com.appboy.models.IPutIntoJson;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookUser
  implements IPutIntoJson<JSONObject>
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, FacebookUser.class.getName() });
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final Gender h;
  private final Integer i;
  private final Collection<String> j;
  private final String k;
  
  public FacebookUser(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Gender paramGender, Integer paramInteger, Collection<String> paramCollection, String paramString7)
  {
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramString4;
    f = paramString5;
    g = paramString6;
    h = paramGender;
    i = paramInteger;
    j = paramCollection;
    k = paramString7;
  }
  
  private JSONArray a()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = j.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("name", str);
      localJSONArray.put(localJSONObject);
    }
    return localJSONArray;
  }
  
  public JSONObject forJsonPut()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      if (!StringUtils.isNullOrBlank(b)) {
        localJSONObject1.put("id", b);
      }
      if (!StringUtils.isNullOrBlank(c)) {
        localJSONObject1.put("first_name", c);
      }
      if (!StringUtils.isNullOrBlank(d)) {
        localJSONObject1.put("last_name", d);
      }
      if (!StringUtils.isNullOrBlank(e)) {
        localJSONObject1.put("email", e);
      }
      if (!StringUtils.isNullOrBlank(f)) {
        localJSONObject1.put("bio", f);
      }
      if (!StringUtils.isNullOrBlank(k)) {
        localJSONObject1.put("birthday", k);
      }
      if (!StringUtils.isNullOrBlank(g))
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("name", g);
        localJSONObject1.put("location", localJSONObject2);
      }
      if (h != null) {
        localJSONObject1.put("gender", h.forJsonPut());
      }
      localJSONObject1.put("num_friends", i);
      if ((j != null) && (!j.isEmpty())) {
        localJSONObject1.put("likes", a());
      }
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(a, "Caught exception creating facebook user Json.", localJSONException);
    }
    return localJSONObject1;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.outgoing.FacebookUser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */