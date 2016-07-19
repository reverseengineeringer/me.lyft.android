package bo.app;

import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import org.json.JSONException;
import org.json.JSONObject;

public final class dp
  extends di
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, dp.class.getName() });
  private final String b;
  
  private dp(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, String paramString)
  {
    super(paramInt1, paramInt2, paramFloat1, paramFloat2, paramInt3);
    b = paramString;
  }
  
  public static dp b(JSONObject paramJSONObject)
  {
    Object localObject = null;
    int i = paramJSONObject.optInt("resolution_width", -1);
    int j = paramJSONObject.optInt("resolution_height", -1);
    float f1 = (float)paramJSONObject.optDouble("x_dpi", -1.0D);
    float f2 = (float)paramJSONObject.optDouble("y_dpi", -1.0D);
    int k = paramJSONObject.optInt("density_default", -1);
    String str = paramJSONObject.optString("screen_type", null);
    paramJSONObject = (JSONObject)localObject;
    if (i != -1)
    {
      paramJSONObject = (JSONObject)localObject;
      if (j != -1)
      {
        paramJSONObject = (JSONObject)localObject;
        if (f1 != -1.0F)
        {
          paramJSONObject = (JSONObject)localObject;
          if (f2 != -1.0F)
          {
            paramJSONObject = (JSONObject)localObject;
            if (k != -1) {
              paramJSONObject = new dp(i, j, f1, f2, k, str);
            }
          }
        }
      }
    }
    return paramJSONObject;
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = super.a();
    try
    {
      if (b != null) {
        localJSONObject.put("screen_type", b);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(a, "Caught exception creating wear display Json.", localJSONException);
    }
    return localJSONObject;
  }
}

/* Location:
 * Qualified Name:     bo.app.dp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */