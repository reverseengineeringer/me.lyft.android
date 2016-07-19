package bo.app;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public final class ca
  implements Runnable
{
  public ca(bz parambz, ez paramez, n paramn, by paramby) {}
  
  public final void run()
  {
    bz.b();
    Collection localCollection = a.b();
    Object localObject3;
    synchronized (d.e)
    {
      bz.a(d, localCollection);
      if (bz.a(d) != null)
      {
        if (bz.b(d).size() == 0) {
          break label133;
        }
        bz.b();
        localObject3 = bz.b(d).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label133;
        }
        cs localcs = (cs)((Iterator)localObject3).next();
        bz.a(d).a(localcs);
        a.a(bz.a(d), localcs);
      }
    }
    bz.b();
    label133:
    Iterator localIterator = ((Collection)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject3 = (cx)localIterator.next();
      b.a((cx)localObject3);
    }
    c.a(ab.e);
    bz.c(d);
    bz.b();
  }
}

/* Location:
 * Qualified Name:     bo.app.ca
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */