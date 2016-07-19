package bo.app;

import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gv
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, gv.class.getName() });
  
  public static List<fx> a(JSONArray paramJSONArray)
  {
    int i = 0;
    if (paramJSONArray == null) {
      return null;
    }
    for (;;)
    {
      ArrayList localArrayList;
      JSONObject localJSONObject;
      String str;
      try
      {
        localArrayList = new ArrayList();
        if (i >= paramJSONArray.length()) {
          break label249;
        }
        localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject == null)
        {
          AppboyLogger.w(a, "Received null or blank trigger condition Json. Not parsing.");
        }
        else
        {
          str = localJSONObject.optString("type", null);
          if (StringUtils.isNullOrBlank(str)) {
            AppboyLogger.w(a, "Received triggered condition Json with null or blank type. Not parsing.");
          }
        }
      }
      catch (Exception paramJSONArray)
      {
        AppboyLogger.e(a, "Failed to deserialize trigger condition Json.");
        return null;
      }
      if (str.equals("purchase"))
      {
        localArrayList.add(new fz(localJSONObject));
      }
      else if (str.equals("custom_event"))
      {
        localArrayList.add(new fw(localJSONObject));
      }
      else if (str.equals("push_click"))
      {
        localArrayList.add(new ga(localJSONObject));
      }
      else if (str.equals("open"))
      {
        localArrayList.add(new fy());
      }
      else if (str.equals("test"))
      {
        localArrayList.add(new gb());
      }
      else
      {
        AppboyLogger.w(a, String.format("Received triggered condition Json with unknown type: %s. Not parsing.", new Object[] { str }));
        break label251;
        label249:
        return localArrayList;
      }
      label251:
      i += 1;
    }
  }
  
  public static List<fs> a(JSONArray paramJSONArray, ch paramch)
  {
    if (paramJSONArray == null) {}
    try
    {
      paramch = a;
      return null;
    }
    catch (JSONException paramch)
    {
      AppboyLogger.w(a, "Encountered JSONException processing triggered action Json: " + paramJSONArray, paramch);
      return null;
      if (!str.equals("inapp")) {
        break label167;
      }
      localArrayList.add(new ft(localJSONObject, paramch));
    }
    catch (Exception paramch)
    {
      AppboyLogger.w(a, "Failed to deserialize triggered action Json: " + paramJSONArray, paramch);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      JSONObject localJSONObject;
      String str;
      if (i < paramJSONArray.length())
      {
        localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject == null)
        {
          AppboyLogger.w(a, "Received null or blank triggered action Json. Not parsing.");
          break label167;
        }
        str = localJSONObject.optString("type");
        if (StringUtils.isNullOrBlank(str))
        {
          AppboyLogger.w(a, "Received triggered action Json with null or blank message type. Not parsing.");
          break label167;
        }
      }
      return localArrayList;
      label167:
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.gv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */