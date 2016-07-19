package bolts;

import java.io.Closeable;

public class CancellationTokenRegistration
  implements Closeable
{
  private Runnable action;
  private boolean closed;
  private final Object lock;
  private CancellationTokenSource tokenSource;
  
  public void close()
  {
    synchronized (lock)
    {
      if (closed) {
        return;
      }
      closed = true;
      tokenSource.unregister(this);
      tokenSource = null;
      action = null;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     bolts.CancellationTokenRegistration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */