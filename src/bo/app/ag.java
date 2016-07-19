package bo.app;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum ag
{
  private static final Map<String, ag> g;
  private final String h;
  
  static
  {
    g = new HashMap();
    Iterator localIterator = EnumSet.allOf(ag.class).iterator();
    while (localIterator.hasNext())
    {
      ag localag = (ag)localIterator.next();
      g.put(h, localag);
    }
  }
  
  private ag(String paramString)
  {
    h = paramString;
  }
}

/* Location:
 * Qualified Name:     bo.app.ag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */