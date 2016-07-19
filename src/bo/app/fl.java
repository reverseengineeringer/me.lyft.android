package bo.app;

import com.appboy.Constants;
import com.appboy.models.IPutIntoJson;
import com.appboy.support.AppboyLogger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fl
  extends JSONObject
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, fl.class.getName() });
  
  public static <TargetEnum extends Enum<TargetEnum>> TargetEnum a(JSONObject paramJSONObject, String paramString, Class<TargetEnum> paramClass)
  {
    return Enum.valueOf(paramClass, paramJSONObject.getString(paramString).toUpperCase(Locale.US));
  }
  
  public static <TargetEnum extends Enum<TargetEnum>> TargetEnum a(JSONObject paramJSONObject, String paramString, Class<TargetEnum> paramClass, TargetEnum paramTargetEnum)
  {
    try
    {
      paramJSONObject = a(paramJSONObject, paramString, paramClass);
      return paramJSONObject;
    }
    catch (Exception paramJSONObject) {}
    return paramTargetEnum;
  }
  
  public static String a(JSONObject paramJSONObject, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramJSONObject.has(paramString))
    {
      localObject1 = localObject2;
      if (!paramJSONObject.isNull(paramString)) {
        localObject1 = paramJSONObject.optString(paramString, null);
      }
    }
    return (String)localObject1;
  }
  
  public static Map<String, String> a(JSONObject paramJSONObject, Map<String, String> paramMap)
  {
    if (paramJSONObject == null)
    {
      paramJSONObject = a;
      return paramMap;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    for (;;)
    {
      paramMap = localHashMap;
      if (!localIterator.hasNext()) {
        break;
      }
      paramMap = (String)localIterator.next();
      localHashMap.put(paramMap, paramJSONObject.getString(paramMap));
    }
  }
  
  public static <T> JSONArray a(Collection<? extends IPutIntoJson<T>> paramCollection)
  {
    JSONArray localJSONArray = new JSONArray();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localJSONArray.put(((IPutIntoJson)paramCollection.next()).forJsonPut());
    }
    return localJSONArray;
  }
  
  public static JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    JSONObject localJSONObject;
    Object localObject;
    try
    {
      localJSONObject = new JSONObject();
      localObject = paramJSONObject1.keys();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localJSONObject.put(str, paramJSONObject1.get(str));
      }
      paramJSONObject1 = paramJSONObject2.keys();
    }
    catch (JSONException paramJSONObject1)
    {
      AppboyLogger.e(a, "Caught exception merging Json objects.", paramJSONObject1);
      return null;
    }
    while (paramJSONObject1.hasNext())
    {
      localObject = (String)paramJSONObject1.next();
      localJSONObject.put((String)localObject, paramJSONObject2.get((String)localObject));
    }
    return localJSONObject;
  }
}

/* Location:
 * Qualified Name:     bo.app.fl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */