package bo.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class kg
{
  public static Object a(String paramString)
  {
    if (paramString.trim().startsWith("{")) {
      return new JSONObject(paramString);
    }
    if (paramString.trim().startsWith("[")) {
      return new JSONArray(paramString);
    }
    if ((paramString.trim().startsWith("\"")) || (paramString.trim().matches("-?(?:0|[1-9]\\d*)(?:\\.\\d+)?(?:[eE][+-]?\\d+)?"))) {
      return new kh(paramString);
    }
    throw new JSONException("Unparsable JSON string: " + paramString);
  }
}

/* Location:
 * Qualified Name:     bo.app.kg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */