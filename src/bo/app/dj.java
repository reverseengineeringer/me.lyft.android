package bo.app;

import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import org.json.JSONException;
import org.json.JSONObject;

public final class dj
  implements cu
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, dj.class.getName() });
  private final double b;
  private final double c;
  private final Double d;
  private final Double e;
  
  public dj(double paramDouble1, double paramDouble2, Double paramDouble3, Double paramDouble4)
  {
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D) || (paramDouble2 > 180.0D) || (paramDouble2 < -180.0D)) {
      throw new IllegalArgumentException("Unable to create Location. Latitude and longitude values are bounded by ±90 and ±180 respectively");
    }
    b = paramDouble1;
    c = paramDouble2;
    d = paramDouble3;
    e = paramDouble4;
  }
  
  public final JSONObject a()
  {
    int j = 1;
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("latitude", b);
      localJSONObject.put("longitude", c);
      if (d != null)
      {
        i = 1;
        if (i != 0) {
          localJSONObject.put("altitude", d);
        }
        if (e == null) {
          break label87;
        }
      }
      label87:
      for (int i = j;; i = 0)
      {
        if (i != 0) {
          localJSONObject.put("ll_accuracy", e);
        }
        return localJSONObject;
        i = 0;
        break;
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(a, "Caught exception creating location Json.", localJSONException);
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.dj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */