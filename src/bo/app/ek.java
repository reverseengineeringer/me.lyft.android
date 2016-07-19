package bo.app;

import android.net.Uri;
import com.appboy.Constants;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class ek
  implements ef
{
  private static final String b = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, ek.class.getName() });
  public final Uri a;
  private Map<String, String> c;
  
  public ek(Uri paramUri, Map<String, String> paramMap)
  {
    c = paramMap;
    a = Uri.parse(paramUri + g());
  }
  
  private String g()
  {
    if ((c == null) || (c.size() == 0)) {
      return "";
    }
    Iterator localIterator = c.keySet().iterator();
    String str2;
    for (String str1 = "?"; localIterator.hasNext(); str1 = str1 + str2 + "=" + (String)c.get(str2) + "&") {
      str2 = (String)localIterator.next();
    }
    return str1.substring(0, str1.length() - 1);
  }
  
  public Uri b()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     bo.app.ek
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */