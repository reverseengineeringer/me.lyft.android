package bo.app;

import com.appboy.Constants;
import com.appboy.models.IPutIntoJson;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class dm
  implements IPutIntoJson<JSONObject>
{
  private static final String b = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, dm.class.getName() });
  public final do a;
  private final Integer c;
  private final String d;
  private final String e;
  private final dp f;
  
  private dm(Integer paramInteger, String paramString1, String paramString2, dp paramdp, do paramdo)
  {
    c = paramInteger;
    d = paramString1;
    e = paramString2;
    f = paramdp;
    a = paramdo;
  }
  
  public static dm a(JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    al[] arrayOfal = al.values();
    int j = arrayOfal.length;
    int i = 0;
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject5 = null;
    if (i < j)
    {
      Object localObject6 = arrayOfal[i];
      Object localObject10;
      Object localObject9;
      Object localObject8;
      Object localObject7;
      switch (dn.a[localObject6.ordinal()])
      {
      default: 
        AppboyLogger.e(b, String.format("Unknown key encountered in WearDevice createFromJson %s", new Object[] { localObject6 }));
        localObject10 = localObject1;
        localObject9 = localObject2;
        localObject8 = localObject3;
        localObject7 = localObject4;
        localObject6 = localObject5;
      }
      for (;;)
      {
        i += 1;
        localObject5 = localObject6;
        localObject4 = localObject7;
        localObject3 = localObject8;
        localObject2 = localObject9;
        localObject1 = localObject10;
        break;
        JSONObject localJSONObject = paramJSONObject.optJSONObject(df);
        localObject6 = localObject5;
        localObject7 = localObject4;
        localObject8 = localObject3;
        localObject9 = localObject2;
        localObject10 = localObject1;
        if (localJSONObject != null)
        {
          localObject10 = do.a(localJSONObject);
          localObject6 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          continue;
          localJSONObject = paramJSONObject.optJSONObject(cf);
          localObject6 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject3;
          localObject9 = localObject2;
          localObject10 = localObject1;
          if (localJSONObject != null)
          {
            localObject9 = dp.b(localJSONObject);
            localObject6 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject10 = localObject1;
            continue;
            localObject6 = localObject5;
            localObject7 = localObject4;
            localObject8 = localObject3;
            localObject9 = localObject2;
            localObject10 = localObject1;
            if (paramJSONObject.has(af))
            {
              localObject6 = Integer.valueOf(paramJSONObject.optInt(af));
              localObject7 = localObject4;
              localObject8 = localObject3;
              localObject9 = localObject2;
              localObject10 = localObject1;
              continue;
              localObject8 = StringUtils.emptyToNull(paramJSONObject.optString(bf));
              localObject6 = localObject5;
              localObject7 = localObject4;
              localObject9 = localObject2;
              localObject10 = localObject1;
              continue;
              localObject7 = StringUtils.emptyToNull(paramJSONObject.optString(ef));
              localObject6 = localObject5;
              localObject8 = localObject3;
              localObject9 = localObject2;
              localObject10 = localObject1;
            }
          }
        }
      }
    }
    return new dm((Integer)localObject5, (String)localObject4, (String)localObject3, (dp)localObject2, (do)localObject1);
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt(af, c);
      localJSONObject.putOpt(bf, e);
      localJSONObject.putOpt(ef, d);
      if (f != null) {
        localJSONObject.putOpt(cf, f.a());
      }
      if (a != null) {
        localJSONObject.putOpt(df, a.a());
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(b, "Caught exception creating wear device Json.", localJSONException);
    }
    return localJSONObject;
  }
}

/* Location:
 * Qualified Name:     bo.app.dm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */