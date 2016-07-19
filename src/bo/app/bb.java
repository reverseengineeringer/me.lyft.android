package bo.app;

import com.appboy.events.IEventSubscriber;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class bb
  implements Runnable
{
  bb(ba paramba, Class paramClass, CopyOnWriteArraySet paramCopyOnWriteArraySet, Object paramObject) {}
  
  public final void run()
  {
    Object localObject = d;
    localObject = ba.a(a, b).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IEventSubscriber)((Iterator)localObject).next()).trigger(c);
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.bb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */