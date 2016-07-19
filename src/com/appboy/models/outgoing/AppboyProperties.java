package com.appboy.models.outgoing;

import bo.app.aa;
import bo.app.fg;
import com.appboy.Constants;
import com.appboy.models.IPutIntoJson;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import com.appboy.support.ValidationUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppboyProperties
  implements IPutIntoJson<JSONObject>
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyProperties.class.getName() });
  private JSONObject b = new JSONObject();
  
  public AppboyProperties() {}
  
  public AppboyProperties(JSONObject paramJSONObject)
  {
    b = paramJSONObject;
    Object localObject1 = new ArrayList();
    Object localObject2 = paramJSONObject.keys();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((Iterator)localObject2).next());
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (!a((String)localObject2))
      {
        b.remove((String)localObject2);
      }
      else
      {
        try
        {
          if (!(paramJSONObject.get((String)localObject2) instanceof String)) {
            break label167;
          }
          if (b(paramJSONObject.getString((String)localObject2))) {
            continue;
          }
          b.remove((String)localObject2);
        }
        catch (JSONException localJSONException)
        {
          AppboyLogger.e(a, "Caught json exception validating property with key name: " + (String)localObject2, localJSONException);
        }
        continue;
        label167:
        if (paramJSONObject.get((String)localObject2) == JSONObject.NULL) {
          b.remove((String)localObject2);
        }
      }
    }
  }
  
  private static boolean a(String paramString)
  {
    if (StringUtils.isNullOrBlank(paramString))
    {
      AppboyLogger.w(a, "The Appboy property key cannot be null or contain only whitespaces. Not adding property.");
      return false;
    }
    if (paramString.startsWith("$"))
    {
      AppboyLogger.w(a, "The leading character in the key string may not be '$'. Not adding property.");
      return false;
    }
    return true;
  }
  
  private static boolean b(String paramString)
  {
    if (StringUtils.isNullOrBlank(paramString))
    {
      AppboyLogger.w(a, "The Appboy property value cannot be null or contain only whitespaces. Not adding property.");
      return false;
    }
    return true;
  }
  
  public final AppboyProperties addProperty(String paramString, double paramDouble)
  {
    if (!a(paramString)) {
      return this;
    }
    try
    {
      b.put(ValidationUtils.ensureAppboyFieldLength(paramString), paramDouble);
      return this;
    }
    catch (JSONException paramString)
    {
      AppboyLogger.e(a, "Caught json exception trying to add property.", paramString);
    }
    return this;
  }
  
  public final AppboyProperties addProperty(String paramString, int paramInt)
  {
    if (!a(paramString)) {
      return this;
    }
    try
    {
      b.put(ValidationUtils.ensureAppboyFieldLength(paramString), paramInt);
      return this;
    }
    catch (JSONException paramString)
    {
      AppboyLogger.e(a, "Caught json exception trying to add property.", paramString);
    }
    return this;
  }
  
  public final AppboyProperties addProperty(String paramString1, String paramString2)
  {
    if ((!a(paramString1)) || (!b(paramString2))) {
      return this;
    }
    try
    {
      b.put(ValidationUtils.ensureAppboyFieldLength(paramString1), ValidationUtils.ensureAppboyFieldLength(paramString2));
      return this;
    }
    catch (JSONException paramString1)
    {
      AppboyLogger.e(a, "Caught json exception trying to add property.", paramString1);
    }
    return this;
  }
  
  public final AppboyProperties addProperty(String paramString, Date paramDate)
  {
    if (!a(paramString)) {}
    while (paramDate == null) {
      return this;
    }
    try
    {
      paramDate = fg.a(paramDate, aa.b);
      b.put(ValidationUtils.ensureAppboyFieldLength(paramString), paramDate);
      return this;
    }
    catch (JSONException paramString)
    {
      AppboyLogger.e(a, "Caught json exception trying to add property.", paramString);
    }
    return this;
  }
  
  public final AppboyProperties addProperty(String paramString, boolean paramBoolean)
  {
    if (!a(paramString)) {
      return this;
    }
    try
    {
      b.put(ValidationUtils.ensureAppboyFieldLength(paramString), paramBoolean);
      return this;
    }
    catch (JSONException paramString)
    {
      AppboyLogger.e(a, "Caught json exception trying to add property.", paramString);
    }
    return this;
  }
  
  public final JSONObject forJsonPut()
  {
    return b;
  }
  
  public final int size()
  {
    return b.length();
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.outgoing.AppboyProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */