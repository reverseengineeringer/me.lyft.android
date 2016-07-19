package bolts;

import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

public class CancellationTokenSource
  implements Closeable
{
  private boolean cancellationRequested;
  private boolean closed;
  private final Object lock;
  private final List<CancellationTokenRegistration> registrations;
  private ScheduledFuture<?> scheduledCancellation;
  
  private void cancelScheduledCancellation()
  {
    if (scheduledCancellation != null)
    {
      scheduledCancellation.cancel(true);
      scheduledCancellation = null;
    }
  }
  
  private void throwIfClosed()
  {
    if (closed) {
      throw new IllegalStateException("Object already closed");
    }
  }
  
  public void close()
  {
    synchronized (lock)
    {
      if (closed) {
        return;
      }
      cancelScheduledCancellation();
      Iterator localIterator = registrations.iterator();
      if (localIterator.hasNext()) {
        ((CancellationTokenRegistration)localIterator.next()).close();
      }
    }
    registrations.clear();
    closed = true;
  }
  
  public boolean isCancellationRequested()
  {
    synchronized (lock)
    {
      throwIfClosed();
      boolean bool = cancellationRequested;
      return bool;
    }
  }
  
  public String toString()
  {
    return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] { getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(isCancellationRequested()) });
  }
  
  void unregister(CancellationTokenRegistration paramCancellationTokenRegistration)
  {
    synchronized (lock)
    {
      throwIfClosed();
      registrations.remove(paramCancellationTokenRegistration);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     bolts.CancellationTokenSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */