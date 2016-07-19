package bo.app;

import com.appboy.configuration.XmlAppConfigurationProvider;
import com.appboy.support.StringUtils;
import java.util.HashMap;
import java.util.Map;

public final class f
  implements i
{
  public String a;
  private final cj b;
  private final XmlAppConfigurationProvider c;
  private String d;
  private String e;
  
  public f(XmlAppConfigurationProvider paramXmlAppConfigurationProvider, cj paramcj)
  {
    c = paramXmlAppConfigurationProvider;
    b = paramcj;
  }
  
  private String b()
  {
    try
    {
      if (d == null) {
        d = b.e();
      }
      String str = d;
      return str;
    }
    finally {}
  }
  
  private String c()
  {
    try
    {
      if (e == null) {
        e = c.getAppboyApiKey().toString();
      }
      String str = e;
      return str;
    }
    finally {}
  }
  
  public final Map<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Accept-Encoding", "gzip, deflate");
    localHashMap.put("Content-Type", "application/json");
    if (c() != null) {
      localHashMap.put("X-Appboy-Api-Key", c());
    }
    if (!StringUtils.isNullOrBlank(a)) {
      localHashMap.put("X-Appboy-User-Identifier", a);
    }
    localHashMap.put("X-Appboy-Device-Identifier", b());
    return localHashMap;
  }
}

/* Location:
 * Qualified Name:     bo.app.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */