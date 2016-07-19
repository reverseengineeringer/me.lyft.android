package bo.app;

import org.json.JSONArray;
import org.json.JSONObject;

public final class kd
{
  public static kf a(String paramString1, String paramString2, ke paramke)
  {
    paramke = new kj(paramke);
    paramString1 = kg.a(paramString1);
    paramString2 = kg.a(paramString2);
    if (((paramString1 instanceof JSONObject)) && ((paramString2 instanceof JSONObject))) {
      return paramke.a((JSONObject)paramString1, (JSONObject)paramString2);
    }
    if (((paramString1 instanceof JSONArray)) && ((paramString2 instanceof JSONArray))) {
      return paramke.a((JSONArray)paramString1, (JSONArray)paramString2);
    }
    if (((paramString1 instanceof kb)) && ((paramString2 instanceof kb)))
    {
      paramString1 = (kb)paramString1;
      paramString2 = (kb)paramString2;
      paramke = new kf();
      if (!paramString1.a().equals(paramString2.a())) {
        paramke.a("");
      }
      return paramke;
    }
    if ((paramString1 instanceof JSONObject)) {
      return new kf().a("", paramString1, paramString2);
    }
    return new kf().a("", paramString1, paramString2);
  }
}

/* Location:
 * Qualified Name:     bo.app.kd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */