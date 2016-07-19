package bo.app;

import com.appboy.Constants;
import java.util.HashSet;

public class bz
{
  public static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, bz.class.getName() });
  private static volatile bz f = null;
  public boolean b = false;
  public cx c;
  HashSet<cs> d = new HashSet();
  public final Object e = new Object();
  
  public static bz a()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new bz();
      }
      return f;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     bo.app.bz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */