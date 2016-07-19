package bo.app;

import com.appboy.Constants;
import com.appboy.models.outgoing.Environment;
import com.appboy.support.AppboyLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

public final class w
  implements y
{
  private static final String c = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, w.class.getName() });
  public final LinkedBlockingQueue<ee> a;
  public ch b;
  private final cj d;
  private final fd e;
  private final ConcurrentHashMap<String, cx> f;
  
  public w(fd paramfd, cj paramcj)
  {
    e = paramfd;
    d = paramcj;
    f = new ConcurrentHashMap();
    a = new LinkedBlockingQueue(1000);
  }
  
  private ee b(ee paramee)
  {
    Object localObject;
    if (paramee == null) {
      localObject = null;
    }
    for (;;)
    {
      return (ee)localObject;
      try
      {
        localObject = c;
        localObject = f.values();
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((Collection)localObject).iterator();
        while (localIterator.hasNext())
        {
          cx localcx = (cx)localIterator.next();
          cr localcr = localcx.f();
          String str = c;
          localcr.b().toString();
          localArrayList.add(localcr);
          ((Collection)localObject).remove(localcx);
        }
        paramee.a(new dk(localArrayList, d.c(), (dl)e.b()));
      }
      finally {}
      localObject = paramee;
      if (d.d() != null)
      {
        paramee.a(d.d().dispatch());
        localObject = paramee;
      }
    }
  }
  
  public final ee a()
  {
    ee localee = (ee)a.take();
    try
    {
      if (b != null) {
        b.b();
      }
      return b(localee);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = c;
      }
    }
  }
  
  public final void a(cx paramcx)
  {
    if (paramcx == null) {
      throw new NullPointerException();
    }
    f.putIfAbsent(d.toString(), paramcx);
  }
  
  public final void a(ee paramee)
  {
    if (paramee == null) {
      throw new NullPointerException();
    }
    AppboyLogger.i(c, String.format("Adding request to dispatcher with parameters: %s", new Object[] { String.valueOf(paramee.e()) }));
    a.add(paramee);
  }
}

/* Location:
 * Qualified Name:     bo.app.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */