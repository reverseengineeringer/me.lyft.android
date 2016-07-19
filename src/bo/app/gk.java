package bo.app;

import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;

public class gk
  extends gm
  implements gh
{
  private static final String b = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, gk.class.getName() });
  public String a;
  
  public gk() {}
  
  public gk(String paramString)
  {
    a = a(paramString);
  }
  
  private static String a(String paramString)
  {
    if (StringUtils.isNullOrBlank(paramString)) {
      return null;
    }
    try
    {
      String str = new String(android.util.Base64.decode(paramString, 0)).split("_")[0];
      return str;
    }
    catch (Exception localException)
    {
      AppboyLogger.e(b, String.format("Unexpected error decoding Base64 encoded campaign Id %s", new Object[] { paramString }), localException);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     bo.app.gk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */