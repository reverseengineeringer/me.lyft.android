package bo.app;

import com.appboy.Constants;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class j
  implements h
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, j.class.getName() });
  private final h b;
  
  public j(h paramh)
  {
    b = paramh;
  }
  
  private static String a(Map<String, String> paramMap)
  {
    Object localObject = new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (!((String)localEntry.getKey()).equals("X-Appboy-Api-Key")) {
        ((List)localObject).add(String.format("(%s / %s)", new Object[] { localEntry.getKey(), localEntry.getValue() }));
      }
    }
    paramMap = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramMap.append((String)((Iterator)localObject).next());
      paramMap.append(", ");
    }
    if (paramMap.length() == 0) {
      return "";
    }
    return paramMap.substring(0, paramMap.length() - 2);
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    try
    {
      String str = a;
      if (paramJSONObject == null) {}
      for (paramJSONObject = "none";; paramJSONObject = paramJSONObject.toString())
      {
        String.format("Result [%s]", new Object[] { paramJSONObject });
        return;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject = a;
    }
  }
  
  public final JSONObject a(URI paramURI, Map<String, String> paramMap)
  {
    try
    {
      String str1 = a;
      String.format("Making request to [%s], with headers: [%s]", new Object[] { paramURI.toString(), a(paramMap) });
      paramURI = b.a(paramURI, paramMap);
      a(paramURI);
      return paramURI;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = a;
      }
    }
  }
  
  public final JSONObject a(URI paramURI, Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    try
    {
      String str1 = a;
      String.format("Making request to [%s], with headers: [%s] and JSON parameters: [%s]", new Object[] { paramURI.toString(), a(paramMap), paramJSONObject.toString() });
      paramURI = b.a(paramURI, paramMap, paramJSONObject);
      a(paramURI);
      return paramURI;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = a;
      }
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */