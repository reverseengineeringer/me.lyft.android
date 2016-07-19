package bo.app;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class kf
{
  public boolean a = true;
  private StringBuilder b = new StringBuilder("");
  private String c;
  private Object d;
  private Object e;
  private final List<kc> f = new ArrayList();
  
  public kf()
  {
    this((byte)0);
  }
  
  private kf(byte paramByte) {}
  
  private static String a(Object paramObject)
  {
    if ((paramObject instanceof JSONArray)) {
      return "a JSON array";
    }
    if ((paramObject instanceof JSONObject)) {
      return "a JSON object";
    }
    return paramObject.toString();
  }
  
  public final kf a(String paramString, Object paramObject)
  {
    a(paramString + "\nExpected: " + a(paramObject) + "\n     but none found\n");
    return this;
  }
  
  public final kf a(String paramString, Object paramObject1, Object paramObject2)
  {
    f.add(new kc(paramString, paramObject1, paramObject2));
    c = paramString;
    d = paramObject1;
    e = paramObject2;
    a(paramString + "\nExpected: " + a(paramObject1) + "\n     got: " + a(paramObject2) + "\n");
    return this;
  }
  
  public final void a(String paramString)
  {
    a = false;
    if (b.length() == 0)
    {
      b.append(paramString);
      return;
    }
    b.append(" ; ").append(paramString);
  }
  
  public final kf b(String paramString, Object paramObject)
  {
    a(paramString + "\nUnexpected: " + a(paramObject) + "\n");
    return this;
  }
  
  public final String toString()
  {
    return b.toString();
  }
}

/* Location:
 * Qualified Name:     bo.app.kf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */