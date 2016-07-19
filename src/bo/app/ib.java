package bo.app;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public final class ib
{
  final hw a;
  Executor b;
  public Executor c;
  public Executor d;
  public final Map<Integer, String> e = Collections.synchronizedMap(new HashMap());
  final AtomicBoolean f = new AtomicBoolean(false);
  final AtomicBoolean g = new AtomicBoolean(false);
  final AtomicBoolean h = new AtomicBoolean(false);
  final Object i = new Object();
  private final Map<String, ReentrantLock> j = new WeakHashMap();
  
  ib(hw paramhw)
  {
    a = paramhw;
    b = g;
    c = h;
    d = Executors.newCachedThreadPool(hq.a(5, "uil-pool-d-"));
  }
  
  private Executor b()
  {
    return hq.a(a.k, a.l, a.m);
  }
  
  final String a(jm paramjm)
  {
    return (String)e.get(Integer.valueOf(paramjm.f()));
  }
  
  public final ReentrantLock a(String paramString)
  {
    ReentrantLock localReentrantLock2 = (ReentrantLock)j.get(paramString);
    ReentrantLock localReentrantLock1 = localReentrantLock2;
    if (localReentrantLock2 == null)
    {
      localReentrantLock1 = new ReentrantLock();
      j.put(paramString, localReentrantLock1);
    }
    return localReentrantLock1;
  }
  
  public final void a()
  {
    if ((!a.i) && (((ExecutorService)b).isShutdown())) {
      b = b();
    }
    if ((!a.j) && (((ExecutorService)c).isShutdown())) {
      c = b();
    }
  }
  
  public final void b(jm paramjm)
  {
    e.remove(Integer.valueOf(paramjm.f()));
  }
}

/* Location:
 * Qualified Name:     bo.app.ib
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */