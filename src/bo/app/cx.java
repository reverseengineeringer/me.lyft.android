package bo.app;

import com.appboy.Constants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class cx
{
  public static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, cx.class.getName() });
  public final ConcurrentLinkedQueue<cs> b;
  public final ConcurrentLinkedQueue<cs> c;
  public final db d;
  public final double e;
  public volatile cq<Void> f;
  public volatile cq<Double> g;
  public volatile boolean h = false;
  public final Object i = new Object();
  
  public cx(db paramdb, double paramDouble)
  {
    this(paramdb, paramDouble, null, new cp(Collections.emptySet()), true, false, false);
  }
  
  public cx(db paramdb, double paramDouble, Double paramDouble1, cp paramcp, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    d = paramdb;
    e = paramDouble;
    if (!paramBoolean1) {
      bool = true;
    }
    f = new cq(null, bool);
    g = new cq(paramDouble1, paramBoolean3);
    b = new ConcurrentLinkedQueue(a);
    c = new ConcurrentLinkedQueue();
    h = paramBoolean2;
  }
  
  private static boolean a(cq paramcq)
  {
    return (paramcq != null) && (!a) && (!b);
  }
  
  private cq<Double> h()
  {
    synchronized (i)
    {
      cq localcq = g;
      return localcq;
    }
  }
  
  private cq<Void> i()
  {
    synchronized (i)
    {
      cq localcq = f;
      return localcq;
    }
  }
  
  private ConcurrentLinkedQueue<cs> j()
  {
    synchronized (i)
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue = b;
      return localConcurrentLinkedQueue;
    }
  }
  
  public final Double a()
  {
    synchronized (i)
    {
      Double localDouble = (Double)g.a();
      return localDouble;
    }
  }
  
  public final void a(Double paramDouble)
  {
    synchronized (i)
    {
      g.a(paramDouble);
      return;
    }
  }
  
  public final boolean a(cs paramcs)
  {
    synchronized (i)
    {
      b.add(paramcs);
      return true;
    }
  }
  
  public final boolean b()
  {
    synchronized (i)
    {
      boolean bool = f.b;
      return bool;
    }
  }
  
  public final boolean c()
  {
    synchronized (i)
    {
      boolean bool = h;
      return bool;
    }
  }
  
  public final boolean d()
  {
    synchronized (i)
    {
      boolean bool = g.b;
      return bool;
    }
  }
  
  public final cp e()
  {
    synchronized (i)
    {
      Object localObject2 = new HashSet();
      ((Set)localObject2).addAll(b);
      ((Set)localObject2).addAll(c);
      localObject2 = new cp((Set)localObject2);
      return (cp)localObject2;
    }
  }
  
  public final cr f()
  {
    synchronized (i)
    {
      boolean bool = a(i());
      if (bool) {
        f.b();
      }
      if ((h) && (a(h()))) {}
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          g.b();
        }
        double d1 = e;
        if (j == 0) {
          break;
        }
        localObject1 = a();
        localObject1 = new cr(this, Double.valueOf(d1), (Double)localObject1, new HashSet(j()), d, bool);
        c.addAll(b);
        b.clear();
        return (cr)localObject1;
      }
      Object localObject1 = null;
    }
  }
  
  public final boolean g()
  {
    synchronized (i)
    {
      if ((d()) && (b()) && (ea.isEmpty()))
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.cx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */