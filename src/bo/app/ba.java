package bo.app;

import android.app.Activity;
import com.appboy.Constants;
import com.appboy.events.IEventSubscriber;
import com.appboy.support.AppboyLogger;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

public final class ba
  implements bd
{
  private static final String g = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, ba.class.getName() });
  public final ConcurrentMap<Activity, ConcurrentMap<Class, CopyOnWriteArraySet<IEventSubscriber>>> a = new ConcurrentHashMap();
  public final ConcurrentMap<Class, CopyOnWriteArraySet<IEventSubscriber>> b = new ConcurrentHashMap();
  public final ConcurrentMap<Class, CopyOnWriteArraySet<IEventSubscriber>> c = new ConcurrentHashMap();
  public final Object d = new Object();
  public final Object e = new Object();
  public final Object f = new Object();
  private final Executor h;
  
  public ba(Executor paramExecutor)
  {
    h = paramExecutor;
  }
  
  private static <T> CopyOnWriteArraySet<IEventSubscriber<T>> b(Class<T> paramClass, CopyOnWriteArraySet<IEventSubscriber> paramCopyOnWriteArraySet)
  {
    CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)paramCopyOnWriteArraySet;
    String str = g;
    new StringBuilder("Triggering ").append(paramClass.getName()).append(" on ").append(paramCopyOnWriteArraySet.size()).append(" subscribers.");
    return localCopyOnWriteArraySet;
  }
  
  public final <T> void a(T paramT, Class<T> paramClass)
  {
    Object localObject1 = g;
    new StringBuilder().append(paramClass.getName()).append(" fired: ").append(paramT.toString());
    localObject1 = a.entrySet().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)((ConcurrentMap)((Map.Entry)localObject2).getValue()).get(paramClass);
      if ((localCopyOnWriteArraySet != null) && (!localCopyOnWriteArraySet.isEmpty())) {
        ((Activity)((Map.Entry)localObject2).getKey()).runOnUiThread(new bb(this, paramClass, localCopyOnWriteArraySet, paramT));
      }
    }
    localObject1 = (CopyOnWriteArraySet)b.get(paramClass);
    if (localObject1 != null)
    {
      localObject1 = b(paramClass, (CopyOnWriteArraySet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IEventSubscriber)((Iterator)localObject1).next();
        h.execute(new bc(this, (IEventSubscriber)localObject2, paramT));
      }
    }
    localObject1 = (CopyOnWriteArraySet)c.get(paramClass);
    if (localObject1 != null)
    {
      paramClass = b(paramClass, (CopyOnWriteArraySet)localObject1).iterator();
      while (paramClass.hasNext()) {
        ((IEventSubscriber)paramClass.next()).trigger(paramT);
      }
    }
  }
  
  public final <T> boolean a(IEventSubscriber<T> paramIEventSubscriber, Class<T> paramClass)
  {
    boolean bool = false;
    for (;;)
    {
      synchronized (e)
      {
        ConcurrentMap localConcurrentMap = b;
        if (paramIEventSubscriber == null)
        {
          paramIEventSubscriber = paramClass.getName();
          AppboyLogger.e(g, String.format("Error: Attempted to add a null subscriber for eventClass %s. This subscriber is being ignored. Please check your calling code to ensure that all potential subscriptions are valid.", new Object[] { paramIEventSubscriber }));
          return bool;
        }
        CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)localConcurrentMap.get(paramClass);
        Object localObject1 = localCopyOnWriteArraySet;
        if (localCopyOnWriteArraySet == null)
        {
          localObject1 = new CopyOnWriteArraySet();
          paramClass = (CopyOnWriteArraySet)localConcurrentMap.putIfAbsent(paramClass, localObject1);
          if (paramClass != null) {
            localObject1 = paramClass;
          }
        }
        else
        {
          bool = ((CopyOnWriteArraySet)localObject1).add(paramIEventSubscriber);
        }
      }
    }
  }
  
  public final <T> boolean b(IEventSubscriber<T> paramIEventSubscriber, Class<T> paramClass)
  {
    synchronized (e)
    {
      paramClass = (CopyOnWriteArraySet)b.get(paramClass);
      if ((paramClass != null) && (paramIEventSubscriber != null) && (paramClass.remove(paramIEventSubscriber)))
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.ba
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */