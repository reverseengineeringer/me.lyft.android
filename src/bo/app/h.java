package bo.app;

import java.net.URI;
import java.util.Map;
import org.json.JSONObject;

public abstract interface h
{
  public abstract JSONObject a(URI paramURI, Map<String, String> paramMap);
  
  public abstract JSONObject a(URI paramURI, Map<String, String> paramMap, JSONObject paramJSONObject);
}

/* Location:
 * Qualified Name:     bo.app.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */