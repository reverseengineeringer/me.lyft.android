package bo.app;

import com.appboy.Constants;
import com.appboy.models.IPutIntoJson;
import com.appboy.support.AppboyLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class di
  implements IPutIntoJson<JSONObject>
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, di.class.getName() });
  private final int b;
  private final int c;
  private final float d;
  private final float e;
  private final int f;
  
  public di(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    b = paramInt1;
    c = paramInt2;
    d = paramFloat1;
    e = paramFloat2;
    f = paramInt3;
  }
  
  public static di a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("resolution_width", -1);
    int j = paramJSONObject.optInt("resolution_height", -1);
    float f1 = (float)paramJSONObject.optDouble("x_dpi", -1.0D);
    float f2 = (float)paramJSONObject.optDouble("y_dpi", -1.0D);
    int k = paramJSONObject.optInt("density_default", -1);
    if ((i != -1) && (j != -1) && (f1 != -1.0F) && (f2 != -1.0F) && (k != -1)) {
      return new di(i, j, f1, f2, k);
    }
    return null;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resolution_height", c);
      localJSONObject.put("resolution_width", b);
      localJSONObject.put("x_dpi", d);
      localJSONObject.put("y_dpi", e);
      localJSONObject.put("density_default", f);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(a, "Caught exception creating display Json.", localJSONException);
    }
    return localJSONObject;
  }
}

/* Location:
 * Qualified Name:     bo.app.di
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */